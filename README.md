# employee_app

A Webapp to manage Employees their attributes and supervisors. 

- /login page
- /register (>> refers to user)
- /create (>> refers to employee)
- /edit/(employee_id)


Validations are applied using **jQuery** at front-end and by throwing exceptions at back-end **e.g.** when duplicate user email
is inserted, trying to create employee that already exists or some kind of violation of the employee-supervisor hierarchy.

Inside `pom.xml` you will find these dependencies:
 
 - Spring Web
 - Spring JPA
 - Spring Security
 - Apache Freemarker 
 - MySql Connector

Implemented using  **HTML5**, **CSS3**, **Javascript**, **jQuery**, **Java** and **MySQL** and managed using **Maven**.

## How to use?

To simply login you can either enter one of the default combinations of email and password stored in DB located at `import.sql` *or
you can actually make your own account* by clicking at the link under login prompt when in `/login`!

> **Note:** The Webapp uses BCryptPasswordEncoder as PasswordEncoder for SecurityConfig

Also, a plain `user` cannot have the same authorities as an `admin` meaning he cannot delete or edit employees and attributes
only view them.

### Connect with me 

- [LinkedIn](https://www.linkedin.com/in/geo-georgiou/)

- [GitHub](https://github.com/geogeorgiou)

- [GitLab](https://gitlab.com/geogeorgiou)
