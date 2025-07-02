# Student Course Management System 🧑‍🎓📚

A full-stack Spring Boot project that manages students, courses, and enrollments. Built with clean architecture and layered design principles.

---

## 🚀 Features

- Add, view, and delete Students and Courses
- Enroll students into courses
- RESTful API design with DTOs
- Exception handling with custom error responses
- Layered architecture (Controller, Service, Repository)
- Configurable via `application.properties`

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Maven
- Lombok
- H2 Database (in-memory)
- Postman (for API testing)

---

## 📦 Project Structure

```bash
src/
 └── main/
      └── java/com/studentmgmt/
           ├── controller/
           ├── dto/
           ├── entity/
           ├── repository/
           ├── service/
           ├── util/
           └── config/
 └── resources/
      └── application.properties
