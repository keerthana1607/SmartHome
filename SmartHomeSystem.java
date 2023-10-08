/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ei;

import java.util.Scanner;
import ei.Device;

/**
 *
 * @author keerthana
 */

// Device interface
interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
}


public class SmartHomeSystem {
    public static void main(String[] args) {
        // Create Smart Home Hub
        SmartHomeHub smartHomeHub = new SmartHomeHub();
        Scanner scanner = new Scanner(System.in);

        // Initialize and add devices
        Device light1 = new LightDevice("1");
        Device thermostat1 = new ThermostatDevice("2");
        Device doorLock1 = new DoorLockDevice("3");

        smartHomeHub.addDevice(light1);
smartHomeHub.addDevice(thermostat1);
smartHomeHub.addDevice(doorLock1);


        System.out.println("Smart Home System Initialized.");
        System.out.println("Light is Device 1, Thermostat is Device 2, and Door Lock is Device 3.");
         System.out.println("Initial status");
         System.out.println("Light is off");
         System.out.println(" Thermostat is at 70 degree");
         System.out.println("Door is unlocked"); 
        // Process user commands
        while (true) {
            System.out.println("\nAvailable commands: ");
            System.out.println("  - turnOn(deviceId)");
            System.out.println("  - turnOff(deviceId)");
            System.out.println("  - getStatus(deviceId)");
            System.out.println("  - setTemperature(deviceId, temperature)");
            System.out.println("  - setSchedule(deviceId, time, task)");
            System.out.println("  - addTrigger(condition, action)");
            System.out.println("Enter a command or 'exit' to quit:");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            smartHomeHub.processCommand(userInput);
            smartHomeHub.executeScheduledTasks();
            ThermostatDevice thermostat = (ThermostatDevice) thermostat1;
            smartHomeHub.checkTriggers(thermostat.getTemperature());
        }

        System.out.println("Smart Home System Exited.");
    }
}


