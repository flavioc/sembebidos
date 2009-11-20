package org.sunspotworld;

import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import com.sun.spot.peripheral.radio.RadioFactory;
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
    private long mac;

    public Connection (int val)
    {
        try {
            mac = RadioFactory.getRadioPolicyManager().getIEEEAddress();
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
        msg.send(conn);
    }

    public Message hostReceive ()
    {
        try {
            return new Message(conn);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public void hostSend(int type, int newValue)
    {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            dg.writeInt(type);
            dg.writeInt(newValue);
            conn.send(dg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void spotReceive (LuminosityReader l, TemperatureReader t, MovementReader m) {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            conn.receive(dg);
            conn.setTimeout(1000);
            int period = dg.readInt() * 1000;
            switch (dg.readInt()) {
                case 0:
                    l.stop();
                    l.setTaskPeriod(period);
                    l.start();
                    break;
                case 1:
                    t.stop();
                    t.setTaskPeriod(period);
                    t.start();
                    break;
                case 2:
                    m.stop();
                    m.setTaskPeriod(period);
                    m.start();
                    break;
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
