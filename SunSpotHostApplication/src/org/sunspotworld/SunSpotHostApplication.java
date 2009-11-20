/*
 * SunSpotHostApplication.java
 *
 * Created on 6/Nov/2009 12:04:20;
 */

package org.sunspotworld;

public class SunSpotHostApplication {

    private Connection sconn = new Connection(Connection.SEND);
    private Connection rconn = new Connection(Connection.RECEIVE);
    private static SunSpotWindow window = null;

    /**
     * Print out our radio address.
     */
    public void run()
    {
        while(true) {
            sconn.hostSend(0, 12345);
            Message m = rconn.hostReceive();
            if(m != null)
                window.addMessage(m);
                
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