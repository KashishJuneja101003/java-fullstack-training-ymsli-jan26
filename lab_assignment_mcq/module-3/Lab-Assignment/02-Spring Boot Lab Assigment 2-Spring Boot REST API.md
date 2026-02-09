# MODULE: Spring Boot (Modern Java Enterprise)

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 2 – Spring Boot REST API (CRUD + Layers + DTO)

---

## Learning Objectives

After completing this assignment, participants will be able to:

- Build a RESTful API using Spring Boot  
- Implement a layered architecture (Controller → Service → Repository)  
- Use DTOs for data transfer  
- Understand request/response mapping  
- Implement CRUD operations (Create, Read, Update, Delete)  
- Work with in-memory database H2 for testing  
- Understand how Spring Boot simplifies REST development  

---

## General Instructions

- Continue working inside your Spring Boot project or create a new one  
- Dependencies: Spring Web, Spring Boot DevTools, Lombok (optional), H2 Database  
- Application should run on port 8080 unless changed  
- Use constructor-based dependency injection  
- Follow proper package structure:

com.app
com.app.controller
com.app.service
com.app.repository
com.app.dto
com.app.entity


- Use meaningful class & method names  
- All endpoints must return clear JSON outputs  
- Validate input where necessary  
- Test APIs using Postman / curl / browser  

---

## Estimated Time

| Task | Time |
|-----|------|
| Entity + DTO creation | 20 min |
| Service implementation | 30–40 min |
| Controller + Endpoints | 30–40 min |
| Testing | 15–20 min |

---

## Evaluation Rubric

| Criteria | Weight |
|--------|--------|
| Correct implementation of CRUD endpoints | 40% |
| Clean layering + DI | 25% |
| JSON correctness | 15% |
| Code readability | 10% |
| Input validation | 10% |

---

## Scenario: Book Management REST API

We will build a simple REST API for managing books.

---

## Q1. Create Book Entity (in-memory only)

Create a class in `com.app.entity`:

```java
public class Book {

    private Integer id;
    private String title;
    private String author;
    private double price;

}
Requirements:
Add constructors, getters/setters

Use Lombok if preferred (@Data, @AllArgsConstructor, @NoArgsConstructor)

ID does not need auto-generation yet (since no JPA here)

Q2. Create DTO for Book Creation/Update
In com.app.dto:

public class BookDto {

    private String title;
    private String author;
    private double price;

}
Why DTO?
Prevent exposing internal entity structure

Support validation in next assignment

Q3. Create Book Repository (In-Memory)
Create a simulated repository using a Map:

@Repository
public class BookRepository {

    private Map<Integer, Book> store = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);

    public Book save(Book book) { ... }
    public Book findById(Integer id) { ... }
    public List<Book> findAll() { ... }
    public void deleteById(Integer id) { ... }

}
Notes:
Simulates database operations

Will be replaced with Spring Data JPA in Assignment 3

Q4. Create Book Service Layer
BookService.java:

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(BookDto dto) { ... }
    public Book updateBook(Integer id, BookDto dto) { ... }
    public Book getBook(Integer id) { ... }
    public List<Book> getAllBooks() { ... }
    public void deleteBook(Integer id) { ... }

}
Purpose of Service Layer:
Validations

Mapping DTO → Entity

Error handling

Business logic separation

Q5. Create REST Controller
Place in com.app.controller:

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book add(@RequestBody BookDto dto) { ... }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) { ... }

    @GetMapping
    public List<Book> getAll() { ... }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody BookDto dto) { ... }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { ... }

}
Q6. Test All Endpoints Using Postman
1️⃣ POST /api/books
Body:

{
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "price": 499.0
}
2️⃣ GET /api/books/1
3️⃣ GET /api/books
4️⃣ PUT /api/books/1
Update price or title.

5️⃣ DELETE /api/books/1
Expected Output Example:
{
  "id": 1,
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "price": 499.0
}
BONUS TASKS
Bonus 1
Add endpoint:

GET /api/books/search?author=Rajeev
Bonus 2
Add simple input validation:

Title not empty

Price > 0

Bonus 3
Convert the response into custom JSON format using Model classes.

Bonus 4
Add timestamp + response wrapper:

{
  "timestamp": "...",
  "data": { ... }
}
Reflection Questions
Why is layered architecture important in REST applications?

What advantages do DTOs provide over using Entities directly?

How does Spring Boot reduce boilerplate in creating REST APIs?

What were the easiest and most challenging parts of this assignment?

How will Spring Data JPA improve your repository implementation?