# MODULE: Java Persistence API (JPA)

© 2026 Busycoder Academy. All rights reserved.  
This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.  
This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 12 – JPA CRUD + Layered Architecture (DAO → Service → Presentation)

---

## Learning Objectives

After completing this assignment, the participant will be able to:

- Understand JPA as an abstraction over JDBC
- Implement CRUD operations using **JPA + Hibernate**
- Design a clean layered architecture (Presentation → Service → DAO)
- Use **EntityManager** correctly
- Understand transaction boundaries in JPA
- Prepare code for real-world Spring Boot / enterprise usage
- Appreciate why JPA reduces boilerplate compared to JDBC

---

## General Instructions

1. Follow layered architecture strictly:
   - Presentation Layer → CLI-based (Scanner)
   - Service Layer → Business rules
   - DAO Layer → JPA persistence logic only

2. **No JDBC code allowed** (no Connection, PreparedStatement, ResultSet).

3. Use:
   - JPA (javax.persistence / jakarta.persistence)
   - Hibernate as JPA provider

4. Database:
   - MySQL / PostgreSQL (your choice)

5. Use `persistence.xml` for configuration.

6. Use **EntityManager**, not Hibernate Session directly.

7. Transactions must be handled properly.

---

## Database Table

```sql
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    isbn VARCHAR(20),
    title VARCHAR(200),
    author VARCHAR(100),
    price DOUBLE
);
