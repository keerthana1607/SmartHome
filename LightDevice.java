/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;



/**
 *
 * @author keerthana
 */

 

// LightDevice class implementing the Device interface.
public class LightDevice implements Device {
    private String id;
    private boolean isOn;

    public LightDevice(String id) {
        this.id = id;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Light " + id + " is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light " + id + " is turned off.");
    }

    public String getStatus() {
        return "Light " + id + " is " + (isOn ? "On" : "Off");
    }
}

    

