/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sunspotworld;

import com.sun.spot.peripheral.radio.mhrp.interfaces.IMHEventListener;

public class Listener implements IMHEventListener {

    public void RREQSent(long originator, long destination, int hopCount) {
        System.out.println("RREQSent");
    }

    public void RREPSent(long originator, long destination, int hopCount) {
        System.out.println("RREPSent");
    }

    public void RERRSent(long originator, long destination) {
        System.out.println("RERRSent");
    }

    public void RREQReceived(long originator, long destination, int hopCount) {
        System.out.println("RREQReceived");
    }

    public void RREPReceived(long originator, long destination, int hopCount) {
        System.out.println("RREPReceived");
    }

    public void RERRReceived(long originator, long destination) {
        System.out.println("RRERRReceived");
    }

}
