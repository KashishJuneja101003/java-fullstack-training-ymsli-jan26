# MODULE: Spring Boot – Modern Java Enterprise

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 3 – Spring Data JPA  
(CRUD + Derived Queries + Custom Queries)

---

## Learning Objectives

After completing this assignment, participants will be able to:

- Integrate Spring Data JPA with Spring Boot  
- Configure H2 / MySQL / PostgreSQL as a data source  
- Create JPA Entities with annotations  
- Use `JpaRepository` for CRUD operations  
- Implement derived query methods (`findBy*`, `existsBy*`, `deleteBy*`)  
- Write JPQL and Native SQL queries using `@Query`  
- Understand how Spring Boot reduces 90% of ORM boilerplate  
- Validate the repository layer through REST endpoints  

---

## General Instructions

- Continue using the same project from Assignment 2  
  **OR** create a new one with dependencies:
  - Spring Web  
  - Spring Data JPA  
  - H2 Database  
  - (Optional) Lombok  

- Use Java 17  
- Use proper packaging:

com.app
com.app.entity
com.app.repository
com.app.service
com.app.controller


- All JPA annotations must be placed correctly  
  (`@Entity`, `@Id`, `@GeneratedValue`)  
- Ensure your API returns JSON  
- Test all queries using Postman or browser  

---

## Estimated Time

| Task | Time |
|----|----|
| JPA Entity + Repository Setup | 25–35 min |
| CRUD + Derived Queries | 30–45 min |
| JPQL + Native Queries | 30–45 min |
| REST Integration | 20 min |

---

## Evaluation Rubric

| Criteria | Weight |
|--------|--------|
| Correct JPA entity design | 20% |
| Repository implementation | 30% |
| Derived + custom queries | 25% |
| REST working output | 15% |
| Code clarity & docs | 10% |

---

## Sample Domain: BOOK STORE (Extended Version)

We continue the Book Store application from Assignment 2, but now use a real database.

---

## Q1. Configure Database & JPA

Use one of these:

### Option A – H2 In-Memory (Recommended for learners)

`application.properties`:

spring.datasource.url=jdbc:h2:mem:booksdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true


### Option B – MySQL

(Optional depending on environment)

---

## Q2. Create JPA Entity: Book

`com.app.entity.Book`

```java
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private Double price;
    private String isbn;
    private String category;
}
Requirements:
Add constructors, getters, setters (or Lombok)

Add @Column if column names differ

Q3. Create Repository Interface
com.app.repository.BookRepository:

public interface BookRepository extends JpaRepository<Book, Integer> {
}
This gives CRUD operations for free:

save()

findById()

findAll()

deleteById()

Q4. Add Derived Query Methods
Extend the repository:

List<Book> findByAuthor(String author);
List<Book> findByPriceLessThan(Double price);
List<Book> findByCategory(String category);
boolean existsByIsbn(String isbn);
void deleteByTitle(String title);
Test using REST endpoints (created in Q7).

Q5. Add Custom JPQL Queries
@Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword%")
List<Book> searchByTitle(@Param("keyword") String keyword);

@Query("SELECT b FROM Book b ORDER BY b.price DESC")
List<Book> sortByPriceDesc();
Q6. Add Native SQL Query
@Query(
  value = "SELECT * FROM books WHERE price BETWEEN ?1 AND ?2",
  nativeQuery = true
)
List<Book> findByPriceRange(double min, double max);
Q7. REST Integration (Controller + Service)
Reuse your BookController from Assignment 2, but update.

Add endpoints:
GET /api/books/author/{author}
GET /api/books/category/{category}
GET /api/books/price/less/{price}
GET /api/books/search/{keyword}
GET /api/books/price-range?min=100&max=500
Use your BookService to call repository methods.

Required Test Cases (Use Postman)
Insert 5 sample books (POST)

Fetch all books (GET)

Fetch by ID (GET)

Delete a book (DELETE)

Search by author

Search by price < X

Search by keyword in title

Native query test (price range)

BONUS TASKS
Bonus 1 — Pagination & Sorting
GET /api/books?page=0&size=5&sort=price,desc
Bonus 2 — Add One-to-Many Relationship
Example: Book → Reviews

Bonus 3 — Make category an Enum
Use:

@Enumerated(EnumType.STRING)
Bonus 4 — Add custom exception handler
Create GlobalExceptionHandler.

Reflection Questions
Why does Spring Data JPA eliminate most boilerplate code?

What is the difference between JPQL and Native SQL?

When should you use derived queries vs custom queries?

How is JPA better than manually writing JDBC code?

How does pagination help in real-world APIs?

