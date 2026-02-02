# Spring Boot Lab Assignment  
## Trainee Management System (Single POJO, JDBC ↔ JPA Swappable)

---

## Objective
Develop a Spring Boot application that exposes REST APIs for trainee management and allows **switching persistence implementation (JDBC or JPA)** using configuration **without changing controller or service code**.

---

## Core Design Rule (Important)

> A **single POJO `Trainee`** must be used:
- As REST request/response model  
- As DAO transfer object  
- As JPA entity  

No separate DTO and Entity classes.

---

## Architecture to Follow

REST Controller
↓
Service Layer
↓
DAO Interface
↓
JDBC DAO OR JPA DAO

yaml
Copy code

Service and controller must remain **persistence-agnostic**.

---

## 1. Domain Model (Single POJO)

Students must create **one class only**:

Trainee

yaml
Copy code

### Requirements
- Fields match trainee table
- Annotated with JPA annotations (`@Entity`, `@Table`, `@Id`)
- No JDBC code
- No business logic

### Usage
- REST layer
- Service layer
- DAO layer
- JPA persistence

> JDBC DAO will simply ignore JPA annotations — this is acceptable.

---

## 2. REST API Layer (Mandatory)

Students must create REST endpoints using Spring MVC.

### Required APIs

| Method | Endpoint | Description |
|------|--------|-------------|
| POST | `/trainees` | Add a trainee |
| GET | `/trainees/{id}` | Fetch trainee by ID |

### Rules
- JSON input/output
- Validation handled at controller or service layer
- Controller must call **service only**, never DAO directly

---

## 3. DAO Interface (Persistence Contract)

```java
public interface TraineeDAO {
    void addTrainee(Trainee trainee);
    Trainee findById(int traineeId);
}
Rules
No framework-specific code in the interface

Service layer depends only on this interface

4. JDBC DAO Implementation
Students must implement:

TraineeJdbcDAO

Use JdbcTemplate

Read DB configuration from application.properties

Handle transactions properly

Restrictions
No EntityManager

No JPA APIs

SQL confined strictly to DAO layer

5. JPA DAO Implementation
Students must implement:

TraineeJpaDAO

Use EntityManager

Use the same Trainee class as JPA entity

Restrictions
No JDBC code

No SQL in service or controller

Use JPA lifecycle methods (persist, find)

6. DAO Switching via Configuration (Critical Requirement)
Persistence selection must be externalized.

Example:

properties
Copy code
trainee.dao.type=jdbc
or

properties
Copy code
trainee.dao.type=jpa
Rules
Switching must not require any code change

No if-else logic in service or controller

Use Spring conditional configuration

7. Exception Handling (Mandatory)
Students must:

Catch low-level persistence exceptions

Wrap them in TraineeDataAccessException

Propagate clean exceptions to REST layer

No SQL or JPA exceptions should leak outside the DAO layer.

8. Database Handling (Simplified)
Table may be auto-created by JPA

JDBC implementation must work with the same schema

Sample data is optional

Focus is architecture and layering, not DDL mastery.

Design Note (Explain to Students)
Using one POJO for both DTO and Entity is:

Acceptable for small systems and labs

Common in CRUD-focused enterprise applications

A conscious simplification, not a design mistake

(Separation can be introduced later for large-scale systems.)