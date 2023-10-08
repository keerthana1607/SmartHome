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


// ThermostatDevice class implementing the Device interface.
public class ThermostatDevice implements Device {
    private String id;
    private int temperature;

    public ThermostatDevice(String id) {
        this.id = id;
        this.temperature = 70; // Default temperature
    }

    public void turnOn() {
        // Thermostat does not have a turn-on behavior.
        System.out.println("Thermostat " + id + " is already on.");
    }

    public void turnOff() {
        // Thermostat does not have a turn-off behavior.
        System.out.println("Thermostat " + id + " is already on.");
    }

    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + " degrees.";
    }

    public int getTemperature() {
        return temperature;
    }

    // Additional method to set the temperature.
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature + " degrees.");
    }
}


