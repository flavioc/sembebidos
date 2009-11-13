package org.sunspotworld;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class StartApplication extends MIDlet {
    private Connection conn = new Connection(0);
    private Sinalize sin = new Sinalize();
    
    private LuminosityReader lightReader = new LuminosityReader(conn, sin);
    private TemperatureReader tempReader = new TemperatureReader(conn, sin);
    private MovementReader movReader = new MovementReader(conn, sin);
    private SpotListen spotListen = new SpotListen(lightReader, tempReader, movReader);

    protected void startApp() throws MIDletStateChangeException {
        /* start readers */
        spotListen.start();
        tempReader.start();
        lightReader.start();
        movReader.start();
    }

    protected void pauseApp() {}
    
    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {}
}
