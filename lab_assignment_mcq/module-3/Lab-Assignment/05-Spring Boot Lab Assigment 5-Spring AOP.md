# MODULE: Spring Boot – Modern Java Enterprise

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

## ASSIGNMENT 5 – Spring AOP  
(Aspect-Oriented Programming) with Spring Boot

---

## Learning Objectives

After completing this assignment, participants will be able to:

- Understand the core motivation of AOP  
- Implement cross-cutting concerns (logging, monitoring, validation)  
- Use Spring Boot + AOP Starter  
- Create custom aspects using:
  - `@Aspect`
  - `@Before`
  - `@After`
  - `@AfterReturning`
  - `@AfterThrowing`
  - `@Around`
- Apply pointcut expressions (`execution`, `within`, `args`, etc.)  
- Integrate AOP with existing service methods (Book application)  
- Use AOP for transparent logging & performance monitoring  

---

## General Instructions

- Use the same Spring Boot project from earlier assignments  
- Add dependency (if missing):

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
Create separate package for AOP:

com.app.aop
Apply AOP only at the service layer, never on controllers

The aspect must not contain business logic — only cross-cutting code

Use Log4j2 or LoggerFactory for logging inside aspects

Estimated Time
Task	Time
AOP basics & configuration	20–25 min
Create custom aspects	30–45 min
Add logging and monitoring	20–30 min
Testing via Postman	15 min
Evaluation Rubric
Criteria	Weight
Correct AOP annotations	30%
Pointcut accuracy	25%
Logging/metering implementation	20%
Integration with BookService	15%
Code quality	10%
Scenario: Improve BookService using AOP
We will add:

Logging before and after service methods

Execution time measurement

Exception logging

Return-value logging

This will show how AOP transparently enhances the service layer.

Q1. Enable AOP & Create Logging Aspect
In com.app.aop.LoggingAspect:

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger =
            LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* com.app.service.BookService.*(..))")
    public void logBefore(JoinPoint jp) {
        logger.info("Before method: " + jp.getSignature());
    }

    @After("execution(* com.app.service.BookService.*(..))")
    public void logAfter(JoinPoint jp) {
        logger.info("After method: " + jp.getSignature());
    }
}
Expected:
Every call to BookService should log BEFORE & AFTER messages.

Q2. Add @AfterReturning Advice
@AfterReturning(
    value = "execution(* com.app.service.BookService.getBook(..))",
    returning = "result")
public void logReturn(Object result) {
    logger.info("Method returned: " + result);
}
Q3. Add @AfterThrowing Advice
@AfterThrowing(
    value = "execution(* com.app.service.BookService.*(..))",
    throwing = "ex")
public void logException(Exception ex) {
    logger.error("Exception thrown: " + ex.getMessage());
}
Use Case:
If a book is not found and BookNotFoundException is thrown.

Q4. Add @Around Advice for Performance Monitoring
@Around("execution(* com.app.service.BookService.*(..))")
public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {

    long start = System.currentTimeMillis();

    Object result = pjp.proceed();

    long end = System.currentTimeMillis();

    logger.info(
        "Execution Time of " + pjp.getSignature() +
        ": " + (end - start) + "ms"
    );

    return result;
}
Expected:
Each method call should print execution time.

Q5. Custom Pointcut Expressions
Create named pointcuts.

Example:

@Pointcut("execution(* com.app.service.*.*(..))")
public void serviceMethods() {}
Then use:

@Before("serviceMethods()")
public void logServiceAccess() {
    ...
}
Q6. Test AOP Through REST Endpoints
Use endpoints from previous assignments:

POST   /api/books
GET    /api/books/{id}
PUT    /api/books/{id}
DELETE /api/books/{id}
Trigger:

Logs before/after

Execution time

Exception logging

Return value logging

Use Postman to execute all operations.

BONUS TASKS
Bonus 1 — Pointcut for Specific Parameter Types
Log calls only when inserting books:

@Before("args(com.app.dto.BookDto,..)")
Bonus 2 — Create ValidationAspect
Check:

price > 0

title not empty

Bonus 3 — Create SecurityAspect (Mock)
Check if header X-USER exists.

Bonus 4 — Create Aspect Order
Demonstrate:

@Order(1)
@Order(2)
Reflection Questions
Why is AOP preferred over manual logging in every method?

Explain the concept of cross-cutting concerns in enterprise systems.

Which AOP annotation did you find most powerful and why?

How does AOP help maintain clean code?

Would you use AOP for business logic? Why or why not?

