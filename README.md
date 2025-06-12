**🧑‍💼 EMPLOYEE MANAGEMENT SYSTEM (EMS)**
A Java-based desktop application integrated with MySQL, designed for efficient employee and department management. Developed as part of the DBMS Lab and Advanced Java course requirements at **Ramaiah Institute of Technology**, this project applies concepts of database normalization, GUI design, JDBC connectivity, and modular Java development.

---

**📌 PROJECT OVERVIEW**
The EMS is a comprehensive system that performs CRUD operations, generates reports, supports user login authentication, and provides a user-friendly interface for administrators to manage workforce data. It integrates practical DBMS design with Java GUI programming.

---

**🎯 OBJECTIVES OF THE PROJECT**

* Design a well-structured, normalized relational database to manage employee and department data.
* Build Java GUI interfaces using Swing and AWT for interaction.
* Implement JDBC to connect Java with MySQL for performing CRUD operations.
* Apply key DBMS concepts like ER modeling, normalization up to 3NF, relational schema mapping, and constraints.
* Demonstrate real-world understanding of core and advanced Java through modular class design.
* Provide features like authentication, reporting, and data printing with minimal technical skill required from the user.

---

**🧠 PROJECT FEATURES**

* Centralized employee and department data management.
* Secure login-based access to the system.
* Add, update, view, delete employee details.
* Manage departments (create, view, delete).
* Generate summary reports.
* Execute custom SQL queries dynamically.
* Validate inputs for correctness and uniqueness (e.g., email, phone, Aadhar).
* Data printing support for HR use.

---

**✅ FUNCTIONAL REQUIREMENTS**

* Perform CRUD operations on employee and department data.
* View records in table format using GUI.
* Generate department-wise or role-wise reports.
* Search records with various filters.
* Connect frontend Java Swing interface with backend MySQL database using JDBC.
* Support for login authentication.

**⚙️ NON-FUNCTIONAL REQUIREMENTS**

* Ensure data consistency through normalization and constraints.
* Optimize SQL queries for quick response.
* Maintain modular class design for easy debugging and extension.
* Provide scalable backend that can support multiple users.
* Ensure system security, especially for confidential fields like salary or credentials.

---

**🛠 TECHNOLOGIES AND TOOLS USED**

* **Frontend:** Java AWT, Swing
* **Backend:** MySQL 8.x
* **Database Connectivity:** JDBC (Java Database Connectivity)
* **Programming Concepts:** OOP (Encapsulation, Inheritance, Abstraction), Exception Handling
* **Tools/IDE:** IntelliJ IDEA, Eclipse, MySQL Workbench

---

**📂 SYSTEM MODULES AND CLASSES**

1. **Splash.java** – Displays the splash screen on application launch.
2. **login.java** – Handles login functionality using the `login` table.
3. **Main\_class.java** – Dashboard/Main Menu interface to navigate all modules.
4. **AddEmployee.java** – Form to insert new employee data.
5. **UpdateEmployee.java** – Search and update existing employee details.
6. **RemoveEmployee.java** – Remove employee record based on empID.
7. **View\_Employee.java** – View all employee records using JTable.
8. **ManageDepartment.java** – Manage department creation, deletion, and viewing.
9. **EmployeeSummaryReport.java** – Generate summary reports for employees.
10. **CustomQuery.java** – Execute user-defined SQL SELECT queries.
11. **conn.java** – Utility class to handle MySQL database connection and SQL statement execution.

---

**🧬 DATABASE DESIGN OVERVIEW**

**Database Name:** `employeemanagement`

**Tables:**

1. **login**

   * `username`, `password`

2. **employee**

   * `empId` (Primary Key)
   * `name`, `fname`, `dob`, `salary`, `address`, `phone`, `email`, `education`, `designation`, `aadhar`,
   * `deptId` (Foreign Key referencing department)
   * `roleId` (Foreign Key referencing role)

3. **department**

   * `deptId` (Primary Key)
   * `deptName`, `location`

4. **role**

   * `roleId` (Primary Key)
   * `roleName`, `deptId` (Foreign Key referencing department)

5. **works\_on** (optional many-to-many relationship)

   * `empId`, `roleId`
   * Composite Primary Key: (`empId`, `roleId`)

---

**📈 NORMALIZATION**

* **1NF**: Atomic values, no repeating groups (e.g., one phone number per record).
* **2NF**: All non-key attributes depend on full primary key (no partial dependency).
* **3NF**: No transitive dependencies; department name stored separately from employee records.

---

**🖥️ USER INTERFACE SCREENS**

* Front Page
* Login Screen
* Dashboard / Main Menu
* Add Employee Form
* Update Employee
* View Employee Table (JTable)
* Print Employee Details
* Department Management Interface
* Custom SQL Query Screen
* Summary Report Display

---

**🧪 SAMPLE SQL QUERIES USED**

* `SELECT * FROM employee WHERE salary > 50000;`
* `INSERT INTO department (deptId, deptName, location) VALUES (4, 'Legal', 'Mumbai');`
* `UPDATE employee SET salary = 60000 WHERE empId = 103;`
* `DELETE FROM employee WHERE empId = 101;`
* `SELECT deptName, COUNT(*) FROM employee e JOIN department d ON e.deptId = d.deptId GROUP BY d.deptName;`

---

**🔮 FUTURE ENHANCEMENTS**

* Implement a web-based interface using JSP or React.
* Add role-based access control (Admin vs HR vs Viewer).
* Generate reports in PDF or Excel format.
* Host the database on cloud (AWS RDS, Firebase, etc.).
* Build dashboards for HR analytics (e.g., average salary, role-wise distribution).
* Add email notification for HR updates like onboarding, promotions, etc.
* Enable batch upload using CSV.

---
**👨‍🎓 PROJECT DEVELOPER**

* Name: **Akash Shivanand Navani**
* USN: 1MS24IS402
* Course: Bachelor of Engineering (Information Science & Engineering)
* Institution: Ramaiah Institute of Technology
* Academic Year: 2024–2025

---

