package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.ITemperatureInput;
import com.sun.spot.util.Utils;
import java.io.IOException;

public class TemperatureReader extends PeriodicTask {
    private static int TEMPERATURE_PERIOD = 2000; // 2 seconds
    private ITemperatureInput tempInput = EDemoBoard.getInstance().getADCTemperature();
    private Connection conn = null;
    private Sinalize sin = null;
    
    public void doTask() {
        try {
            sin.setOn(1);
            double celsius = tempInput.getCelsius();
            conn.send(new Message(celsius));
            System.out.println("Temperature is " + celsius);
            Utils.sleep(500);
            sin.setOff(1);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public TemperatureReader(Connection c, Sinalize s) {
        super(1, TEMPERATURE_PERIOD);
        conn = c;
        sin = s;
    }
}