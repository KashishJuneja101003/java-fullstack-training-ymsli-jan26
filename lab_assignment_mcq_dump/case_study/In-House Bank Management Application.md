# In-House Bank Management Application  
## Final Case Study – YMSLI Java Induction Training Project

---

## 1. Objective

The objective of this project is to design and develop an internal bank management system used by bank staff to perform daily banking operations.

The application focuses on:

- Secure transaction processing  
- Role-based authorization  
- Approval workflow for high-value withdrawals  
- Complete audit and traceability  

This is **not** an internet banking or customer-facing application.

---

## 2. Technology Stack

### Backend
- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- Spring Security (JWT)  
- MySQL  
- Embedded Tomcat  

### Frontend
- Angular 18+  
- TypeScript  
- HTML, CSS, Bootstrap  

---

## 3. Application Scope

- Used internally inside the bank  
- No external customers or self-service access  
- All operations performed by bank employees  
- Emphasis on correctness, security, and auditability  

---

## 4. User Roles

### 4.1 Manager
- System administrator and final authority  
- Creates and manages bank accounts  
- Creates and manages clerk users  
- Approves or rejects high-value withdrawals  
- Views complete transaction history of any account  
- Performs audit and monitoring  

### 4.2 Clerk
- Performs daily banking operations  
- Deposits money into accounts  
- Withdraws money from accounts  
- Initiates high-value withdrawal requests  
- Views permitted transaction histories  

---

## 5. Client (Account Holder)

- Client is not a system user  
- Client does not log in  
- Client data exists only as account information  
- All actions are performed by clerks or managers  

---

## 6. Core Business Rules

### 6.1 Withdrawal Authorization Rule

- Withdrawal amount **≤ ₹2,00,000**  
  → Clerk can process directly  

- Withdrawal amount **> ₹2,00,000**  
  → Manager approval is mandatory  

### 6.2 Approval Workflow

- High-value withdrawals are created with status `PENDING_APPROVAL`  
- Manager can approve or reject the request  
- Account balance is updated **only after approval**  

---

## 7. Functional Requirements

### 7.1 Account Management
- Create bank accounts  
- Auto-generate unique account numbers  
- Maintain current balance  

### 7.2 Transaction Management

Supported transactions:
- Deposit  
- Withdrawal  

Each transaction must record:
- Transaction ID  
- Account number  
- Transaction type  
- Amount  
- Date and time  
- Performed by (Clerk ID)  
- Approval status  
- Approved by (Manager ID, if applicable)  

Transaction history must be **immutable and read-only**.

### 7.3 Transaction History
- Complete history available for audit  
- Manager can view any account history  
- Clerk can view permitted histories only  
- Pagination supported  

---

## 8. Frontend Screen Requirements (Brief)

Frontend is used only to consume backend APIs and display data.

### 8.1 Common Screens
- Login screen (JWT-based authentication)  
- Role-based dashboard  
- Logout functionality  

### 8.2 Manager Screens
- Dashboard (summary and pending approvals)  
- Account creation and listing  
- Clerk user management  
- Withdrawal approval screen  
- Transaction history view (read-only)  

### 8.3 Clerk Screens
- Dashboard  
- Deposit screen  
- Withdrawal screen  
- Transaction history view (read-only)  

### 8.4 Validation & Error Handling
- Input validation  
- Friendly error messages  
- Unauthorized access handling  

---

## 9. Non-Functional Requirements

- Role-based access control  
- Secure authentication and authorization  
- Data consistency and integrity  
- Clear audit trail  
- Proper exception handling  
- Pagination and performance considerations  

---

## 10. Project Evaluation Criteria

### 10.1 Backend Design & Implementation – 50%
- Clean layered architecture  
- Proper use of Spring Boot and Spring Data JPA  
- Correct implementation of business rules  
- Transaction management and consistency  
- Secure JWT-based authentication  
- REST API design and HTTP status usage  
- Exception handling and validation  

### 10.2 Testing & Code Quality – 20%
- Unit tests for service and controller layers  
- Meaningful test coverage  
- Clean code practices  
- Naming conventions and readability  
- Avoidance of common code smells  

### 10.3 Functional Correctness – 15%
- Withdrawal approval workflow correctness  
- Role-based access enforcement  
- Immutable transaction history  
- Accurate balance updates  

### 10.4 Frontend Integration – 10%
- Correct API integration  
- Role-based screen visibility  
- Proper handling of success and error responses  
- Clean separation between UI and backend logic  

### 10.5 Documentation & Understanding – 5%
- Clear project structure  
- Readable code  
- Ability to explain design decisions and flow  

---

## 11. Conclusion

This project is designed to evaluate a developer’s ability to:

- Build secure, correct, and maintainable backend systems  
- Implement real-world banking workflows  
- Apply clean architecture principles  
- Integrate frontend as a supporting layer  
