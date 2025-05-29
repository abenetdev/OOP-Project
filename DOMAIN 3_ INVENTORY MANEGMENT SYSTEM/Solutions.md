# Domain Solution: Inventory Management System

## Introduction

This solution proposes an object-oriented model for the Inventory Management System (IMS). The design focuses on separating responsibilities into distinct classes, managing data securely, and providing clear interfaces for interaction, adhering to core Object-Oriented Programming (OOP) principles.

## Core Classes

Based on the requirements, the following core classes are identified:

1.  **Product:** Represents an item that the business stocks and manages.
2.  **Supplier:** Represents the entity from which products are procured.
3.  **Warehouse:** Represents a physical location where inventory is stored.
4.  **StockItem:** Represents a specific quantity of a particular Product at a specific Warehouse.
5.  **InventoryTransaction:** Records any movement or adjustment of inventory.

*(A potential `InventoryManager` class could be added later to coordinate operations, but we start with these core entities.)*

---

### 1. Product Class

**Responsibility:** Holds information defining a unique inventory item.

**Attributes:**

| Attribute Name      | Data Type      | Visibility | Rationale/Description                                      |
| :------------------ | :------------- | :--------- | :--------------------------------------------------------- |
| `productID`         | String         | `private`  | Unique identifier for the product (e.g., SKU, barcode).     |
| `name`              | String         | `private`  | Common name of the product.                                |
| `description`       | String         | `private`  | Detailed description of the product.                       |
| `category`          | String         | `private`  | Product category (e.g., Electronics, Apparel, Perishable). |
| `unitPrice`         | double         | `private`  | The standard price per unit.                               |
| `supplierID`        | String         | `private`  | Identifier linking to the primary supplier (can be a List). |
| `reorderPoint`      | int            | `private`  | Minimum quantity level that triggers a reorder alert.       |
| `preferredQuantity` | int            | `private`  | Target quantity to order when reordering.                  |
| `productVariations` | `List<String>` | `private`  | List of variations like size, color, model (if applicable). |

**Methods:**

| Method Name           | Parameters                     | Return Type | Visibility | Rationale/Description                                       |
| :-------------------- | :----------------------------- | :---------- | :--------- | :---------------------------------------------------------- |
| `getProductDetails()` | (none)                         | `String`    | `public`   | Returns a summary of product information.                   |
| `updateDetails()`     | `name`, `description`, etc.    | `void`      | `public`   | Modifies the product's descriptive information.             |
| `setReorderLevel()`   | `reorderPoint`, `prefQuantity` | `void`      | `public`   | Sets the thresholds for reordering.                         |
| `isBelowReorderPoint()`| `currentTotalQuantity`         | `boolean`   | `public`   | Checks if the total stock across locations is low.        |
| `getProductID()`      | (none)                         | `String`    | `public`   | Provides access to the product's unique ID (Getter).        |
| `getName()`           | (none)                         | `String`    | `public`   | Provides access to the product's name (Getter).             |
| *(Other Getters)*     | *(none)*                       | *Relevant*  | `public`   | Provide controlled access to other private attributes.       |

---

### 2. Supplier Class

**Responsibility:** Holds information about a supplier/vendor.

**Attributes:**

| Attribute Name   | Data Type      | Visibility | Rationale/Description                                         |
| :--------------- | :------------- | :--------- | :------------------------------------------------------------ |
| `supplierID`     | String         | `private`  | Unique identifier for the supplier.                           |
| `name`           | String         | `private`  | Name of the supplier company.                                 |
| `contactPerson`  | String         | `private`  | Name of the primary contact at the supplier.                  |
| `phone`          | String         | `private`  | Supplier's phone number.                                      |
| `email`          | String         | `private`  | Supplier's email address.                                     |
| `address`        | String         | `private`  | Supplier's physical address.                                  |
| `productCatalog` | `List<String>` | `private`  | List of Product IDs typically supplied by this vendor.        |
| `leadTimeDays`   | int            | `private`  | Typical number of days from order placement to delivery.    |

**Methods:**

| Method Name             | Parameters         | Return Type | Visibility | Rationale/Description                                      |
| :---------------------- | :----------------- | :---------- | :--------- | :--------------------------------------------------------- |
| `getSupplierDetails()`  | (none)             | `String`    | `public`   | Returns a summary of supplier information.                 |
| `updateContactInfo()`   | `phone`, `email`   | `void`      | `public`   | Updates the supplier's contact details.                    |
| `addProductToCatalog()` | `productID`        | `void`      | `public`   | Adds a product ID to the list of items they supply.      |
| `getSupplierID()`       | (none)             | `String`    | `public`   | Provides access to the supplier's unique ID (Getter).      |
| `getName()`             | (none)             | `String`    | `public`   | Provides access to the supplier's name (Getter).           |
| *(Other Getters)*       | *(none)*           | *Relevant*  | `public`   | Provide controlled access to other private attributes.      |

---

### 3. Warehouse Class

**Responsibility:** Represents a physical location where inventory is stored.

**Attributes:**

| Attribute Name     | Data Type                | Visibility | Rationale/Description                                |
| :----------------- | :----------------------- | :--------- | :--------------------------------------------------- |
| `warehouseID`      | String                   | `private`  | Unique identifier for the warehouse/location.        |
| `name`             | String                   | `private`  | Name of the warehouse (e.g., "Main Warehouse", "Store A"). |
| `address`          | String                   | `private`  | Physical address of the location.                    |
| `capacity`         | double                   | `private`  | Storage capacity (optional, based on units/volume).  |
| `stockItems`       | `List<StockItem>`        | `private`  | List of inventory items currently held at this location. |

**Methods:**

| Method Name           | Parameters            | Return Type       | Visibility | Rationale/Description                                     |
| :-------------------- | :-------------------- | :---------------- | :--------- | :-------------------------------------------------------- |
| `addStockItem()`      | `stockItem`           | `void`            | `public`   | Adds a new type of product stock to this warehouse.       |
| `removeStockItem()`   | `productID`           | `void`            | `public`   | Removes a product entirely from this warehouse's stock list. |
| `findStockItem()`     | `productID`           | `StockItem`       | `public`   | Retrieves the StockItem object for a given product ID.    |
| `updateStockQuantity()`| `productID`, `change` | `boolean`         | `public`   | Increases or decreases the quantity of a specific product. |
| `getWarehouseDetails()`| (none)                | `String`          | `public`   | Returns a summary of the warehouse information.           |
| `getTotalStockValue()`| (none)                | `double`          | `public`   | Calculates the total value of inventory at this location. |
| `getWarehouseID()`    | (none)                | `String`          | `public`   | Provides access to the warehouse's unique ID (Getter).   |
| `getStockItems()`     | (none)                | `List<StockItem>` | `public`   | Provides access to the list of stock items (Getter).      |

---

### 4. StockItem Class

**Responsibility:** Tracks the quantity of a specific Product within a specific Warehouse.

**Attributes:**

| Attribute Name   | Data Type | Visibility | Rationale/Description                                      |
| :--------------- | :-------- | :--------- | :--------------------------------------------------------- |
| `productID`      | String    | `private`  | Identifier of the product being tracked.                   |
| `warehouseID`    | String    | `private`  | Identifier of the location where the stock is held.        |
| `quantityOnHand` | int       | `private`  | The current number of units available at this location.    |
| `lastUpdated`    | Date      | `private`  | Timestamp of the last time the quantity was modified.      |
| `binLocation`    | String    | `private`  | Specific location within the warehouse (e.g., Aisle 5, Bin 2). |

**Methods:**

| Method Name            | Parameters   | Return Type | Visibility | Rationale/Description                                     |
| :--------------------- | :----------- | :---------- | :--------- | :-------------------------------------------------------- |
| `increaseQuantity()`   | `amount`     | `void`      | `public`   | Adds to the quantity on hand.                             |
| `decreaseQuantity()`   | `amount`     | `boolean`   | `public`   | Subtracts from the quantity on hand (returns false if insufficient). |
| `getQuantity()`        | (none)       | `int`       | `public`   | Returns the current quantity on hand.                     |
| `setQuantity()`        | `newQuantity`| `void`      | `public`   | Directly sets the quantity (e.g., during a stock count).   |
| `getProductId()`       | (none)       | `String`    | `public`   | Provides access to the product ID (Getter).               |
| `getWarehouseId()`     | (none)       | `String`    | `public`   | Provides access to the warehouse ID (Getter).             |
| *(Other Getters)*      | *(none)*     | *Relevant*  | `public`   | Provide controlled access to other private attributes.     |

---

### 5. InventoryTransaction Class

**Responsibility:** Records details about any event that changes inventory levels.

**Attributes:**

| Attribute Name    | Data Type   | Visibility | Rationale/Description                                      |
| :---------------- | :---------- | :--------- | :--------------------------------------------------------- |
| `transactionID`   | String      | `private`  | Unique identifier for the transaction.                     |
| `productID`       | String      | `private`  | ID of the product involved.                                |
| `warehouseID`     | String      | `private`  | ID of the location where the transaction occurred.         |
| `transactionType` | String      | `private`  | Type of transaction (e.g., "RECEIPT", "SALE", "TRANSFER_IN", "TRANSFER_OUT", "ADJUSTMENT"). |
| `quantityChange`  | int         | `private`  | The number of units affected (+ for increase, - for decrease). |
| `transactionDate` | Date        | `private`  | Date and time the transaction occurred.                    |
| `relatedDocumentID`| String      | `private`  | Optional ID linking to a source document (e.g., PO number, Sales Order number). |
| `notes`           | String      | `private`  | Any additional notes about the transaction.                |

**Methods:**

| Method Name               | Parameters | Return Type | Visibility | Rationale/Description                                    |
| :------------------------ | :--------- | :---------- | :--------- | :------------------------------------------------------- |
| `getTransactionDetails()` | (none)     | `String`    | `public`   | Returns a summary of the transaction information.        |
| `getTransactionID()`      | (none)     | `String`    | `public`   | Provides access to the transaction ID (Getter).          |
| `getProductId()`          | (none)     | `String`    | `public`   | Provides access to the product ID (Getter).              |
| *(Other Getters)*         | *(none)*   | *Relevant*  | `public`   | Provide controlled access to other private attributes.    |

*(Note: This class is primarily for recording data; complex logic resides in other classes or a manager class.)*

---

## Relationships

*   **Product to StockItem:** One-to-Many (One Product can exist as multiple StockItems across different Warehouses).
*   **Warehouse to StockItem:** One-to-Many (One Warehouse holds many StockItems).
*   **Product to Supplier:** Many-to-Many (A Product might be sourced from multiple Suppliers; a Supplier provides multiple Products). This relationship is often managed through purchase orders or transactions rather than direct links.
*   **Transactions:** Transactions link Products and Warehouses, recording the change event.

## OOP Principles Applied

*   **Encapsulation:** Attributes in all classes are `private`, accessed only through `public` methods (getters/setters or specific action methods). This protects the internal state.
*   **Abstraction:** Each class represents a distinct concept (Product, Warehouse, etc.), hiding the internal complexity of how it manages its data and performs its tasks. Users interact through defined methods.
*   **Modularity:** The system is broken down into smaller, manageable classes, each with a specific responsibility. This makes the system easier to understand, maintain, and extend.
*   **Association/Aggregation:** Relationships like a `Warehouse` containing `StockItems` are modeled using collections (`List`), representing aggregation (StockItems are part of a Warehouse).

## Handling Advanced Features

*   **Reporting:** Methods can be added (likely to a dedicated `ReportingService` or `InventoryManager` class) to query `StockItem` and `InventoryTransaction` data to generate reports on turnover, stock levels, etc.
*   **POS Integration/Automated Replenishment:** An `InventoryManager` or dedicated service class would handle events from POS or trigger reordering based on `Product.isBelowReorderPoint()` checks and `Supplier` lead times.
*   **Barcode Scanning:** Input methods would take barcode data, look up the `Product` (using `productID`), and trigger relevant actions like updating `StockItem` quantity via `InventoryTransaction`.

This design provides a foundation for the IMS, emphasizing clarity, maintainability, and adherence to OOP best practices.
