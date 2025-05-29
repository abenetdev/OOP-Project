# Domain Description: Smart Home Automation System

## Overview
The Smart Home Automation System is designed to manage and automate various smart devices within a residential environment. Users can control devices like lights, security cameras, and temperature sensors through a mobile or web application. The system supports setting up automation rules, monitoring device status, and sending notifications when certain events occur.

## Scope
- Manage user authentication (login/logout)
- Control devices (turn on/off, monitor status)
- Group devices into rooms
- Create automation rules (triggered actions based on conditions)
- Receive notifications for important system events
- Manage specialized devices like security cameras, lights, and temperature sensors

## Users
- **Admin (Homeowner)**:  
  Can manage devices, rooms, automation rules, and receive all notifications.
  
- **Guest**:  
  Limited access to device control based on permissions set by the Admin.

## Assumptions
- Devices are securely connected to the system.
- Users authenticate securely before accessing the system.
- Automation rules are evaluated in real-time.
- Notifications are delivered promptly when events occur.

## Class Summaries

- **User**:  
  Represents a user of the system with attributes like username, password, and role. Users can log in and log out.

- **Device**:  
  A general class for smart devices. Each device has a status and type, and provides methods to turn on, turn off, and get its status.

- **Room**:  
  Represents a physical room that holds multiple devices. Users can add or remove devices from a room.

- **AutomationRule**:  
  Defines conditions and actions for automating device behavior. Rules are evaluated and actions are executed automatically when conditions are met.

- **Notification**:  
  Represents messages sent to users when events occur. Contains the notification message and recipient user.

- **SecurityCamera**:  
  Specialized device with resolution and recording status. Can start and stop video recording.

- **Light**:  
  Specialized smart light device with brightness and color attributes. Allows turning on/off and adjusting brightness.

- **TemperatureSensor**:  
  Specialized device for measuring temperature. Can retrieve the current temperature and check if it exceeds a threshold.
