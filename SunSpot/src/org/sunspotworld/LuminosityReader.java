package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.ILightSensor;
import com.sun.spot.util.Utils;
import java.io.IOException;

public class LuminosityReader extends PeriodicTask {
    private static int LUMINOSITY_PERIOD = 3000; // 3 seconds
    private static final int DELTA = 5;
    private static int lastValue = 0;
    private ILightSensor lightSensor = EDemoBoard.getInstance().getLightSensor();
    private Connection conn;
    private Sinalize sin = null;
    
    public void doTask() {
        try {
            sin.setOn(0);
            int val = lightSensor.getValue();
            if (val >lastValue-DELTA && val<lastValue+DELTA)
                System.out.println("Luminosity in DELTA");
            else {
                conn.send(new Message(val));
                lastValue = val;
            }
            System.out.println("Light sensor: " + val);
            Utils.sleep(500);
            sin.setOff(0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public LuminosityReader(Connection c, Sinalize s) {
        super(2, LUMINOSITY_PERIOD);
        conn = c;
        sin = s;
    }
}
