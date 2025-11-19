# Golden Crust Bakery Management System

## Overview
The Golden Crust Bakery Management System is a Java-based console application developed as a third-year university project. This system helps manage bakery operations such as inventory tracking, sales management, order processing, and generating receipts. It is designed to simplify day-to-day bakery operations by providing an organized and user-friendly interface.

## Features
- **Main Menu:** Provides access to all system functionalities.
- **Inventory Management:** Keep track of available bakery items.
- **Low Stock Alert:** Identify items that are running low in stock.
- **New Order:** Place and manage customer orders.
- **Order Receipt:** Generate receipts for customer purchases.
- **Sales Tracking:** Monitor daily sales and best-selling items.
- **Item Entry:** Add new items to the inventory.

## File Structure
- `MainMenu.java` – The main entry point of the application containing the menu interface.
- `Inventory.java` – Manages the bakery's inventory and stock levels.
- `LowStock.java` – Checks and displays items that are low in stock.
- `NewOrder.java` – Handles the process of creating new customer orders.
- `OrderReciept.java` – Generates and prints receipts for completed orders.
- `Sales.java` – Tracks sales and generates sales reports.
- `BestSeller.java` – Identifies and displays the best-selling items.
- `enterItem.java` – Allows adding new items to the inventory.
- `Data_files(Storage)/` – Directory containing files used for storing inventory and sales data.
- `Images/` – Directory containing any images used in the application.

## How to Run
1. Clone or download the repository.
2. Make sure you have Java installed on your system (Java 20 recommended).
3. Compile all `.java` files:
   ```bash
   javac *.java
