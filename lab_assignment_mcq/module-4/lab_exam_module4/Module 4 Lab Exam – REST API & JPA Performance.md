# Lab Exam – REST API & JPA Performance

You will be provided with a **sample Spring Boot project**.  
Your task is to complete the remaining REST APIs, apply proper backend design, and demonstrate **performance awareness**, especially around **JPA/Hibernate fetching and the N+1 problem**.

This assignment evaluates **real backend engineering skills**, not just CRUD familiarity.

---

## Project Context

The given project is a **Spring Boot REST application**.

### Technology Stack
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL (or compatible RDBMS)

Basic entities, configurations, and a few endpoints are already implemented.  
You are expected to **extend and complete** the application.

---

## Your Responsibilities

### 1. Complete REST Endpoints

You must implement all missing REST APIs required to manage the domain model.

This typically includes:
- Create
- Read (single & list)
- Update
- Delete
- Association-based fetches (e.g., parent with children)

⚠️ **Endpoints must follow REST conventions**
- Proper HTTP methods
- Correct HTTP status codes
- Clean request/response structure

---

### 2. Service & Layered Design

Design must follow a layered architecture:

- Controllers must be **thin**
- Business logic must be inside the **Service layer**
- Repository layer should handle **only persistence**

🚫 No business logic in controllers  
🚫 No direct repository calls from controllers

---

### 3. JPA Relationships & Fetching

You must correctly handle:
- Entity relationships (`@OneToMany`, `@ManyToOne`, etc.)
- Lazy vs Eager loading
- Bidirectional mappings (if present)

⚠️ Do **not** expose entities blindly from controllers if it causes:
- Performance issues
- Serialization problems (infinite recursion, large payloads)

---

### 4. N+1 Problem Awareness (MANDATORY)

At least one API in this project will **naturally produce an N+1 query problem** if implemented naïvely.

Your task:
- Identify where N+1 occurs
- Fix it using an appropriate strategy, such as:
  - `JOIN FETCH`
  - DTO projections
  - `@EntityGraph`
  - Batch fetching

You must be able to explain:
- **Why** N+1 was happening
- **How** your solution fixes it

---

### 5. Performance & Observability

Enable and use the following configuration:

```properties
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

You should be able to:
Observe SQL queries
Reason about query count
Justify your design decisions

6. Error Handling
Implement basic error handling for:
Resource not found
Invalid input
Empty results (where applicable)
Use meaningful HTTP status codes.