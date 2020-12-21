# WebApp
 ## A. Project Description and Subsystems
 In this project we designed and implemented a basic CRUD Java-Spring Boot Web Application, in Eclipse IDE, for company staff.
 ### 1.Databasse Subsystem
 The database subsytem was implemented with **mySQL** and database connection with **JPA-Hibernate**.
 The tables that are created in database are below.
 #### Tables
 1.Employees
 
 
 | Attribute |     Attribute's Description     |       Properties       |
|:---------:|:-------------------------------:|:----------------------:|
| Empiid    |          Employee's ID          |       Primary Key      |
| Lastname  |       Employee's last name      |                        |
| Firstname |      Employee's first name      |                        |
| Job       |          Employee's job         |                        |
| Comm      | Employee's Commission of a year |                        |
| Salary    |   Employee's Salary of a year   |                        |
| Hiredate  |       Employee's hire date      |                        |
| Deptid    |    Employee's Department's ID   | Ref Departments.Deptid |
| MNGID     |     Employee's Manager's ID     | Ref Employees.Empid    |

2.Departments

| Attribute |   Attribute's Description  |           Properties           |
|:---------:|:--------------------------:|:------------------------------:|
|  Deptiid  |       Department's ID      |           Primary Key          |
|   Dname   |      Department's name     |                                |
|   LocId   | Departmemt's Location's ID | Ref Department_Locations.Locid |

3.Department_Locations

| Attribute |    Attribute's Description   |  Properties |
|:---------:|:----------------------------:|:-----------:|
|   LocId   |  Department's Location's ID  | Primary Key |
|  LocName  | Department's Location's name |             |


 ### 2.Web site and Web Services Subsystems
 For Web site's implementation we used
 In the Web site is displayed:
 * List of all Department Locations
 * List of all Departments in a specific location
 * List of all Employees working in a specific Department
 * Details of an Employee
 All these functionalities were implemented using  **Jsp/Web Servlet** and are displayed as a REST API response in xml format, as well.
 ## B.How to install
 The following steps will help you to install and run the project.
 1. Download the code in MyWebApp
 2. Import files into Eclipse IDE
 3. Create a database with name mydatabase
 4. Change spring.datasource.url, spring.datasource.username,spring.datasource.password according to yours ones.These are into [application.properties](), click on to visit them.Now you can connect to the database that you created before.
 5. Run......
 
 Now, you can manually, "fill" the tables, that are created in your database, using mySQL workbench for example.
 
 ## C. How to use it
 
 ### Web site
 
You can visit localhost:8080/locations and see a list all department's locations and pressing any of the buttons, you can see all departments that belongs to each location. Finally, you can see all employees working in each department as well as all details of each employee, pressing the suitable buttons.

 
 
 
 
 
 
 
 
 
 
