| class | attribute/method | type/return type | visibility | rationale |
|:-----|:------------------|:-----------------|:-----------|:----------|
| User | username | String | private | Stores unique username |
|  | password | String | private | Secures user access |
|  | role | String | private | Defines user type (admin or guest) |
|  | login() | boolean | public | Authenticates user credentials |
|  | logout() | void | public | Ends the user's session |
| Device | deviceId | String | private | Unique identifier for each device |
|  | deviceType | String | private | Type of device (light, thermostat, camera) |
|  | status | boolean | private | Whether the device is on or off |
|  | turnOn() | void | public | Turns the device ON |
|  | turnOff() | void | public | Turns the device OFF |
|  | getStatus() | boolean | public | Returns the device status |
| Room | roomName | String | private | Name of the room |
|  | devices | List<Device> | private | List of devices in the room |
|  | addDevice(Device device) | void | public | Adds a device to the room |
|  | removeDevice(Device device) | void | public | Removes a device from the room |
| AutomationRule | ruleId | String | private | Unique identifier for the automation rule |
|  | condition | String | private | Condition that triggers the rule |
|  | action | String | private | Action performed when condition is true |
|  | evaluate() | boolean | public | Evaluates if the rule condition is satisfied |
|  | executeAction() | void | public | Executes the rule's action |
| Notification | message | String | private | Message content of the notification |
|  | recipient | User | private | User who receives the notification |
|  | send() | void | public | Sends the notification to the recipient |
| SecurityCamera | cameraId | String | private | Unique ID of the security camera |
|  | resolution | String | private | Resolution of the camera |
|  | isRecording() | boolean | public | Checks if the camera is recording |
|  | startRecording() | void | public | Starts video recording |
|  | stopRecording() | void | public | Stops video recording |
| Light | lightId | String | private | Unique ID of the light |
|  | brightness | int | private | Brightness level of the light |
|  | color | String | private | Color of the light |
|  | turnOn() | void | public | Turns on the light |
|  | turnOff() | void | public | Turns off the light |
|  | setBrightness(int level) | void | public | Sets the brightness |
| TemperatureSensor | sensorId | String | private | Unique ID of the temperature sensor |
|  | currentTemperature | double | private | Current temperature reading |
|  | getTemperature() | double | public | Gets the current temperature |
|  | isTemperatureAbove(double threshold) | boolean | public | Checks if temperature exceeds threshold |
