# INTIAL ATTRIBUTE AND METHOD TABLE  
| **Class**       | **Attribute / Method**          | **Type**                 | **Visibility** | **Description**   |                                                             
|------------------|----------------------------------|--------------------------|----------------|----------------------------------------------------------------|
| **Patient**      | patientId                        | String                   | private         | Unique ID for identifying patient                                            |
|                  | name                             | String                   | private         | Stores full patient name                                                     |
|                  | dateOfBirth                      | Date                     | private         | Used to calculate age                                                        |
|                  | contactInfo                      | String                   | private         | Contact information (email, phone)                                           |
|                  | medicalHistory                   | List\<String\>           | private         | List of past diagnoses or allergies                                          |
|                  | +getMedicalHistory()             | List\<String\>           | public          | Returns health history                                                       |
|                  | +addMedicalHistory(note)         | void                     | public          | Adds a new item to medical history                                           |
| **Provider**     | providerId                       | String                   | private         | Unique ID for provider                                                       |
|                  | name                             | String                   | private         | Full provider name                                                           |
|                  | specialization                   | String                   | private         | Field of medicine (e.g., pediatrics)                                         |
|                  | contactInfo                      | String                   | private         | Email or phone                                                               |
|                  | +checkAvailability()             | Boolean                  | public          | Returns true if the provider is available                                         |
| **Appointment**  | appointmentId                    | String                   | private         | Unique booking ID                                                            |
|                  | startTime                        | DateTime                 | private         | Time the appointment begins                                                  |
|                  | endTime                          | DateTime                 | private         | Time the appointment ends                                                    |
|                  | reason                           | String                   | private         | Reason for the visit                                                         |
|                  | status                           | Status                   | private         | Scheduled / Completed / Cancelled                                            |
|                  | +reschedule(newTime)             | Boolean                  | public          | Changes time, checks availability                                            |
|                  | +cancel()                        | void                     | public          | Cancels the appointment                                                      |
| **MedicalRecord**| recordId                         | String                   | private         | Unique medical record ID                                                     |
|                  | timestamp                        | DateTime                 | private         | When the record was created                                                  |
|                  | notes                            | String                   | private         | Doctor’s notes                                                               |
|                  | diagnosis                        | String                   | private         | Condition diagnosed                                                          |
|                  | treatments                       | List\<String\>           | private         | List of treatments prescribed                                                |
|                  | +addLabResult(result)            | void                     | public          | Links lab result to this record                                              |
| **LabResult**    | resultId                         | String                   | private         | Unique test result ID                                                        |
|                  | testName                         | String                   | private         | Name of the test (e.g., blood test)                                          |
|                  | resultValue                      | String                   | private         | Actual result (e.g., positive, 4.6 mmol/L)                                   |
|                  | timestamp                        | DateTime                 | private         | When the result was received                                                 |
| **Prescription** | prescriptionId                   | String                   | private         | Unique ID for prescription                                                   |
|                  | medication                       | String                   | private         | Drug name                                                                    |
|                  | dosage                           | String                   | private         | Dosage instructions                                                          |
|                  | startDate                        | Date                     | private         | Start of dosage                                                              |
|                  | endDate                          | Date                     | private         | End of dosage                                                                |
| **Invoice**      | invoiceId                        | String                   | private         | Unique ID for invoice                                                        |
|                  | totalAmount                      | Float                    | private         | Total charge for service                                                     |
|                  | status                           | Status                   | private         | Pending / Paid / Refunded                                                    |
|                  | +generatePDF()                   | File                     | public          | Generates downloadable invoice document                                      |
| **Payment**      | paymentId                        | String                   | private         | Unique ID for each transaction                                               |
|                  | amount                           | Float                    | private         | Amount paid                                                                  |
|                  | method                           | PaymentMethod            | private         | Payment type: Insurance, Cash, CreditCard                                    |
|                  | timestamp                        | DateTime                 | private         | Time of transaction                                                          |
|                  | +process()                       | Boolean                  | public          | Validates and finalizes payment                                              |

**Detailed Relationship and Associations Table**

| **Relationship**              | **Association Type** | **Cardinality** | **Explanation**                                      |
|------------------------------|-----------------------|-----------------|------------------------------------------------------|
| Patient → Appointment         | Association           | 1 to many       | A patient can book multiple appointments             |
| Provider → Appointment        | Association           | 1 to many       | A provider attends many appointments                 |
| Patient → MedicalRecord       | Association           | 1 to many       | One patient may have many medical records            |
| MedicalRecord → LabResult     | Composition           | 1 to many       | Lab results belong to the medical record             |
| Patient → Prescription        | Association           | 1 to many       | A patient may have multiple prescriptions            |
| Appointment → Invoice         | Association           | 1 to 1          | Each appointment generates one invoice               |
| Invoice → Payment             | Association           | 1 to many       | An invoice may be paid with multiple payments        |  

**OOP Principles Applied**  
 Object-Oriented Programming  principles have been applied throughout the design of the Healthcare Management System to promote maintainability, modularity and scalability.  
 
**1.ENCAPSULATION**  

-All class attributes are declared private to prevent unauthorized access or modification.  
-Access is provided through public getter and setter methods like getMedicalHistory() or process() in the Payment class.  
-This approach protects sensitive patient data (like contact info, diagnosis, or billing status) and maintains system security and integrity.  

**2.ABSTRACTION**  

-Classes like Appointment, MedicalRecord, and Payment expose only the operations relevant to their role — e.g., reschedule() for appointments or addLabResult() for records.  
-This keeps the system modular and simplifies usage from the perspective of users or developers who interact with these objects without needing to understand their internal workings.  

**3.INHERITANCE**   

-A base class called User can be created to define common attributes for Patient and Provider, such as name, contactInfo, and userId.  
-Patient and Provider would inherit from User, reducing redundancy and promoting code reuse.

**4.POLYMORPHISM**

-For example, a User class could have a method like viewDashboard() that behaves differently for Patient and Provider.  
-This allows one interface to be used for different underlying types, enhancing flexibility.














 
 
