package org.sunspotworld;

import com.sun.spot.util.Utils;
import com.sun.spot.peripheral.radio.LowPan;
import com.sun.spot.peripheral.radio.mhrp.lqrp.LQRPManager;
import com.sun.spot.peripheral.radio.routing.RouteInfo;
import com.sun.spot.peripheral.radio.routing.RouteTable;
import com.sun.spot.peripheral.radio.routing.interfaces.IRoutingManager;

public class SunSpotHostApplication {

    private Connection sconn = new Connection(Connection.SEND);
    private Connection rconn = new Connection(Connection.RECEIVE);
    private static SunSpotWindow window = null;
    private static final int TIME_SLEEP = 500;

    public void run()
    {
        LowPan.getInstance().setRoutingManager(LQRPManager.getInstance());
        IRoutingManager aodv = LowPan.getInstance().getRoutingManager();
        LQRPManager manager = (LQRPManager)aodv;

        while(true) {
            
            Message m = rconn.hostReceive();
            if(m != null) {
                window.addMessage(m);
                RouteTable rt = aodv.getRoutingTable();
                System.out.println("ROUTE TABLE:");
                System.out.println(rt.toString());
                RouteInfo info = aodv.getRouteInfo(m.getAddress());
                System.out.println("ROUTE INFO: " + info.toString());
            } else
                Utils.sleep(TIME_SLEEP);

            
        }
    }

    public Connection getSConnection()
    {
        return sconn;
    }

    /**
     * Start up the host application.
     *
     * @param args any command line arguments
     */
    public static void main(String[] args)
    {
        SunSpotHostApplication app = new SunSpotHostApplication();
        final Connection sconn = app.getSConnection();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                window = new SunSpotWindow(sconn);
                window.setVisible(true);
            }
        });
        
        app.run();
        
    }
}