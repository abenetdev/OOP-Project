## Updated Object / Attribute / Method Table


| **Class**        | **Attribute / Method**     | **Type**        | **Visibility** | **Description**                                      |
|------------------|-----------------------------|------------------|----------------|------------------------------------------------------|
| **User**         | userID                      | String           | Private        | gives identifier for the user                      |
|                  | name                        | String           | Private        | Full name of the user                               |
|                  | email                       | String           | Private        | Email address used for login                        |
|                  | password                    | String           | Private        | Encrypted password                                  |
|                  | role                        | String           | Private        | Role of the user (buyer, seller, agent)             |
|                  | phone                       | String           | Private        | Contact number                                      |
|                  | profilePic                  | String           | Private        | Path to profile image                               |
|                  | login()                     | Boolean          | Public         | Authenticates user credentials                      |
|                  | updateProfile()             | void             | Public         | Allows updating of user profile                     |
|                  | sendMessage()               | void             | Public         | Sends a message to another user                     |
|                  | saveProperty()              | void             | Public         | Saves a property to favorites (book mark)                      |
| **Property**     | propertyID                  | String           | Private        | gives Unique ID for property                              |
|                  | address                     | String           | Private        | tells Property location                                   |
|                  | type                        | String           | Private        | tells type of property (residential, commercial, etc.)    |
|                  | subType                     | String           | Private        | Detailed category (apartment, land, etc.)           |
|                  | price                       | Float            | Private        | shows Listed price                                        |
|                  | status                      | String           | Private        | tells Current availability (sold, available, etc.)        |
|                  | size                        | Float            | Private        | shows Area in square footage                              |
|                  | bedrooms                    | Integer          | Private        | shows Number of bedrooms                                  |
|                  | bathrooms                   | Integer          | Private        | shows Number of bathrooms                                 |
|                  | amenities                   | List             | Private        | shows Features like pool, garage, balcony                 |
|                  | updateDetails()             | void             | Public         | Edits property info                                 |
|                  | addMedia()                  | void             | Public         | Uploads media to the property                       |
|                  | changeStatus()              | void             | Public         | Updates property’s availability                     |
| **Listing**      | listingID                   | String           | Private        |  Unique listing ID                                   |
|                  | propertyID                  | String           | Private        | Linked property ID                                  |
|                  | agentID                     | String           | Private        | Agent responsible for the listing                   |
|                  | dateListed                  | Date             | Private        | Date the listing was posted                         |
|                  | priceHistory                | List             | Private        | Record of price changes                             |
|                  | updateListing()             | void             | Public         | Updates listing info                                |
| **Offer**        | offerID                     | String           | Private        | Unique offer ID                                     |
|                  | buyerID                     | String           | Private        | Buyer making the offer                              |
|                  | propertyID                  | String           | Private        | Targeted property                                   |
|                  | amount                      | Float            | Private        | Offered price                                       |
|                  | status                      | String           | Private        | Offer status (pending, accepted, etc.)              |
|                  | conditions                  | String           | Private        | Optional conditions by buyer                        |
|                  | submitOffer()               | void             | Public         | Submits an offer                                    |
|                  | respondToOffer()            | void             | Public         | Accepts or rejects the offer                        |
| **Transaction**  | transactionID               | String           | Private        | Unique transaction ID                               |
|                  | offerID                     | String           | Private        | Related accepted offer                              |
|                  | dateClosed                  | Date             | Private        | Finalization date                                   |
|                  | finalPrice                  | Float            | Private        | Agreed sale price                                   |
|                  | commission                  | Float            | Private        | Agent’s commission                                  |
|                  | recordTransaction()         | void             | Public         | Finalizes the transaction                           |
| **MediaAsset**   | mediaID                     | String           | Private        | Unique ID for media                                 |
|                  | propertyID                  | String           | Private        | Property the media belongs to                       |
|                  | mediaType                   | String           | Private        | Type (image, video, floor plan, etc.)               |
|                  | filePath                    | String           | Private        | Path to media file                                  |
|                  | uploadMedia()               | void             | Public         | Uploads media file                                  |
| **Message**      | messageID                   | String           | Private        | Unique message ID                                   |
|                  | senderID                    | String           | Private        | Sender of the message                               |
|                  | receiverID                  | String           | Private        | Receiver of the message                             |
|                  | content                     | String           | Private        | Message content                                     |
|                  | timestamp                   | DateTime         | Private        | Date and time sent                                  |
|                  | sendMessage()               | void             | Public         | Sends a message                                     |
| **SavedProperty**| userID                      | String           | Private        | User who saved the property                         |
|                  | propertyID                  | String           | Private        | Saved property ID                                   |
|                  | save()                      | void             | Public         | Adds property to favorites                          |
|                  | unsave()                    | void             | Public         | Removes property from favorites                     |



## **Detailed relationships and Associations(Aggregation and Composition)



| Relationship         |Aggregation  Type           | cardinality | Explanation                                                                                      |
|--------------------------|--------------------|------------------------|------------------------------------------------------------------------------------------------------|
| User → Listing           | Association        | 1:many            | An agent user can manage multiple listings. The listing is linked to the user but can exist separately. |
| User → Offer             | Association        | 1:many            | A buyer can submit multiple offers. Each offer is tied to the user who made it.                      |
| User → Message           | Association        | Many:Many          | Users can send and receive many messages. The message holds both sender and receiver IDs.            |
| User → SavedProperty     | Association        | Many:Many                    | A user can save multiple properties, and one property can be saved by many users.                    |
| Property → Listing       | Composition    | 1:1            | A listing is tightly linked to a property. If the property is deleted, the listing no longer makes sense. |
| Property → Offer         | Association        |   1:Many                      | Multiple offers can be made on a single property by different users.                                 |
| Property → MediaAsset    | Aggregation    |    1:Many         | A property contains media (images, videos), but media can exist independently and be reused.         |
| Offer → Transaction      | Association        | 1:1             | A transaction is created from an accepted offer and stores the finalized sale details.               |


##  Explanation of Applied OOP Principles

our system (the Real Estate Listing Platform)  uses the four main Object-Oriented Programming (OOP) principles: Encapsulation, Abstraction, Inheritance, and Polymorphism properly and as ypu can see .

### 1. Encapsulation

All attributes in each class (such as userID, password, propertyID, etc.) are declared as private, and only accessible through public methods like updateProfile() or submitOffer(). This ensures the internal state of each object is protected from unauthorized access or unexpected changes.

> Example: A user cannot directly change their password without going through updateProfile(), which ensures validation happens.

---

### 2. Abstraction

The platform hides complex logic and exposes only the necessary functionality through clearly named methods. For example, when a buyer submits an offer using submitOffer(), they do not need to know how the system stores the offer or verifies conditions—it is handled internally.

> Example: Calling recordTransaction() performs all necessary operations like saving data, updating statuses, and calculating commission, without exposing that logic.

---

### 3. Inheritance

The User class is designed to be extensible using inheritance. Roles like Agent, Buyer, or Seller could be modeled as subclasses of User, each with their own additional attributes or methods, while reusing common functionality like login() and sendMessage().

> Example: An Agent subclass could have an additional method manageListings() that is not needed by buyers or sellers.



### 4. Polymorphism

With polymorphism, different user roles could implement or override shared methods like viewDashboard() to present role-specific behavior. This allows the system to treat all user types uniformly while allowing each one to behave differently as needed.

> Example: All user types can call sendMessage(), but an Agent may have different messaging capabilities than a Buyer.

---
