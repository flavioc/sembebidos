/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;
import java.io.IOException;
import javax.microedition.io.Datagram;
import com.sun.spot.io.j2me.radiogram.RadiogramConnection;

/**
 *
 * @author flaviocruz
 */
public class Message {
    public final static int LUMINOSITY = 0;
    public final static int MOVEMENT = 1;
    public final static int TEMPERATURE = 2;
    public final static int CHANGE_VALUES = 0;
    public final static int SENSOR = 1;

    private int type;
    private long address;
    private String addressString;
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

    public Message(RadiogramConnection conn) throws IOException, Exception
    {
        Datagram dg = conn.newDatagram(conn.getMaximumLength());
        conn.receive(dg);
        
        int msg_type = dg.readInt();

        if(msg_type != SENSOR)
            throw new Exception("not a sensor message");
        
        addressString = dg.getAddress();
        address = dg.readLong();

        //Long.toHexString(dg.readLong())
        timestamp = dg.readLong();
        type = dg.readInt();

        switch(type) {
            case LUMINOSITY:
                iData1 = dg.readInt();
                break;
            case MOVEMENT:
                dData1 = dg.readDouble();
                dData2 = dg.readDouble();
                break;
            case TEMPERATURE:
                dData1 = dg.readDouble();
                break;
        }
    }

    public long getAddress()
    {
        return address;
    }

    @Override
    public String toString()
    {
        String reading = "";

        switch(type) {
            case LUMINOSITY:
                reading = "Luminosity";
                break;
            case MOVEMENT:
                reading = "Movement";
                break;
            case TEMPERATURE:
                reading = "Temperature";
                break;
        }

        String val = "";
        switch(type) {
            case LUMINOSITY:
                val = "" + iData1 + " w/m2";
                break;
            case TEMPERATURE:
                val = "" + dData1 + " C";
                break;
            case MOVEMENT:
                val = "(" + dData1 + "G, " + dData2 + "G)";
                break;
        }

        return reading + " from " + addressString + ": " + val;
    }
}
