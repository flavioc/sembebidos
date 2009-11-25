/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;

import java.util.Vector;

public class SpotListen extends PeriodicTask {

    private Connection rconn = new Connection(Connection.RECEIVE); // conecção em mode de leitura
    private static final int READ_PERIOD = 1000;
    private LuminosityReader lr = null;
    private MovementReader mr = null;
    private TemperatureReader tr = null;
    private Vector tasks = new Vector();

    public void doTask() {
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

    public void stopping() {
        rconn.close();
    }

    public SpotListen(LuminosityReader lr, MovementReader mr, TemperatureReader tr)
    {
        super(0, READ_PERIOD);
        this.lr = lr;
        this.mr = mr;
        this.tr = tr;
    }
}
