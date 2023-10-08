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


// DoorLockDevice class implementing the Device interface.
public class DoorLockDevice implements Device {
    private String id;
    private boolean isLocked;

    public DoorLockDevice(String id) {
        this.id = id;
        this.isLocked = false;
    }

    public void turnOn() {
        lock();
    }

    public void turnOff() {
        unlock();
    }

    
    public String getStatus() {
        return "Door lock " + id + " is " + (isLocked ? "Locked" : "Unlocked");
    }

    public void lock() {
        isLocked = true;
        System.out.println("Door lock " + id + " is locked.");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("Door lock " + id + " is unlocked.");
    }
}


