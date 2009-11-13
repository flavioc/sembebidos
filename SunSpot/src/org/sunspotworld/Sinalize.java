package org.sunspotworld;

import com.sun.spot.sensorboard.EDemoBoard;
import com.sun.spot.sensorboard.peripheral.ITriColorLED;


public class Sinalize {
    private ITriColorLED [] leds;
    
    public Sinalize () {
        leds  = EDemoBoard.getInstance().getLEDs();
    }

    public void setOn (int type) {
        switch (type) {
            case 0:
                leds[0].setRGB(255, 0, 0);
                leds[0].setOn();
                break;
            case 1:
                leds[1].setRGB(0, 255, 0);
                leds[1].setOn();
                break;
            case 2:
                leds[2].setRGB(0, 0, 255);
                leds[2].setOn();
                break;
        }
    }

    public void setOff (int type) {
        switch (type) {
            case 0:
                leds[0].setOff();
                break;
            case 1:
                leds[1].setOff();
                break;
            case 2:
                leds[2].setOff();
                break;
        }
    }
}
