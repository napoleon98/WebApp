# WebApp
 ## A. Project Description
 In this project we designed and implemented a basic CRUD Java-Spring Boot Web Application for company staff.
 ### Databasse Subsystem
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


