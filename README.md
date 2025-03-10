# REST API with frameworks: **SpringBoot** + **Angular** 


### License

This project is licensed under **MIT** license. See the `LICENSE` file for more informations. 

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/nathan00pdl/crud-angular-spring/blob/main/LICENSE) 


> **Note**: *This readme is being written throughout the development of the project!*


# About the Project

This project was carried out in conjunction with the course provided by **Loiane Groner**, accessible at **https://www.youtube.com/watch?v=qJnjz8FIs6Q&list=PLGxZ4Rq3BOBpwaVgAPxTxhdX_TfSVlTcY**.

It is a simple **CRUD** involving a relationship between **courses** and **lessons**, which its implementation was done mainly with the **Angular** and **SpringBoot** frameworks.

This was my second complete implementation of a **REST API**, containing much more details and structuring features compared to my first **API** project - **https://github.com/nathan00pdl/api-test**. Furthermore, it was my first frontend contact with the **Angular** framework.

I belive that this project gave me great contact with a **REST API** that could be used in production, acording to **Loiane**, therefore being a great source of knowledge and **learning practice**. 


> **Note**: *The project as a whole has several redundant comments, as I challenged myself to implement some technologies that I had never had contact with, therefore it is a real project for study and practice purposes.*


## Backend Structure
- **Layered architecture - MVC**
- Design pattern: **DTO** (Data Transfer Object)

## Applied concepts of REST API 
- Use of **HTTP** methods, such as **GET, POST, PUT** and **DELETE** to perform operations on resources.
- Use of **URLs** (Uniform Resource Locators) to identify especific resources.
- Data transfer between client and server in a standard **JSON** format.
- Maintaining the state of application on the client, without storing it on the server.

## Tecnologies
- **Java 17**
- **Spring Boot 3.4.3**
- **Maven**
- **JPA** + **Hibernate**
- **Docker**
- **Docker Compose**
- **MySQL 8.0 image**
- **Migrations - Flyway**
- **Angular v19**
- **Angular Material**

## Main Knowledge Applied and Developed
- Greater mastery of **Layered Architecture - mvc**
- **DTO** design pattern implemented with **Records** in **java**
- **Mappers** declaration for mapping **DTOs** and **Entities**
- **SOLID OCP** principle with **Dependency Injection** via constructor
- **Data Persistence** in java with **JPA** and **Hibernate** implementation
- **Database Versioning** with **Migrations - Flyway**
- Application **Containerization** with **Docker Compose** + creating **Images** with **DockerFile**
- Use of **Docker Compose** via dependency injected into the **Spring Boot** framework - Docker Compose Support
- **RESTful application authentication** with **JWT (JSON Web Token)** as an alternative to the traditional use of **cookies** and **sessions** on the **server**
- **Filters** as component in SpringBoot to **intercept HTTP requests** and determine user **authentication** and **authorization**
