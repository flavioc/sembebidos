/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;
import java.io.IOException;
import javax.microedition.io.Datagram;
import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
import com.sun.spot.peripheral.radio.RadioFactory;

/**
 *
 * @author flaviocruz
 */
public class Message {
    public final static int LUMINOSITY = 0;
    public final static int MOVEMENT = 1;
    public final static int TEMPERATURE = 2;

    private int type;
    private long address;
    private long timestamp;
    private int iData1;
    private double dData1, dData2;

    public Message(final double d1, final double d2)
    {
        this.type = MOVEMENT;
        this.dData1 = d1;
        this.dData2 = d2;
    }

    public Message(final int val)
    {
        this.type = LUMINOSITY;
        this.iData1 = val;
    }

    public Message(final double val)
    {
        this.type = TEMPERATURE;
        this.dData1 = val;
    }

    public void send(RadiogramConnection conn)
    {
        try {
            Datagram dg = conn.newDatagram(conn.getMaximumLength());
            dg.writeLong(RadioFactory.getRadioPolicyManager().getIEEEAddress());
            dg.writeLong(System.currentTimeMillis());
            dg.writeInt(type);
            
            switch(type) {
                case LUMINOSITY:
                    dg.writeInt(iData1);
                    break;
                case MOVEMENT:
                    dg.writeDouble(dData1);
                    dg.writeDouble(dData2);
                    break;
                case TEMPERATURE:
                    dg.writeDouble(dData1);
                    break;
            }
            
            conn.send(dg);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
