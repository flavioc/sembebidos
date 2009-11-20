/*
 * SunSpotHostApplication.java
 *
 * Created on 6/Nov/2009 12:04:20;
 */

package org.sunspotworld;

import com.sun.spot.util.Utils;

public class SunSpotHostApplication {

    private Connection sconn = new Connection(Connection.SEND);
    private Connection rconn = new Connection(Connection.RECEIVE);
    private static SunSpotWindow window = null;
    private static final int TIME_SLEEP = 500;

    public void run()
    {
        while(true) {
            Message m = rconn.hostReceive();
            if(m != null)
                window.addMessage(m);
            else
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