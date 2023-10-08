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


// ScheduledTask class to represent scheduled tasks.
public class ScheduledTask {
    private int deviceId;
    private String time;
    private String task;

    public ScheduledTask(int deviceId, String time, String task) {
        this.deviceId = deviceId;
        this.time = time;
        this.task = task;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getTime() {
        return time;
    }

    public String getTask() {
        return task;
    }
}


