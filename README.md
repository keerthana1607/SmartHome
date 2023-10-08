# SmartHome
# Smart Home System
- An interface called `Device` is defined with methods for turning a device on, turning it off, and getting its status.
- The code initializes and adds three types of devices (Light, Thermostat, and Door Lock) to the Smart Home Hub. Each device is associated with an ID.
- The program interacts with the user through a command-line interface. It provides a list of available commands for controlling devices, such as turning them on or off, getting their status, setting temperatures, scheduling tasks, and adding triggers.
- User commands are processed by the `SmartHomeHub`, which manages the devices. It executes commands to control devices and can also schedule tasks and set triggers based on user input.
- The initial status of the devices (Light, Thermostat, Door Lock) is displayed, showing that the light is off, the thermostat is set to 70 degrees, and the door is unlocked.
- The user can exit the program by typing 'exit,' and the Smart Home System's status is displayed upon exit.
# smart hub
- The SmartHomeHub class maintains a list of devices and allows adding devices to the hub using `addDevice()` and removing them using `removeDevice(deviceId)`.
- It can schedule tasks for devices using the `scheduleTask(deviceId, time, task)` method. Tasks are executed at specified times.
- The code supports adding triggers with conditions and actions using `addTrigger(condition, action)`. Triggers are checked against specific conditions and trigger corresponding actions.
- User commands are processed using the `processCommand(command)` method, which includes turning devices on/off, getting device statuses, setting temperatures, scheduling tasks, and adding triggers.
- The `executeScheduledTasks()` method iterates through scheduled tasks and executes them based on their associated devices and tasks.
- The `checkTriggers(thermostatTemperature)` method checks triggers, and in this example, it checks if the thermostat temperature exceeds a certain value to trigger actions.
- The code includes methods for parsing and extracting parameters from user commands, ensuring proper command format.
# Door Lock
The `DoorLockDevice` class has the following characteristics:
   - It implements the `Device` interface, which requires implementing methods for turning the device on, turning it off, and getting its status.
   - It has two private fields:
     - `id`: Represents the unique identifier or name of the door lock device.
     - `isLocked`: Represents the current state of the door lock (locked or unlocked) with an initial state of unlocked (`false`).
   - The class provides implementations for the `turnOn()`, `turnOff()`, and `getStatus()` methods as required by the `Device` interface.
   - It includes two additional methods, `lock()` and `unlock()`, to set the state of the door lock. These methods change the `isLocked` field and print messages to indicate the lock's status.
- The class constructor takes an `id` as a parameter to initialize the door lock with a unique identifier.
- The `turnOn()` and `turnOff()` methods are implemented to call the `lock()` and `unlock()` methods, respectively, to change the state of the door lock.
- The `getStatus()` method returns a message indicating whether the door lock is locked or unlocked.
- The class provides `lock()` and `unlock()` methods to change the state of the door lock (`isLocked`). These methods update the lock status and print messages to indicate whether the door lock is locked or unlocked.
# Light Device
The `LightDevice` class has the following characteristics:
   - It implements the `Device` interface, which requires implementing methods for turning the device on, turning it off, and getting its status.
   - It has two private fields:
     - `id`: Represents the unique identifier or name of the light device.
     - `isOn`: Represents the current state of the light (on or off) with an initial state of off (`false`).
- The class provides implementations for the `turnOn()`, `turnOff()`, and `getStatus()` methods as required by the `Device` interface.
- These methods update the `isOn` field to reflect the state of the light and print messages indicating whether the light is turned on or off.
-  The class constructor takes an `id` as a parameter to initialize the light with a unique identifier.
- The `turnOn()` method sets the `isOn` field to `true`, indicating that the light is turned on, and prints a corresponding message.
- The `turnOff()` method sets the `isOn` field to `false`, indicating that the light is turned off, and prints a corresponding message.
- The `getStatus()` method returns a message indicating whether the light is on or off.
# Thermostat
 The `ThermostatDevice` class has the following characteristics:
   - It implements the `Device` interface, which requires implementing methods for turning the device on, turning it off, and getting its status.
   - It has two private fields:
     - `id`: Represents the unique identifier or name of the thermostat device.
     - `temperature`: Represents the current temperature setting of the thermostat with a default value of 70 degrees.
- The class provides implementations for the `turnOn()`, `turnOff()`, and `getStatus()` methods as required by the `Device` interface.
- It includes an additional method `setTemperature(int temperature)` to set the temperature of the thermostat to a specified value.
- The class constructor takes an `id` as a parameter to initialize the thermostat with a unique identifier.
- The `turnOn()` and `turnOff()` methods do not have any specific behavior for a thermostat and simply print messages indicating that the thermostat is already on.
- The `getStatus()` method returns a message indicating the thermostat's current temperature setting.
- The class provides a `setTemperature(int temperature)` method to set the temperature of the thermostat to a specified value. It also prints a message to indicate the new temperature setting.
# Trigger
The Trigger class has two private fields:
   - `condition`: Represents the condition that needs to be met for the trigger to activate.
   - `action`: Specifies the action to be taken when the trigger's condition is satisfied.
- The class has a constructor that allows creating triggers by specifying both the condition and the action.
# Scheduled Task
The `ScheduledTask` class has the following characteristics:
   - It has a constructor that takes three parameters: `deviceId`, `time`, and `task`.
   - It has three getter methods:
     - `getDeviceId()`: Returns the ID of the device for which the task is scheduled.
     - `getTime()`: Returns the time at which the task is scheduled to be executed.
     - `getTask()`: Returns the task description that needs to be executed at the scheduled time.
- The constructor initializes the `deviceId`, `time`, and `task` fields with the values provided as parameters.
- This class is used to represent and store information about scheduled tasks for various devices in a smart home system. It allows you to associate a device, a specific time, and a task description with a scheduled task.
