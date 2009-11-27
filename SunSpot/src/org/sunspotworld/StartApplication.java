package org.sunspotworld;

import com.sun.spot.util.Utils;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class StartApplication extends MIDlet {
    private Connection conn = new Connection(Connection.SEND);
    private Sinalize sin = new Sinalize();
    
    private LuminosityReader lightReader = new LuminosityReader(conn, sin);
    private TemperatureReader tempReader = new TemperatureReader(conn, sin);
    private MovementReader movReader = new MovementReader(conn, sin);
    private SpotListen spotListen = null;

    protected void startApp() throws MIDletStateChangeException {
        spotListen = new SpotListen(lightReader, movReader, tempReader);
        spotListen.start();
        
        /* start readers */
        lightReader.start();
        movReader.start();
        tempReader.start();
    }

    protected void pauseApp() {
    }
    
    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        spotListen.stop();
        lightReader.stop();
        tempReader.stop();
        movReader.stop();
     
        
        conn.close();
        Utils.sleep(800); // without the sleep, cleanup routines are not done properly
    }
}
