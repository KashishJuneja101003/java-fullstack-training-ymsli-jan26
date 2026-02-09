# MODULE: Advance Spring Boot Microservices Development

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

# Assignment 2 – JWT Authentication & Authorization

---

## Learning Objectives

Participants will:

- Implement JWT login  
- Generate tokens using login endpoint  
- Validate JWT in filters  
- Secure endpoints with method-level rules  
- Enforce role-based access with JWT claims  

---

## General Instructions

- Extend Assignment 1  
- Add /authenticate endpoint  
- Use JWT libraries (jjwt or java-jwt)  
- Return JWT token upon login  

---

## Step-by-Step Tasks

### Step 1 — Create Authentication Endpoint

POST /authenticate

- Accept username/password  
- Authenticate  
- Generate JWT  

---

### Step 2 — Implement JWT Filter

Intercept every request:

- Extract JWT  
- Validate signature  
- Set authentication context  

Invalid token → 401

---

### Step 3 — Secure Endpoints

- STUDENT + TEACHER → read, create  
- TEACHER → delete  

---

### Step 4 — Optional Bonus

- Token expiry  
- Refresh token endpoint  

---

## Deliverables

- Spring Boot app with JWT  
- Working /authenticate  
- Postman collection  

---

## Evaluation Criteria

- Correct JWT generation  
- Proper validation filter  
- Correct RBAC enforcement  
- Clean code + logs  
