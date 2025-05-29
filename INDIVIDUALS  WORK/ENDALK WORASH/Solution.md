# Domain Solution: Hotel Reservation System

## Overview

This solution models a Hotel Reservation System using Object-Oriented Principles. It focuses on organizing the core components like Hotels, Rooms, Customers, and Reservations into distinct classes with clear responsibilities and relationships. The design emphasizes data protection and logical structure.

## Core Classes

### 1. Hotel Class

Represents a single hotel property.

**Attributes:**

| Name        | Data Type    | Visibility | Rationale                                                       |
| :---------- | :----------- | :--------- | :-------------------------------------------------------------- |
| `hotelId`   | String       | `private`  | Unique identifier for the hotel.                                |
| `name`      | String       | `private`  | Name of the hotel.                                              |
| `address`   | String       | `private`  | Physical address of the hotel.                                  |
| `starRating`| int          | `private`  | Star rating (e.g., 1-5).                                        |
| `amenities` | List<String> | `private`  | List of amenities offered (e.g., "Pool", "Wi-Fi", "Gym").       |
| `rooms`     | List<Room>   | `private`  | Collection of all rooms belonging to this hotel (Aggregation). |

**Methods:**

| Name             | Parameters                  | Return Type  | Visibility | Rationale                                                              |
| :--------------- | :-------------------------- | :----------- | :--------- | :--------------------------------------------------------------------- |
| `Hotel(...)`     | (Initial attribute values)  | (constructor)| `public`   | Creates a new hotel instance.                                          |
| `getHotelId()`   | -                           | String       | `public`   | Returns the unique hotel ID.                                           |
| `getName()`      | -                           | String       | `public`   | Returns the hotel name.                                                |
| `getAddress()`   | -                           | String       | `public`   | Returns the hotel address.                                             |
| `getRooms()`     | -                           | List<Room>   | `public`   | Returns the list of rooms in the hotel.                                |
| `addRoom()`      | `room`: Room                | void         | `public`   | Adds a new room to the hotel's collection.                             |
| `findAvailableRooms()`| `checkIn`: Date, `checkOut`: Date, `roomType`: String | List<Room> | `public` | Searches for available rooms based on criteria (delegates availability check). |

### 2. Room Class

Represents a specific room within a hotel.

**Attributes:**

| Name        | Data Type     | Visibility | Rationale                                                                  |
| :---------- | :------------ | :--------- | :------------------------------------------------------------------------- |
| `roomId`    | String        | `private`  | Unique identifier for the room (e.g., room number).                        |
| `roomType`  | String        | `private`  | Type of room (e.g., "Single", "Double", "Suite").                          |
| `bedSize`   | String        | `private`  | Size of the bed(s) (e.g., "Queen", "King").                                |
| `pricePerNight`| double      | `private`  | Base price for the room per night (can be adjusted by pricing strategies). |
| `isAvailable`| boolean       | `private`  | Simple flag indicating current availability (more complex logic needed). |
| `amenities` | List<String>  | `private`  | Specific amenities for this room (e.g., "Balcony", "Jacuzzi").           |

**Methods:**

| Name             | Parameters                  | Return Type   | Visibility | Rationale                                                                |
| :--------------- | :-------------------------- | :------------ | :--------- | :----------------------------------------------------------------------- |
| `Room(...)`      | (Initial attribute values)  | (constructor) | `public`   | Creates a new room instance.                                             |
| `getRoomId()`    | -                           | String        | `public`   | Returns the unique room ID.                                              |
| `getRoomType()`  | -                           | String        | `public`   | Returns the type of the room.                                            |
| `getPricePerNight()`| -                        | double        | `public`   | Returns the base price.                                                  |
| `isAvailableForDates()`| `checkIn`: Date, `checkOut`: Date | boolean    | `public`   | Checks availability for specific dates (needs access to Reservations). |
| `bookRoom()`     | `reservation`: Reservation  | boolean       | `public`   | Marks the room as booked for the reservation dates (updates availability). |
| `updatePrice()`  | `newPrice`: double          | void          | `public`   | Allows updating the room's base price.                                   |

*(Note: `isAvailable` is overly simple. True availability depends on checking `Reservation` records for overlapping dates. This logic would likely live in a manager class or the `Hotel` class.)*

### 3. Customer Class

Represents a person making reservations.

**Attributes:**

| Name              | Data Type        | Visibility | Rationale                                                         |
| :---------------- | :--------------- | :--------- | :---------------------------------------------------------------- |
| `customerId`      | String           | `private`  | Unique identifier for the customer.                               |
| `name`            | String           | `private`  | Customer's full name.                                             |
| `email`           | String           | `private`  | Customer's email address.                                         |
| `phone`           | String           | `private`  | Customer's phone number.                                          |
| `paymentMethods`  | List<String>     | `private`  | Stored payment information (e.g., masked card numbers, tokens). |
| `reservations`    | List<Reservation>| `private`  | History of reservations made by this customer (Association).      |
| `loyaltyStatus`   | String           | `private`  | Customer's status in a loyalty program (e.g., "Gold", "Silver"). |

**Methods:**

| Name              | Parameters                  | Return Type        | Visibility | Rationale                                                        |
| :---------------- | :-------------------------- | :----------------- | :--------- | :--------------------------------------------------------------- |
| `Customer(...)`   | (Initial attribute values)  | (constructor)      | `public`   | Creates a new customer instance.                                 |
| `getCustomerId()` | -                           | String             | `public`   | Returns the unique customer ID.                                  |
| `getName()`       | -                           | String             | `public`   | Returns the customer's name.                                     |
| `getEmail()`      | -                           | String             | `public`   | Returns the customer's email.                                    |
| `updateProfile()` | (new name, email, phone)    | void               | `public`   | Allows the customer to update their contact details.             |
| `addReservation()`| `reservation`: Reservation  | void               | `public`   | Adds a reservation to the customer's history.                    |
| `getReservations()`| -                          | List<Reservation>  | `public`   | Returns the list of the customer's reservations.                 |

### 4. Reservation Class

Represents a specific booking made by a customer for a room at a hotel.

**Attributes:**

| Name             | Data Type | Visibility | Rationale                                                             |
| :--------------- | :-------- | :--------- | :-------------------------------------------------------------------- |
| `reservationId`  | String    | `private`  | Unique identifier for the booking.                                    |
| `customer`       | Customer  | `private`  | The customer who made the reservation (Association).                  |
| `hotel`          | Hotel     | `private`  | The hotel where the reservation is made (Association).                |
| `room`           | Room      | `private`  | The specific room booked (Association).                               |
| `checkInDate`    | Date      | `private`  | Date of arrival.                                                      |
| `checkOutDate`   | Date      | `private`  | Date of departure.                                                    |
| `totalPrice`     | double    | `private`  | Calculated total cost for the stay (including taxes, fees).         |
| `status`         | String    | `private`  | Current status (e.g., "Confirmed", "Checked-In", "Cancelled", "Completed"). |
| `bookingDate`    | Date      | `private`  | Date the reservation was made.                                        |

**Methods:**

| Name                | Parameters                  | Return Type   | Visibility | Rationale                                                              |
| :------------------ | :-------------------------- | :------------ | :--------- | :--------------------------------------------------------------------- |
| `Reservation(...)`  | (Initial attribute values)  | (constructor) | `public`   | Creates a new reservation instance.                                    |
| `getReservationId()`| -                           | String        | `public`   | Returns the unique reservation ID.                                     |
| `getCustomer()`     | -                           | Customer      | `public`   | Returns the customer associated with the booking.                      |
| `getRoom()`         | -                           | Room          | `public`   | Returns the room associated with the booking.                          |
| `getCheckInDate()`  | -                           | Date          | `public`   | Returns the check-in date.                                             |
| `getCheckOutDate()` | -                           | Date          | `public`   | Returns the check-out date.                                            |
| `getTotalPrice()`   | -                           | double        | `public`   | Returns the total calculated price.                                    |
| `getStatus()`       | -                           | String        | `public`   | Returns the current status.                                            |
| `updateStatus()`    | `newStatus`: String         | void          | `public`   | Changes the status (e.g., from "Confirmed" to "Checked-In").         |
| `cancelReservation()`| -                          | boolean       | `public`   | Attempts to cancel the reservation (may involve fees, updates status). |

### 5. Payment Class (Potential)

Represents a payment transaction related to a reservation.

**Attributes:**

| Name             | Data Type   | Visibility | Rationale                                                        |
| :--------------- | :---------- | :--------- | :--------------------------------------------------------------- |
| `paymentId`      | String      | `private`  | Unique identifier for the payment.                             |
| `reservation`    | Reservation | `private`  | The reservation this payment is for (Association).               |
| `amount`         | double      | `private`  | The amount paid.                                                 |
| `paymentDate`    | Date        | `private`  | Date the payment was processed.                                  |
| `paymentMethod`  | String      | `private`  | Method used (e.g., "Credit Card", "PayPal").                     |
| `status`         | String      | `private`  | Payment status (e.g., "Success", "Failed", "Pending", "Refunded"). |

**Methods:**

| Name           | Parameters                  | Return Type   | Visibility | Rationale                                  |
| :------------- | :-------------------------- | :------------ | :--------- | :----------------------------------------- |
| `Payment(...)` | (Initial attribute values)  | (constructor) | `public`   | Creates a new payment record.              |
| `processPayment()`| -                        | boolean       | `public`   | Attempts to process the payment via a gateway. |
| `issueRefund()`| -                           | boolean       | `public`   | Attempts to refund the payment.            |

### 6. PricingStrategy Class (Potential Interface/Abstract Class)

Defines a contract for different pricing calculation methods.

**Methods:**

| Name             | Parameters                                     | Return Type | Visibility | Rationale                                                              |
| :--------------- | :--------------------------------------------- | :---------- | :--------- | :--------------------------------------------------------------------- |
| `calculatePrice()`| `room`: Room, `checkIn`: Date, `checkOut`: Date | double      | `public`   | Abstract/Interface method: Concrete strategies implement the calculation. |

*(Concrete classes like `StandardPricing`, `SeasonalPricing`, `DynamicPricing` would implement this interface.)*

