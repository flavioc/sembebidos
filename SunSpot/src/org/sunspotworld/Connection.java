package org.sunspotworld;


import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import com.sun.spot.peripheral.radio.RadioFactory;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.Datagram;

public class Connection {
    private static final int HOST_PORT = 67;
    public static final int SEND = 0;
    public static final int RECEIVE = 1;

    private RadiogramConnection conn = null;
    private Datagram dg;
    private long mac;

    public Connection (int val) {
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

    public void send (Message msg) {
        msg.send(conn);
    }

    public void hostSend (int type, int newValue) {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            dg.writeInt(type);
            dg.writeInt(newValue);
            conn.send(dg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void hostReceive () {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            conn.receive(dg);
            System.out.println(dg.getAddress());
            System.out.print("From: "+dg.getAddress());
            System.out.print(", timestamp "+dg.readLong());

            switch(dg.readInt()){
                case 0:
                    System.out.println(" luminosity is "+dg.readInt());
                    break;
                case 1:
                    System.out.println(" temperature is "+dg.readDouble());
                    break;
                case 2:
                    System.out.println(" X acceleration is "+dg.readDouble());
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void spotReceive (LuminosityReader l, TemperatureReader t, MovementReader m) {
        try {
            dg = conn.newDatagram(conn.getMaximumLength());
            conn.receive(dg);
            conn.setTimeout(1000);
            int type = dg.readInt();
            int val = dg.readInt();
            System.out.println("NEW TASK PERIOD " + val);
            switch (type) {
                case 0:
                    l.setTaskPeriod(val);
                    break;
                case 1:
                    t.setTaskPeriod(val);
                    break;
                case 2:
                    m.setTaskPeriod(val);
                    break;
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}