# MODULE: Advance Spring Boot Microservices Development

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

# Assignment 5 – Angular ProductStore Frontend (Angular 18)

---

## Objective

In this lab, you will build the **frontend UI** for a **ProductStore application** using **Angular 18**.

A **Spring Boot ProductStore REST API** will be **provided to you**.

Your task is to **consume the backend APIs and display product data on a web page**.

---

## Important Instructions

- **Spring Boot ProductStore backend is already implemented**
- Backend APIs will be shared (base URL + endpoints)
- You must:
  - Create a **new Angular 18 project**
  - Call backend APIs
  - Display products in the browser

### Strict Rules

- ❌ Do NOT use ChatGPT
- ❌ Do NOT use Google
- ❌ Do NOT copy from GitHub or blogs
- ✅ Use:
  - Class notes
  - This assignment
  - Your own understanding

Violation of rules = **direct disqualification**

---

## Backend Details (Provided)

The backend exposes REST APIs such as:

- `GET /products` → fetch all products
- `GET /products/{id}` → fetch product by id
- `POST /products` → add product
- `PUT /products/{id}` → update product
- `DELETE /products/{id}` → delete product

You **do NOT** need to write any Spring Boot code.

---

## Tasks

### Step 1 — Create Angular Project

- Use **Angular 18**
- Project name: `productstore-ui`
- Use **non-standalone components**
- Use **HttpClientModule**

---

### Step 2 — Create Product Model

Create a Product model matching backend response fields, for example:

- id
- name
- price
- quantity
- category

(Exact fields will be visible from API response)

---

### Step 3 — Create Product Service

- Create `ProductService`
- Use `HttpClient`
- Implement method to:
  - Fetch all products from backend
- Backend base URL will be provided

---

### Step 4 — Display Products

- Create `ProductListComponent`
- On page load:
  - Call backend API
  - Display all products in a table or card layout

Minimum columns:
- Product Name
- Price
- Quantity
- Category

---

### Step 5 — UI Requirements

- Clean and readable UI
- Use basic HTML + CSS
- No third-party UI libraries required
- Data must come **only from backend API**

---

## Deliverables

- Angular 18 project source code
- Products visible in browser
- Proper folder structure
- Working API integration

---

## Evaluation Criteria

- Angular project setup correctly
- API integration works
- Products displayed correctly
- Clean component & service design
- No hardcoded product data

---

## Outcome

After this lab, you should be confident in:

- Creating Angular projects
- Calling Spring Boot REST APIs
- Displaying backend data in UI
- Separating frontend and backend responsibilities
