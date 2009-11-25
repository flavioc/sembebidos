package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.IAccelerometer3D;
import com.sun.spot.util.Utils;
import java.io.IOException;

public class MovementReader extends PeriodicTask {
    private static int MOVEMENT_PERIOD = 1000; // 1 seconds
    private static final double DELTA = 0.1;
    private static double lastValueX = 0;
    private static double lastValueY = 0;
    private IAccelerometer3D accel = EDemoBoard.getInstance().getAccelerometer();
    private Connection conn = null;
    private Sinalize sin = null;

    public void doTask() {
        try {
            sin.setOn(Message.MOVEMENT);
            double accelX = accel.getAccelX();
            double accelY = accel.getAccelY();

            if(MyUtils.betweenIntervalDoubleDelta(lastValueX, DELTA, accelX)
              && MyUtils.betweenIntervalDoubleDelta(lastValueY, DELTA, accelY))
                System.out.println("Moviment in DELTA");
            else {
                conn.send(new Message(accelX, accelY));
                lastValueX = accelX;
                lastValueY = accelY;
                System.out.println("ACCEL X " + accelX + " ACCEL Y " + accelY);
            }
            Utils.sleep(Sinalize.LED_TIME);
            sin.setOff(Message.MOVEMENT);
        } catch (IOException ex) {
            System.err.println("MovementReader doTask Exception: " + ex.getMessage());
        }
    }

    public void stopping ()
    {
        sin.setOff(Message.MOVEMENT);
    }

    public MovementReader(Connection c, Sinalize s) {
        super(2, MOVEMENT_PERIOD);
        conn = c;
        sin = s;
    }
}
