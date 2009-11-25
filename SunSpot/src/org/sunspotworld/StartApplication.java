package org.sunspotworld;

import com.sun.spot.util.Utils;
import java.util.Vector;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class StartApplication extends MIDlet {
    private Connection conn = new Connection(Connection.SEND);
    private Connection rconn = new Connection(Connection.RECEIVE); // conecção em mode de leitura
    private Sinalize sin = new Sinalize();
    
    private LuminosityReader lightReader = new LuminosityReader(conn, sin);
    private TemperatureReader tempReader = new TemperatureReader(conn, sin);
    private MovementReader movReader = new MovementReader(conn, sin);
    public static int READ_PERIOD = 1000;          // periodo para verificar input
    private Vector tasks = new Vector();

    private void listenLoop()
    {
      if(!tasks.isEmpty()) {
            int i;
            Vector toRemove = new Vector();
            
            for(i = 0; i < tasks.size(); ++i) {
                PeriodicTask task = (PeriodicTask)tasks.elementAt(i);

                if(task.resume()) {
                    System.out.println("Task " + i + " going to be removed");
                    toRemove.addElement(task);
                }
            }

            for(i = 0; i < toRemove.size(); ++i) {
                tasks.removeElement(toRemove.elementAt(i));
            }
        }

        while(true) {
            int[] data = rconn.spotReceive();

            if(data != null) {
                int type = data[0];
                int period = data[1];

                System.out.println("New period: " + type + " " + period);

                PeriodicTask task = null;

                switch(type) {
                    case Message.LUMINOSITY:
                        task = lightReader; break;
                    case Message.TEMPERATURE:
                        task = tempReader; break;
                    case Message.MOVEMENT:
                        task = movReader; break;
                }

                if(task != null) {
                    task.pause();
                    task.setTaskPeriod(period);
                    tasks.addElement(task);
                }
            } else
                return;
        }
    }

    protected void startApp() throws MIDletStateChangeException {
        /* start readers */
        lightReader.start();
        movReader.start();
        tempReader.start();

        while(true) {
            listenLoop();
            Utils.sleep(READ_PERIOD);
        }
    }

    protected void pauseApp() {
    }
    
    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
        lightReader.stop();
        tempReader.stop();
        movReader.stop();
        conn.close();
        Utils.sleep(500); // without the sleep, cleanup routines are not done properly
    }
}
