| class | attribute/methode     | type | visibility  | rationale  |
|----|----------|-----|----------|---------|
| vehicle  | vehicleID    | string  | private      | Unique identifier for each vehicle  |
|   | Vmake    | string  | private   | Manufacturer name|
|   | Vmodel    | string  | private       | Model of vehicle  |
|   | Vtype    | string  | private  | Type like car, bike, van  |
|   | availabilityStatus    | boolean  | private   | To check if the vehicle is available|
|  | VrentalRatePerDay   | double  | private   | Daily rental cost  |
|   | checkAvailability()    | boolean  | public      | Returns availability of vehicles  |
|   | calculateRentalCost()    | double  | public   | Calculates rental cost|
|   | updateStatus()    | void  | public       | Updates vehicle availability  |
| customer  | customerID    | string  | private  | Unique id for customer  |
|   | Cname    | string   | private    | Custumer's full name|
|  | ClicenseNumber   | string   | private   | Driving license   |
|  | Cinfo     | string  |private   | Customer's email or phone   |
|   | makeReservation()    | reservation  | public      | Creates a new reservation  |
| reservation  | reservationID    | string  | private   | Unique ID for reservation|
|   | Rvehicle    | vehicle  |   private     | Reserved vehicle  |
|   | Rcustomer    | customer  | private  | Customer making the reservation  |
|   | startDate    | date  |private     | Rental start date|
|  | endDate  | date  | private   | Rental end date  |
|   | status    | string  |    private   | Reservation status(booked, active, completed)  |
|   | cancleResrevation()    | void | public   | Cancle a reservation|
|   | calculateDuration    | int  | public       | Calculate rental duration  |
| RentalTransaction  | transactionID    | string  | private  | Unique transaction id  |
|   | reservation    | reservation  |private    | Related reservation|
|  | Rpayment   | payment  |private    | Linked payment information  |
|  | RtotalCost     | double | private  | Total amount for rental  |
|   | generateInvoice()    | string  | public      | Creates rental invoice  |
|  | finalizeTransaction()    | void  | public   | Completes rental and payment|
| Admin  | adminID    | string |   private     | Unique id for admin  |
|   | Aname   | string  | private  | Admin's name  |
|   | addVehicle()   | void  | public   | Adds new vehicle|
|  | updateRentalRate()   | void  | public   | Changes rental rates  |
|  | viewReports()     | void | public  | Admin views system report  |
| Payment | paymentID    |string  | private     | Payment id  |
|   | Pamount    | double  |  private  | Amount paid|
|   | paymentDate    | date  | private      | Date of payment  |
|   | paymentMethod    | string  | private  | Type of payment(card,cash)  |
|   | processPayment()    | boolean | public   | Process payment and confirms success|
| Maintenance | maintenanceID   | string  | private   | Unique id for maintenance record  |
|  | vehicle     | vehicle | private  | Vehicle being serviced  |
|   | serviceDate    | date  |     private | Date of maintenance service  |
|   | description    | string  |private    | Description of maintenance work|
|  | logService()    | void  | public      | Recored new service  |
|  | getMaintenanceHisrory()    | list | public  | Fetches maintenance history  |







