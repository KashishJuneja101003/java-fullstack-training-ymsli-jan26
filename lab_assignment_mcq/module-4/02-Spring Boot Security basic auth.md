# MODULE: Advance Spring Boot Microservices Development

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

# Assignment 1 – Spring Security Basic Auth and JWT (Authentication & Authorization)

---

## Learning Objectives

Participants will:

- Understand Spring Security fundamentals  
- Configure in-memory and database-backed authentication  
- Apply role-based authorization  
- Secure REST endpoints using method-level security  
- Test protected APIs using Postman  

---

## General Instructions

- Use your existing Book Management application  
- Add Spring Security dependencies  
- Use roles: ROLE_STUDENT and ROLE_TEACHER  
- Authorize methods using @PreAuthorize  

---

## Step-by-Step Tasks

### Step 1 — Configure Basic Authentication

- Create a SecurityConfig class  
- Add two in-memory users:
  - student / ROLE_STUDENT  
  - teacher / ROLE_TEACHER  

---

### Step 2 — Apply Authorization Rules

Use @PreAuthorize:

- STUDENT + TEACHER → create, read, update  
- TEACHER only → delete  

Example:

```java
@PreAuthorize("hasRole('TEACHER')")
public void deleteBook(Integer id) { ... }
