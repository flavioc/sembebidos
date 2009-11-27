package org.sunspotworld;

import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.Datagram;

public class Connection
{
    private static final int HOST_PORT = 67;
    public static final int SEND = 0;
    public static final int RECEIVE = 1;
    private RadiogramConnection conn = null;
    private Datagram dg;
    public Connection (int val)
    {
        try {
            if (val == SEND)
                conn = (RadiogramConnection) Connector.open("radiogram://broadcast:" + HOST_PORT);
            else conn = (RadiogramConnection) Connector.open("radiogram://:" + HOST_PORT);
        } catch (Exception e) {
            System.err.println("Caught " + e + " in connection initialization.");
            System.exit(1);
        }
    }

    public void send (Message msg)
    {
        if(msg != null)
            msg.send(conn);
    }

    public int[] spotReceive () {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            conn.setTimeout(0);
            conn.receive(dg);

            int msg_type = dg.readInt();

            if(msg_type != Message.CHANGE_VALUES)
                return null;
            
            int what = dg.readInt();
            int period = dg.readInt() * 1000;

            int[] ret = new int[2];

            ret[0] = what;
            ret[1] = period;

            return ret;
            
        } catch (IOException ex) {
            return null;
        }
    }

    public void close()
    {
        try {
            conn.close();
        } catch (IOException ex) {
        }
    }
}