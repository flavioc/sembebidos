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
    public void run()
    {
        while(true) {
            sconn.hostSend(0, 12345);
            rconn.hostReceive();
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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SunSpotWindow().setVisible(true);
            }
        });
        app.run();
        
    }
}