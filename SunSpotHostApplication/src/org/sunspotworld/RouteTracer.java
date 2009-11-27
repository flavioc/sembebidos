package org.sunspotworld;

import com.sun.spot.networktools.NetManagementServer;
import com.sun.spot.peripheral.radio.LowPan;
import com.sun.spot.peripheral.radio.mhrp.aodv.Constants;
import com.sun.spot.peripheral.radio.routing.RouteInfo;
import com.sun.spot.peripheral.radio.routing.interfaces.IRoutingManager;
import com.sun.spot.peripheral.radio.routing.interfaces.RouteEventClient;
import com.sun.spot.util.IEEEAddress;
import java.io.IOException;

public class RouteTracer implements RouteEventClient {
    private RouteInfo nextRouteInfo;

    public void traceRouteTo(IEEEAddress address) throws IOException, InterruptedException
    {
        IRoutingManager routingManager = LowPan.getInstance().getRoutingManager();
        routingManager.findRoute(address.asLong(), this, this);

        synchronized (this) {
            this.wait();
        }

        if(nextRouteInfo.nextHop == Constants.INVALID_NEXT_HOP) {
            System.out.println("Can't find a route to " + address);
            return;
        }

        boolean allDone = false;
        int hop = 1;

        while(!allDone) {
            System.out.println("Hop " + (hop++) + ": " + new IEEEAddress(nextRouteInfo.nextHop));

            if(nextRouteInfo.nextHop == address.asLong()) {
                break;
            }

            String nextHop = NetManagementServer.requestRoute(nextRouteInfo.nextHop, address.asLong());
            if(nextHop != null) {
                nextRouteInfo = RouteInfo.fromString(nextHop);
            } else {
                System.out.println("Error getting route from " + IEEEAddress.toDottedHex(nextRouteInfo.nextHop));
                allDone = true;
            }
        }

        System.out.println("Route done");
    }

    public void routeFound(RouteInfo info, Object uniqueKey) {
        nextRouteInfo = info;
        synchronized(this) {
            this.notify();
        }
    }
}
