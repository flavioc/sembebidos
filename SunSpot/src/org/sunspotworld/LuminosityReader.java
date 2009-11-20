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

    public void doTask()
    {
        try {
            sin.setOn(Message.LUMINOSITY);
            int val = lightSensor.getValue();

            if(MyUtils.betweenIntervalIntDelta(lastValue, DELTA, val))
                System.out.println("Luminosity in DELTA");
            else {
                System.out.println("Light sensor: " + val);
                conn.send(new Message(val));
                lastValue = val;
            }
            
            Utils.sleep(Sinalize.LED_TIME);
            sin.setOff(Message.LUMINOSITY);
        } catch (IOException ex) {
            System.out.println("LuminosityReader doTask Exception: " + ex.getMessage());
        }
    }

    public void stopping()
    {
        sin.setOff(Message.LUMINOSITY);
    }

    public LuminosityReader(Connection c, Sinalize s) {
        super(2, LUMINOSITY_PERIOD);
        conn = c;
        sin = s;
    }
}