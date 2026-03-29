# 📚 Library Management System

## 📌 Problem Statement
This project is a console-based Library Management System developed using Java and Object-Oriented Programming principles. The system manages library items such as books and magazines, allowing users to add, issue, return, and search items efficiently. It also ensures data integrity by preventing duplicate entries and handling errors gracefully. The goal is to demonstrate clean design, modular architecture, and real-world modeling using OOP concepts rather than just basic CRUD operations.

---

## 🎯 Target User
- Students
- Librarians
- Academic institutions (basic usage)

---

## ⚙️ Core Features
- Add Books and Magazines
- Prevent duplicate item IDs
- Issue and return items
- Search item by ID
- Display all items with status
- Exception handling for invalid operations

---

## 🧠 OOP Concepts Used

### 1. Encapsulation
- Data members are private and accessed via getters/setters

### 2. Inheritance
- `LibraryItem` is the base class  
- `Book` and `Magazine` extend it

### 3. Polymorphism
- Same method handles different object types (`LibraryItem`)
- Method overriding (`displayDetails()`)

### 4. Abstraction
- Abstract class `LibraryItem`
- Abstract method `displayDetails()`

---

## 🏗️ Architecture Description

The project follows a layered architecture:

### 1. Controller Layer
- Handles user input/output  
- (`LibraryController`)

### 2. Service Layer
- Contains business logic  
- (`LibraryService`)

### 3. Repository Layer
- Manages data storage using `HashMap`  
- (`BookRepository`)

### 4. Model Layer
- Contains core entities:
  - `LibraryItem` (abstract)
  - `Book`
  - `Magazine`

### 5. Exception Handling
- Custom exceptions:
  - `BookNotFoundException`
  - `DuplicateBookException`

### Design Pattern Used:
- Repository Pattern (for data handling abstraction)

---

## ▶️ How to Run

### Step 1: Navigate to project folder
```bash
cd src

### Step 2: Compile the project
javac -d ../out $(find . -name "*.java")

###Step 3: Run the program
cd ../out
java model.Main
