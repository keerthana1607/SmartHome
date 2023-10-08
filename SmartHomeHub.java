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



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// SmartHomeHub class to manage devices, schedules, and triggers.
public class SmartHomeHub {
    private List<Device> devices;
    private Map<Integer, Device> deviceMap;
    private List<ScheduledTask> scheduledTasks;
    private List<Trigger> triggers;

    public SmartHomeHub() {
        devices = new ArrayList<>();
        deviceMap = new HashMap<>();
        scheduledTasks = new ArrayList<>();
        triggers = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
        deviceMap.put(devices.size(), device);
    }

    public void removeDevice(int deviceId) {
        if (deviceMap.containsKey(deviceId)) {
            devices.remove(deviceMap.get(deviceId));
            deviceMap.remove(deviceId);
            System.out.println("Device " + deviceId + " removed.");
        } else {
            System.out.println("Device with ID " + deviceId + " not found.");
        }
    }

    public void scheduleTask(int deviceId, String time, String task) {
        scheduledTasks.add(new ScheduledTask(deviceId, time, task));
        System.out.println("Scheduled task added for Device " + deviceId + " at " + time + " " + task);
    }

    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
        System.out.println("Trigger added: " + condition + " => " + action);
    }

    public void processCommand(String command) {
        if (command.startsWith("turnOn(") && command.endsWith(")")) {
            // Extract device ID from command
            int deviceId = extractDeviceId(command);
            if (deviceId != -1) {
                Device device = deviceMap.get(deviceId);
                if (device != null) {
                    device.turnOn();
                } else {
                    System.out.println("Device with ID " + deviceId + " not found.");
                }
            } else {
                System.out.println("Invalid command: " + command);
            }
        } else if (command.startsWith("turnOff(") && command.endsWith(")")) {
            // Extract device ID from command
            int deviceId = extractDeviceId(command);
            if (deviceId != -1) {
                Device device = deviceMap.get(deviceId);
                if (device != null) {
                    device.turnOff();
                } else {
                    System.out.println("Device with ID " + deviceId + " not found.");
                }
            } else {
                System.out.println("Invalid command: " + command);
            }
        } else if (command.startsWith("getStatus(") && command.endsWith(")")) {
            // Extract device ID from command
            int deviceId = extractDeviceId(command);
            if (deviceId != -1) {
                Device device = deviceMap.get(deviceId);
                if (device != null) {
                    System.out.println(device.getStatus());
                } else {
                    System.out.println("Device with ID " + deviceId + " not found.");
                }
            } else {
                System.out.println("Invalid command: " + command);
            }
        } else if (command.startsWith("setTemperature(") && command.endsWith(")")) {
            // Extract device ID and temperature from command
            int[] params = extractDeviceIdAndTemperature(command);
            int deviceId = params[0];
            int temperature = params[1];
            if (deviceId != -1 && temperature != -1) {
                Device device = deviceMap.get(deviceId);
                if (device instanceof ThermostatDevice) {
                    ThermostatDevice thermostat = (ThermostatDevice) device;
                    thermostat.setTemperature(temperature);
                } else {
                    System.out.println("Device with ID " + deviceId + " is not a thermostat.");
                }
            } else {
                System.out.println("Invalid command: " + command);
            }
        } else if (command.startsWith("setSchedule(") && command.endsWith(")")) {
            // Extract device ID, time, and task from command
            String[] params = extractDeviceIdTimeAndTask(command);
            int deviceId = Integer.parseInt(params[0]);
            String time = params[1];
            String task = params[2];
            scheduleTask(deviceId, time, task);
        } else if (command.startsWith("addTrigger(") && command.endsWith(")")) {
            // Extract condition and action from command
            String[] params = extractConditionAndAction(command);
            String condition = params[0];
            String action = params[1];
            addTrigger(condition, action);
        } 
    }

    public void executeScheduledTasks() {
        for (ScheduledTask task : scheduledTasks) {
            int deviceId = task.getDeviceId();
            Device device = deviceMap.get(deviceId);
            String taskDescription = task.getTask();
            processCommand(taskDescription);
        }
    }

    public void checkTriggers(int thermostatTemperature) {
        for (Trigger trigger : triggers) {
            String condition = trigger.getCondition();
            String action = trigger.getAction();
            if (condition.equals("temperature > 75") && thermostatTemperature > 75) {
                processCommand(action);
            }
        }
    }

    private String[] extractDeviceIdTimeAndTask(String command) {
        try {
            String[] parts = command.split(",");
            if (parts.length != 3) {
                return new String[]{"-1", "", ""}; // Invalid parameters
            }
            int deviceId = Integer.parseInt(parts[0].substring(command.indexOf("(") + 1));
            String time = parts[1].trim().replace("\"", "");
            String task = parts[2].substring(0, parts[2].indexOf(")")).trim();
            return new String[]{String.valueOf(deviceId), time, task};
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return new String[]{"-1", "", ""}; // Invalid parameters
        }
    }

    private String[] extractConditionAndAction(String command) {
        try {
            String[] parts = command.split(",");
            if (parts.length != 2) {
                return new String[]{"", ""}; // Invalid parameters
            }
            String condition = parts[0].substring(command.indexOf("(") + 1).trim().replace("\"", "");
            String action = parts[1].substring(0, parts[1].indexOf(")")).trim().replace("\"", "");
            return new String[]{condition, action};
        } catch (StringIndexOutOfBoundsException e) {
            return new String[]{"", ""}; // Invalid parameters
        }
    }

    private int extractDeviceId(String command) {
        try {
            String deviceIdStr = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
            return Integer.parseInt(deviceIdStr);
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return -1; // Invalid device ID
        }
    }

    private int[] extractDeviceIdAndTemperature(String command) {
        try {
            String[] parts = command.split(",");
            if (parts.length != 2) {
                return new int[]{-1, -1}; // Invalid parameters
            }
            int deviceId = Integer.parseInt(parts[0].substring(command.indexOf("(") + 1));
            int temperature = Integer.parseInt(parts[1].substring(0, parts[1].indexOf(")")));
            return new int[]{deviceId, temperature};
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            return new int[]{-1, -1}; // Invalid parameters
        }
    }

    
}
