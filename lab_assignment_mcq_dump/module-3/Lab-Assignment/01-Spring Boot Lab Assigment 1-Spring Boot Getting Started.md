# MODULE: Spring Boot (Modern Java Enterprise)

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 1 – Spring Boot Fundamentals & Dependency Injection

(Refer to attached program file for original scenario)

Assignment 5- java collection-a…

---

## Learning Objectives

After completing this assignment, participants will be able to:

- Create a Spring Boot application from scratch  
- Understand Spring Boot project structure (Starter, auto-config, application.properties)  
- Implement Constructor-based Dependency Injection  
- Use @Component, @Service, @Repository annotations  
- Create simple REST endpoints using Spring Web  
- Build layered architecture in Spring Boot (Controller → Service → Repository)  
- Run application using embedded Tomcat  

---

## General Instructions

- Use Spring Initializr (start.spring.io)  
- Java 17  
- Maven Project  
- Dependencies: Web, DevTools, Lombok (optional)  
- Do not write XML configuration. Boot handles DI automatically.  
- Always use @Autowired constructor injection (not field injection).  
- Save your project under a folder named `assignment1-springboot-basics`.  
- Demonstrate clear console & browser output.  

---

## Estimated Time

| Task | Time |
|-----|------|
| Setup & project creation | 10 min |
| Components & DI | 20–30 min |
| Service + Controller | 30–40 min |

---

## Evaluation Rubric

| Criteria | Weight |
|--------|--------|
| Clean project structure | 25% |
| Correct DI usage | 25% |
| Working REST endpoint | 30% |
| Code clarity | 20% |

---

## Starter Scenario

Build a simple Welcome Service Application using Spring Boot.

---

## Q1. Create a Spring Boot Project

### Requirements:

- Group: `com.app`  
- Artifact: `welcome-app`  
- Packages:  

com.app
com.app.controller
com.app.service


- Add a main class annotated with `@SpringBootApplication`

---

## Q2. Create a Service Layer with Dependency Injection

**File:** `WelcomeService.java`

Annotate with:

```java
@Service
public class WelcomeService {

    public String greet(String name) {
        return "Welcome " + name + " to Spring Boot!";
    }

}
Objectives:
Demonstrate DI

No new WelcomeService() anywhere

Boot will inject automatically

Q3. Create a REST Controller
File: WelcomeController.java

Annotate with:

@RestController
@RequestMapping("/api")
public class WelcomeController {

    private final WelcomeService welcomeService;

    public WelcomeController(WelcomeService service) {
        this.welcomeService = service;
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return welcomeService.greet(name);
    }
}
Expected Output:
Hitting:

http://localhost:8080/api/welcome/Rajeev
Should show:

Welcome Rajeev to Spring Boot!
Q4. Add Additional Component
Create any of the following:

Utility class annotated with @Component

Another service depending on a utility

A formatter class

A validator class

Goal: Show DI between multiple Spring-managed beans.

BONUS TASKS (Optional)
Bonus 1
Add a /health endpoint returning JSON:

{
  "status": "UP",
  "application": "welcome-app"
}
Bonus 2
Add custom property in application.properties:

app.author=Rajeev Gupta
Inject using @Value("${app.author}").

Bonus 3
Create a service interface and two implementations; inject using @Qualifier.

Reflection Questions
Why is constructor injection preferred over field injection in modern Spring?

What does Spring Boot auto-configuration do behind the scenes?

How do @Component, @Service, and @Repository differ?

Why do we no longer use XML with Spring Boot?

How did this assignment help you understand IoC (Inversion of Control)?