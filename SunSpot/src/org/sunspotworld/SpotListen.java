package org.sunspotworld;

import java.util.Vector;


public class SpotListen extends PeriodicTask {
    private Connection rconn = new Connection(Connection.RECEIVE); // conecção em mode de leitura
    private LuminosityReader lr = null;
    private TemperatureReader tr = null;
    private MovementReader mr = null;
    public static int READ_PERIOD = 1000;          // periodo para verificar input
    private Vector tasks = new Vector();

    public void doTask() {
        
        if(!tasks.isEmpty()) {
            int i;
            for(i = 0; i < tasks.size(); ++i) {
                PeriodicTask task = (PeriodicTask)tasks.elementAt(i);

                task.resume();
            }
            tasks.removeAllElements();
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
                        task = lr; break;
                    case Message.TEMPERATURE:
                        task = tr; break;
                    case Message.MOVEMENT:
                        task = mr; break;
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

    public void stopping()
    {
        rconn.close();
    }

    public SpotListen (LuminosityReader l, TemperatureReader t, MovementReader m) {
        super(0, READ_PERIOD);
        lr = l;
        tr = t;
        mr = m;
    }
}
