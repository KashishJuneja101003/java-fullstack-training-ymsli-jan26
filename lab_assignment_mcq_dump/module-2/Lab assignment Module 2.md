# Lab Assignment: Trainee Management System

## Objective
To design and implement a Trainee Management System using Java, following enterprise design principles, with the ability to switch persistence implementations between JDBC and JPA without changing business logic.

## Problem Statement
Develop a simple TraineeMgt application that manages trainee records in a relational database.  
The system must store trainee details, allow insertion of records, and support searching a trainee by ID.

## Database Design

### Table Name: trainee

| Column Name   | Data Type        | Description |
|--------------|------------------|-------------|
| trainee_id   | INT (PK)         | Unique trainee identifier |
| trainee_name | VARCHAR(100)     | Name of the trainee |
| branch       | VARCHAR(20)      | Training branch (java / oracle / php / dotnet) |
| percentage   | DECIMAL(5,2)     | Training percentage |

## Task 1: Data Initialization
Insert at least 5 trainee records (your batch mates) into the trainee table.

Ensure:
- Unique trainee_id  
- Valid branch values  
- Percentage range between 0 and 100  

## Task 2: Application Development
Develop a Java application that supports the following operations:
- Add a Trainee  
- Find Trainee by ID  

## Functional Requirements

### 1. Design Patterns (Mandatory)

#### a) DTO (Data Transfer Object)
- Create a Trainee class representing one trainee.  
- Fields must exactly match the table structure.  
- No business logic inside DTO.

#### b) DAO (Data Access Object)
Define a TraineeDAO interface with the following methods:
- `void addTrainee(Trainee trainee)`
- `Trainee findTraineeById(int traineeId)`

### 2. Persistence Flexibility (Very Important)
The system must support both JDBC and JPA implementations.

#### a) JDBC Implementation
Create TraineeJdbcDAO implementing TraineeDAO.

Use:
- PreparedStatement  
- Proper resource handling  
- Transaction-safe operations  

#### b) JPA Implementation
Create TraineeJpaDAO implementing TraineeDAO.

Use:
- EntityManager  
- JPA annotations for entity mapping  

No JDBC code allowed in JPA implementation.

Business/service layer must not know whether JDBC or JPA is used.

### 3. Connection Factory (Loose Coupling)
Create a Connection Factory for JDBC:

- Read database configuration from a `.properties` file  
- Example properties:
  - jdbc.url  
  - jdbc.username  
  - jdbc.password  
  - jdbc.driver  

No hard-coded connection details in code.

For JPA:
- Use `persistence.xml`

DAO selection must be configurable (e.g., via property or factory).

### 4. Exception Handling (Mandatory)
Implement exception wrapping and rethrowing.

Rules:
- Catch low-level exceptions (SQLException, PersistenceException)  
- Wrap them in a custom checked exception (e.g., TraineeDataAccessException)  
- Do not expose database-specific exceptions to upper layers  

---

## Sample table structure and sample data

```sql
CREATE TABLE trainee (
    trainee_id INT AUTO_INCREMENT PRIMARY KEY,
    trainee_name VARCHAR(100) NOT NULL,
    branch VARCHAR(20) NOT NULL,
    percentage DECIMAL(5,2) CHECK (percentage BETWEEN 0 AND 100)
);

INSERT INTO trainee (trainee_name, branch, percentage) VALUES
('Raj Kumar', 'java', 82.50),
('Anita Sharma', 'oracle', 76.00),
('Vikram Singh', 'php', 69.75),
('Sneha Patil', 'dotnet', 88.20),
('Amit Verma', 'java', 91.00);
