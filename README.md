# 🏨 Hotel Reservation Application

## 📌 Project Overview

The Hotel Reservation Application is a Java-based console application designed to simulate a hotel booking management system. The project allows customers to search available rooms, create reservations, manage customer accounts, and perform administrative operations through a menu-driven interface.

This application demonstrates core software engineering and object-oriented programming concepts including:

* Java OOP principles
* Layered application architecture
* Service-based backend design
* Encapsulation and abstraction
* Collection framework usage
* Reservation workflow implementation
* Console-based user interaction

---

# 🚀 Features Implemented

## 👤 Customer Features

* Create customer accounts
* Validate customer email addresses
* View customer information
* Search for available rooms
* Book hotel reservations
* View existing reservations

---

## 🛏️ Room Features

* Add hotel rooms
* Categorize rooms by type
* Handle free and paid rooms
* Display room details
* Search available rooms by date

---

## 📅 Reservation Features

* Create room reservations
* Store reservation details
* Track check-in and check-out dates
* Prevent unavailable room booking conflicts
* Recommend alternative rooms when unavailable

---

## 🛠️ Admin Features

* Add rooms to the system
* View all customers
* View all reservations
* Display all rooms
* Administrative menu system

---

# 🏗️ Project Architecture

The application follows a modular layered architecture.

```text
UI Layer
   ↓
API Layer
   ↓
Service Layer
   ↓
Model Layer
```

---

# 📂 Project Structure

```text
HotelReservationApp
│
├── src
│   ├── api
│   │   ├── AdminResource.java
│   │   └── HotelResource.java
│   │
│   ├── model
│   │   ├── Customer.java
│   │   ├── FreeRoom.java
│   │   ├── IRoom.java
│   │   ├── Reservation.java
│   │   ├── Room.java
│   │   └── RoomType.java
│   │
│   ├── service
│   │   ├── CustomerService.java
│   │   └── ReservationService.java
│   │
│   └── ui
│       ├── AdminMenu.java
│       └── MainMenu.java
```

---

# 🧠 Layer Explanation

## 1️⃣ UI Layer

The UI layer manages all console-based interactions with the user.

### Main Components

* `MainMenu.java`
* `AdminMenu.java`

### Responsibilities

* Menu navigation
* User input handling
* Reservation interaction flow
* Admin operation management

---

## 2️⃣ API Layer

The API layer acts as an intermediary between the UI and the service layer.

### Main Components

* `HotelResource.java`
* `AdminResource.java`

### Responsibilities

* Delegating operations
* Providing clean interfaces
* Separating business logic from UI logic

---

## 3️⃣ Service Layer

The service layer contains the core business logic of the application.

### Main Components

* `CustomerService.java`
* `ReservationService.java`

### Responsibilities

* Customer management
* Reservation processing
* Room availability checks
* Reservation storage
* Validation handling

---

## 4️⃣ Model Layer

The model layer contains all application entities.

### Main Components

* `Customer`
* `Room`
* `FreeRoom`
* `Reservation`
* `RoomType`

### Responsibilities

* Data representation
* Entity relationships
* Encapsulation of object properties

---

# 💡 Object-Oriented Concepts Used

This project demonstrates several important OOP concepts:

| Concept       | Usage                                  |
| ------------- | -------------------------------------- |
| Encapsulation | Private fields with getters/setters    |
| Inheritance   | `FreeRoom` extends `Room`              |
| Abstraction   | `IRoom` interface                      |
| Polymorphism  | Interface-based room handling          |
| Composition   | Reservation contains customer and room |

---

# 🛏️ Room Types

The system supports multiple room types:

* SINGLE
* DOUBLE

The application also supports:

* Paid rooms
* Free rooms (`FreeRoom.java`)

---

# 🔍 Reservation Workflow

The reservation workflow includes:

1. Customer account creation
2. Room search using dates
3. Room availability validation
4. Reservation confirmation
5. Reservation storage

If no rooms are available:

* the application recommends alternative dates
* users can retry booking

---

# 📦 Technologies Used

| Technology       | Purpose                   |
| ---------------- | ------------------------- |
| Java             | Core programming language |
| IntelliJ IDEA    | Development environment   |
| Java Collections | Data storage              |
| OOP Principles   | Software design           |
| Console UI       | User interaction          |

---

# 🧪 Validation & Error Handling

The application includes validation handling for:

* Invalid email formats
* Incorrect menu selections
* Duplicate room booking prevention
* Invalid reservation dates
* Null checks
* Input safety

---

# ▶️ Running the Project

## Prerequisites

Install:

* Java 11 or higher
* IntelliJ IDEA or VS Code

---

## Steps to Run

### 1️⃣ Clone Repository

```bash
git clone <repository-url>
```

### 2️⃣ Open Project

Open the project in:

* IntelliJ IDEA
* VS Code

---

### 3️⃣ Run Main Application

Run:

```text
MainMenu.java
```

The console application menu will start.

---

# 📌 Example Functionalities

## Create Customer

```text
Enter First Name:
Enter Last Name:
Enter Email:
```

---

## Search Rooms

```text
Enter Check-In Date:
Enter Check-Out Date:
```

---

## Make Reservation

```text
Select Available Room
Confirm Booking
```

---

# 🔧 Custom Improvements Added

Several improvements were added to improve maintainability and project structure:

* Improved helper methods
* Better separation of concerns
* Cleaner service handling
* Structured architecture
* Enhanced readability
* Utility method additions
* Better validation flow
* Improved menu organization

---

# 📈 Future Improvements

Potential future enhancements:

* Database integration (MySQL/PostgreSQL)
* Spring Boot migration
* REST API conversion
* User authentication
* GUI interface
* Payment gateway integration
* Hotel analytics dashboard
* Reservation cancellation support
* Docker deployment

---

# 👨‍💻 Author

## Jashan Gupta

Software Engineer | Java Developer | Backend Engineering Enthusiast

### Skills Demonstrated

* Java Development
* OOP Design
* Backend Logic Design
* Service Layer Architecture
* Reservation Workflow Systems
* Console Application Development

GitHub:
[https://github.com/Jashan122005](https://github.com/Jashan122005)

LinkedIn:
[https://linkedin.com/in/jashan-analyst/](https://linkedin.com/in/jashan-analyst/)

---

# 📜 License

This project was developed for educational and learning purposes.

---

# ⭐ Final Notes

This project helped strengthen practical understanding of:

* Java application development
* Object-oriented programming
* Service-based architecture
* Reservation system workflows
* Clean code structure
* Layered software design
* Business logic implementation

The implementation focuses on maintainability, readability, scalability, and clean engineering practices.
