# MODULE: Spring Boot – Modern Java Enterprise

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 4 – Spring Boot JDBC  
(JdbcTemplate + NamedParameterJdbcTemplate)

---

## Learning Objectives

After completing this assignment, participants will be able to:

- Configure JDBC in Spring Boot with auto-configuration  
- Understand differences between classic JDBC vs Spring JDBC  
- Use `JdbcTemplate` to reduce boilerplate  
- Use `NamedParameterJdbcTemplate` for readable queries  
- Create DAO layer using Spring Boot JDBC  
- Perform CRUD operations using SQL queries  
- Map rows using `RowMapper`  
- Integrate JDBC repository into the existing Book Store REST API  

This assignment shows how much Spring simplifies JDBC, making it a perfect stepping stone before JPA.

---

## General Instructions

- Continue with the same project from Assignment 3  
- Add dependency in `pom.xml` (if not already):
  - H2 / MySQL Driver  
  - Spring JDBC (if not included)  

- Use proper package structure:

com.app.jdbc
com.app.jdbc.dao
com.app.jdbc.rowmapper


- Use constructor injection (no `@Autowired` fields)  
- DO NOT use `ResultSet` / `PreparedStatement` directly — Spring handles it  
- Validate parameters before executing SQL  
- Test all methods through REST endpoints  

---

## Estimated Time

| Task | Time |
|----|----|
| JDBC setup | 15–20 min |
| DAO implementation | 45–60 min |
| REST wiring | 20–30 min |
| Testing | 15 min |

---

## Evaluation Rubric

| Criteria | Weight |
|--------|--------|
| Clean DAO implementation | 30% |
| Correct SQL CRUD operations | 30% |
| RowMapper & Named Parameters | 20% |
| REST test outputs | 10% |
| Code clarity | 10% |

---

## Database Configuration

Use H2 (recommended) or MySQL.

### H2 Example

`application.properties`:

spring.datasource.url=jdbc:h2:mem:booksdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=none
spring.h2.console.enabled=true


### Create Table Manually  
(JDBC does NOT auto-create)

```sql
CREATE TABLE books_jdbc (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200),
    author VARCHAR(100),
    price DOUBLE,
    isbn VARCHAR(50)
);
Q1. Create Book Entity (Reuse From Assignment 3)
Re-use the same Book class but keep a separate table for JDBC.

Q2. Create a RowMapper
In com.app.jdbc.rowmapper:

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book b = new Book();
        b.setId(rs.getInt("id"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getDouble("price"));
        b.setIsbn(rs.getString("isbn"));

        return b;
    }
}
Q3. Create JDBC DAO Using JdbcTemplate
BookJdbcDao.java:

@Repository
public class BookJdbcDao {

    private final JdbcTemplate jdbc;

    public BookJdbcDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public int save(Book b) { ... }

    public Book findById(int id) { ... }

    public List<Book> findAll() { ... }

    public int update(Book b) { ... }

    public int delete(int id) { ... }
}
Required SQL:
INSERT INTO books_jdbc(title, author, price, isbn) VALUES (?, ?, ?, ?)

SELECT * FROM books_jdbc WHERE id = ?

SELECT * FROM books_jdbc

UPDATE books_jdbc SET title=?, author=?, price=?, isbn=? WHERE id=?

DELETE FROM books_jdbc WHERE id=?
Q4. Create DAO With NamedParameterJdbcTemplate
BookNamedDao.java:

@Repository
public class BookNamedDao {

    private final NamedParameterJdbcTemplate named;

    public BookNamedDao(NamedParameterJdbcTemplate named) {
        this.named = named;
    }

    public List<Book> findByAuthor(String author) { ... }

    public List<Book> findByPriceRange(double min, double max) { ... }
}
SQL Examples:
SELECT * FROM books_jdbc WHERE author = :author

SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max
Q5. Integrate JDBC DAO Into REST API
Create a new controller:

BookJdbcController.java

Endpoints:
GET    /api/jdbc/books
GET    /api/jdbc/books/{id}
POST   /api/jdbc/books
PUT    /api/jdbc/books/{id}
DELETE /api/jdbc/books/{id}
Named query endpoints:
GET /api/jdbc/books/author/{author}
GET /api/jdbc/books/price-range?min=100&max=500
Q6. Test All JDBC Endpoints in Postman
Your tests must include:

Insert 3 books

Fetch all books

Update a book

Delete a book

Search by author

Search by price range

BONUS TASKS
Bonus 1 – Batch Insert
Insert 10 books using:

jdbc.batchUpdate(...)
Bonus 2 – Transaction Management
Wrap multiple updates inside:

@Transactional
Bonus 3 – Custom Exception Handling
Create:

BookNotFoundException
Bonus 4 – Compare JDBC DAO vs JPA Repository
Write differences in:

Lines of code

Complexity

Maintainability

Reflection Questions
How does JdbcTemplate reduce boilerplate vs classic JDBC?

What advantages does NamedParameterJdbcTemplate provide?

Why do we still learn JDBC before JPA in Spring Boot?

How does Spring Boot auto-configure JDBC?

Which layer benefits the most from JdbcTemplate’s simplicity?