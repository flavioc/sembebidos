package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.ITemperatureInput;
import com.sun.spot.util.Utils;
import java.io.IOException;

public class TemperatureReader extends PeriodicTask {
    private static int TEMPERATURE_PERIOD = 1000; // 1 seconds
    private static final double DELTA = 0.5;
    private static double lastValue = 0;
    private ITemperatureInput tempInput = null;
    private Connection conn = null;
    private Sinalize sin = null;
    
    public void doTask() {
        try {
            sin.setOn(Message.TEMPERATURE);
            double celsius = tempInput.getCelsius();
            if(MyUtils.betweenIntervalDoubleDelta(lastValue, DELTA, celsius))
                System.out.println("Temperature in DELTA");
            else {
                conn.send(new Message(celsius));
                lastValue = celsius;
                System.out.println("Temperature is " + celsius);
            }
            Utils.sleep(Sinalize.LED_TIME);
            sin.setOff(Message.TEMPERATURE);
        } catch (IOException ex) {
            System.err.println("TemperatureReader doTask Exception: " + ex.getMessage());
        }
    }

    public void stopping() {
        sin.setOff(Message.TEMPERATURE);
    }

    public TemperatureReader(Connection c, Sinalize s) {
        super(3, TEMPERATURE_PERIOD);
        conn = c;
        sin = s;
        tempInput = EDemoBoard.getInstance().getADCTemperature();
    }
}