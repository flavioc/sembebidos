/*
 * SunSpotHostApplication.java
 *
 * Created on 6/Nov/2009 12:04:20;
 */

package org.sunspotworld;

import com.sun.spot.peripheral.radio.RadioFactory;
import com.sun.spot.peripheral.radio.IRadioPolicyManager;
import com.sun.spot.io.j2me.radiostream.*;
import com.sun.spot.io.j2me.radiogram.*;
import com.sun.spot.util.IEEEAddress;

import java.io.*;
import javax.microedition.io.*;


/**
 * Sample Sun SPOT host application
 */
public class SunSpotHostApplication {

    private Connection sconn = new Connection(Connection.SEND);
    private Connection rconn = new Connection(Connection.RECEIVE);

    /**
     * Print out our radio address.
     */
    public void run() {
        long ourAddr = RadioFactory.getRadioPolicyManager().getIEEEAddress();
        System.out.println("Our radio address = " + IEEEAddress.toDottedHex(ourAddr));
        //System.exit(0);

        try {
            conn = (RadiogramConnection)Connector.open("radiogram://:" + HOST_PORT);
            dg = conn.newDatagram(conn.getMaximumLength());
        } catch (Exception e) {
            System.err.println("error " + e.getMessage());
            System.exit(1);
        }

        while(true) {
            try {
                conn.receive(dg);
                long x = dg.readLong();
                x = x | 0x000000000000ffff;
                System.out.println(x);
            } catch(Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }
    }

    /**
     * Start up the host application.
     *
     * @param args any command line arguments
     */
    public static void main(String[] args)
    {
        SunSpotHostApplication app = new SunSpotHostApplication();
        System.out.println("OLA");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("ESTOU AQUI");
                new SunSpotWindow().setVisible(true);
            }
        });
        app.run();
        
    }
}