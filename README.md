🍔 Food Delivery Management System

A Java-based desktop application for managing food items, customer
orders, food search, order modification/cancellation, and bill
generation through a graphical user interface.

📌 Project Overview

The Food Delivery Management System is a desktop application
developed using Java Swing and the Java Collection Framework.

The application provides a simple GUI where users can:

View available food items

Search for food using Food ID

Place customer orders

View all active orders

Modify the latest order quantity

Cancel the latest order

Generate the final bill

Automatically calculate order totals

The project demonstrates practical use of Object-Oriented Programming,
Java Collections, Swing GUI components, event handling, and exception
handling.

✨ Features

🍕 Food Management

Predefined food menu

Each food item has:

Food ID

Food Name

Price

Food can be displayed in sorted Food ID order.

Food can be searched quickly using its ID.

🛒 Order Management

Place a new order using customer name, Food ID, and quantity.

Calculate the order total automatically.

Display all currently stored orders.

Modify the quantity of the latest order.

Cancel the latest order.

🧾 Billing

Generate a final bill from all active orders.

Calculate each order's total using:

Total = Food Price × Quantity

Display the final bill amount in the GUI.

🖥️ GUI

The application uses Java Swing to provide: - Customer Name input - Food
ID input - Quantity input - Place Order - Search Food - Modify Order -
Show Food - Show Orders - Generate Bill - Cancel Order - Output area for
results and billing information

🧰 Technology Stack

Technology           Purpose

Java                 Main programming language
Java Swing           Graphical User Interface
AWT                  Layouts, fonts, colors and GUI components
Array                Stores predefined food items
HashMap              Fast food lookup using Food ID
TreeMap              Maintains food items in sorted Food ID order
LinkedList           Stores customer orders
OOP                  Represents Food, Order and system objects
Exception Handling   Handles invalid user input

🗂️ Project Structure

The current implementation is contained in a single Java source file:

FoodDeliverySystem.java

The main classes are:

Food
 ├── id
 ├── name
 └── price

Order
 ├── customer
 ├── food
 ├── quantity
 └── total()

FoodDeliverySystem
 ├── Food data
 ├── Collections
 ├── GUI
 ├── Order operations
 └── Billing

🍽️ Predefined Food Menu

Food ID Food        Price

    101 Pizza        ₹250
    102 Burger       ₹150
    103 Biryani      ₹220
    104 Dosa         ₹100
    105 Pasta        ₹180

🧠 Data Structures Used

1. Array

The predefined food menu is initialized using an array.

static Food[] foods = {
    new Food(101, "Pizza", 250),
    new Food(102, "Burger", 150),
    new Food(103, "Biryani", 220),
    new Food(104, "Dosa", 100),
    new Food(105, "Pasta", 180)
};

2. HashMap

HashMap<Integer, Food> stores food using Food ID as the key.

static HashMap<Integer, Food> foodMap = new HashMap<>();

It is used for quick food searching.

3. TreeMap

TreeMap<Integer, Food> stores food according to Food ID in sorted
order.

static TreeMap<Integer, Food> sortedFood = new TreeMap<>();

It is mainly used when displaying the food list.

4. LinkedList

LinkedList<Order> stores customer orders.

static LinkedList<Order> orders = new LinkedList<>();

It supports adding orders and accessing/removing the latest order.

🔄 Application Flow

START
  ↓
Initialize Food Items
  ↓
Store Food in HashMap and TreeMap
  ↓
Create Java Swing GUI
  ↓
Enter Customer / Food ID / Quantity
  ↓
Choose Operation
  ├── Show Food
  ├── Search Food
  ├── Place Order
  ├── Show Orders
  ├── Modify Order
  ├── Cancel Order
  └── Generate Bill
  ↓
Display Result
  ↓
END

🔍 Main Methods

showFood()

Displays all available food items using the sorted TreeMap.

searchFood()

Takes a Food ID from the user and searches the HashMap.

Food ID → HashMap → Food Details

placeOrder()

Reads customer name.

Reads Food ID.

Reads quantity.

Validates the input.

Finds the selected food.

Creates an Order object.

Adds the order to the LinkedList.

Calculates and displays the order total.

showOrders()

Displays all currently stored orders with:

Order number

Customer name

Food name

Quantity

Total amount

modifyOrder()

Updates the quantity of the latest order using:

orders.getLast();

cancelOrder()

Removes the latest order using:

orders.removeLast();

generateBill()

Loops through all active orders, calculates each order's total, and adds
them together to produce the final bill.

🧮 Example

If a customer orders:

Pizza
Price = ₹250
Quantity = 2

Then:

Total = ₹250 × 2
      = ₹500

The same calculation is performed automatically by the Order.total()
method.

⚠️ Input Validation

The application uses try-catch blocks to handle invalid input such as:

Non-numeric Food ID

Invalid quantity

Invalid numeric input

Empty customer name

Food ID that does not exist

Instead of crashing, the application displays an appropriate message in
the output area.

▶️ How to Run

Prerequisites

Install:

Java JDK 8 or above

Any Java IDE such as IntelliJ IDEA, Eclipse, or VS Code with Java
support

Compile

Open the terminal in the folder containing FoodDeliverySystem.java:

javac FoodDeliverySystem.java

Run

java FoodDeliverySystem

The Java Swing application window will open.

🖥️ How to Use

1. Show Food

Click Show Food to display the predefined food menu.

2. Search Food

Enter a Food ID such as:

101

Then click Search Food.

3. Place Order

Enter:

Customer Name: Ayush
Food ID: 101
Quantity: 2

Click Place Order.

Expected calculation:

Pizza × 2 = ₹500

4. Show Orders

Click Show Orders to view all active orders.

5. Modify Order

Enter a new quantity and click Modify Order to update the latest
order.

6. Cancel Order

Click Cancel Order to remove the latest order.

7. Generate Bill

Click Generate Bill to calculate the total of all active orders.

🎯 Learning Outcomes

This project provides practical experience with:

Java fundamentals

Classes and objects

Constructors

Object-Oriented Programming

Arrays

LinkedList

HashMap

TreeMap

Java Swing

AWT

Event handling using ActionListener

Lambda expressions for event handling

Exception handling

GUI-based application development

Basic algorithmic thinking and data organization

✅ Advantages

Simple and user-friendly desktop interface

Fast Food ID based searching

Automatic order calculations

Easy order management

Uses appropriate Java Collections

Reduces manual calculation

Demonstrates practical OOP concepts

Handles invalid input using exceptions

Suitable as a Java Mini Project

⚠️ Current Limitations

The current implementation is a desktop-based educational project,
so it has some limitations:

Food items are predefined in the source code.

Orders are stored only in memory.

There is no database.

Data is lost when the application closes.

Only the latest order can be modified or cancelled.

There is no login/authentication system.

There is no real-time delivery tracking.

The application does not connect to an actual payment gateway.

The current bill calculation sums active order totals; additional
taxes or delivery charges are not implemented in the Java code.

🚀 Future Enhancements

Possible improvements include:

Add MySQL/PostgreSQL database integration

Add customer and admin login

Add dynamic food/menu management

Add order IDs and timestamps

Allow modification/cancellation of any selected order

Add delivery status tracking

Add tax and delivery fee calculation

Add payment gateway integration

Add receipt export as PDF

Add persistent order history

Convert the desktop system into a web/mobile application

📚 Project Documentation

The project documentation covers:

Project overview

Problem statement

Objectives

Scope

Technology stack

GUI design

Program flow

Sample outputs

Advantages

Learning outcomes

Conclusion

References

👥 Team

The project report lists the following team members:

Bhavika Khabya

Ishita Nakhawa

Ayush Mishra

Gouresh Parab

📌 Note

This README reflects the implemented Java code and the accompanying
project presentation/report. The presentation describes the overall
system and GUI, while the Java implementation provides the actual food,
order, collection, event-handling, validation, and billing logic.
