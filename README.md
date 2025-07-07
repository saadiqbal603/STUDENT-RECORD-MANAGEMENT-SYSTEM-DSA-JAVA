---

**🎓 Course:** Data Structures Algorithm  
**📅 Semester:** 3rd Semester  

---

# 🎓 SZABIST Student Record Management System

A Java console-based **Student Record Management System** integrated with a **MySQL database**. This application allows administrators to **add**, **search**, **delete**, and **view** student records, utilizing both an in-memory **linked list** and **JDBC** for database operations.

---

## 📌 Features

- 🔐 **Admin Login Authentication**: Secure access with username and password.
- ➕ **Add New Student Records**: Input and store student details in both the database and linked list.
- 🔍 **Search Student by Roll Number**: Quickly locate a student’s record by their roll number.
- 🗑️ **Delete Student Records**: Remove student records from both the database and linked list.
- 📄 **View All Student Records**: Display all stored student records.
- 🔗 **MySQL Database Integration**: Persistent storage using JDBC.
- 🧠 **In-memory Linked List**: Fast access and manipulation of records in memory.

---

## ⚙️ Technologies Used

- **Java**: Object-Oriented Programming, Exception Handling
- **MySQL**: Relational database for persistent storage
- **JDBC**: Java Database Connectivity for database operations
- **Data Structures**: Custom Linked List implementation
- **IDE**: IntelliJ IDEA or Eclipse (recommended)

---

## 📁 Project Structure

```
StudentRecordSystem/
│
├── Main.java          # Entry point, handles menu and DB operations
├── Student.java       # Linked list implementation for record handling
├── Node.java          # Node structure for linked list
└── README.md          # Project documentation
```

---

## 💾 Database Schema

Before running the application, set up the MySQL database and table:

```sql
CREATE DATABASE student_management_system;

USE student_management_system;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    rollNo INT UNIQUE,
    Dept VARCHAR(100),
    Marks INT
);
```

---

## 🚀 How to Run

### ✅ Requirements
- **Java JDK 8** or higher
- **MySQL Server**
- **MySQL JDBC Driver** (add to project classpath)

### ▶️ Steps
1. Clone or download the repository.
2. Ensure your MySQL server is running.
3. Update database credentials in `Main.java` if necessary:

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/student_management_system", "root", null);
```

4. Compile and run the program:

```bash
javac com/company/*.java
java com.company.Main
```

### 🧪 Admin Login
- **Username**: Admin
- **Password**: admin

> **Note**: Incorrect login attempts will prompt re-entry of credentials.

---

## 📊 Functional Overview

1. **Add Student Record**
   - Inputs: Name, Roll No, Department, Marks
   - Stored in both MySQL database and in-memory linked list

2. **Delete Student Record**
   - Removes the record from both the database and linked list

3. **Search Student Record**
   - Search by Roll No
   - Displays student details if found

4. **View All Student Records**
   - Shows all student entries from the database and memory

---

## 💡 Concepts Practiced

- **JDBC MySQL Database Integration**
- **Object-Oriented Programming**
- **Custom Linked List Implementation**
- **Exception Handling**
- **Console-Based Menu UI**

---

## 📷 Sample Output

```
Welcome to SZABIST Student Record Management System

Menu:
1. Create New Record
2. Delete a Student Record
3. Search a Student Record
4. View All Student Records
5. Exit
```

---

