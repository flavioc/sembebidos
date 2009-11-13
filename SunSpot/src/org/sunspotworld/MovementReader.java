package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.IAccelerometer3D;
import com.sun.spot.util.Utils;
import java.io.IOException;

public class MovementReader extends PeriodicTask {
    private static int MOVEMENT_PERIOD = 4000; // 4 seconds
    private IAccelerometer3D accel = EDemoBoard.getInstance().getAccelerometer();
    private Connection conn = null;
    private Sinalize sin = null;

    public void doTask() {
        try {
            sin.setOn(2);
            double accelX = accel.getAccelX();
            double accelY = accel.getAccelY();
            conn.send(accelX, accelY);
            System.out.println("ACCEL X " + accelX + " ACCEL Y " + accelY);
            Utils.sleep(500);
            sin.setOff(2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public MovementReader(Connection c, Sinalize s) {
        super(3, MOVEMENT_PERIOD);
        conn = c;
        sin = s;
    }
}
