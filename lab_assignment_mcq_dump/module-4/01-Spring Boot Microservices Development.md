# MODULE: Spring Boot Microservices Development

© 2026 Busycoder Academy. All rights reserved.

This assignment material is the intellectual property of Busycoder Academy and is provided strictly for classroom training conducted by the trainer.

This content is not intended for self-study distribution or public reuse.

---

# ASSIGNMENT 1 – Currency Exchange & Conversion – REST, Feign & Eureka

---

## Learning Objectives

By the end of this assignment, participants will:

- Build two microservices using Spring Boot  
- Implement REST communication between microservices  
- Use RestTemplate and then OpenFeign for inter-service calls  
- Register microservices with Eureka Naming Server and use service discovery  
- Understand ports & service naming conventions in microservice systems  

---

## System Components & Ports

| Service | Port |
|-------|------|
| Eureka Naming Server | 8761 |
| Currency Exchange Service | 8080 |
| Currency Conversion Service | 8100 |
| API Gateway | 8765 |
| Zipkin Server | 9411 |

*(In Assignment 1 you mainly focus on the first three.)*

---

## General Instructions

- Use Spring Initializr to create separate projects:
  - currency-exchange-service  
  - currency-conversion-service  
  - naming-server (Eureka) – minimal for now  

- Use Java 17, Maven, Spring Boot 3+ where possible.

- Common dependencies per service:
  - spring-boot-starter-web  
  - spring-boot-starter-actuator (optional)  

- For Feign & Eureka:
  - spring-cloud-starter-openfeign  
  - spring-cloud-starter-netflix-eureka-client  
  - spring-cloud-starter-netflix-eureka-server (for naming server)  

---

## Step 1 – Currency Exchange Service (8080)

**Goal:** Provide exchange rate between two currencies.

**Endpoint example:**
GET http://localhost:8080/currency-exchange/from/USD/to/INR

css
Copy code

**Response example:**
```json
{
  "id": 1001,
  "from": "USD",
  "to": "INR",
  "conversionMultiple": 82,
  "environment": "8080 instance"
}
Tasks:
Create ExchangeValue entity/model with fields:
id, from, to, conversionMultiple, environment.

Expose REST controller:

java
Copy code
@GetMapping("/currency-exchange/from/{from}/to/{to}")
public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                           @PathVariable String to) { ... }
Hardcode a few sample exchange values (later you can move to DB).

Step 2 – Currency Conversion Service (8100)
Goal: Use Currency Exchange Service to calculate converted amount.

Endpoint example:

pgsql
Copy code
GET http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
Example response:

json
Copy code
{
  "id": 1001,
  "from": "USD",
  "to": "INR",
  "quantity": 10,
  "conversionMultiple": 82,
  "totalCalculatedAmount": 820,
  "environment": "8100 instance"
}
Tasks:
Create CurrencyConversion model with fields from example.

Use RestTemplate (initially) to call currency-exchange-service endpoint and compute total amount.

Return combined result as JSON.

Step 3 – Replace RestTemplate with OpenFeign
Goal: Use declarative HTTP client instead of manual REST calls.

Tasks:
Enable Feign:

java
Copy code
@EnableFeignClients
@SpringBootApplication
public class CurrencyConversionServiceApplication { ... }
Create Feign client:

java
Copy code
@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                        @PathVariable String to);
}
Inject CurrencyExchangeProxy into the conversion service and use it instead of RestTemplate.

Step 4 – Introduce Eureka Naming Server (Service Discovery)
Tasks:
Create a naming-server project with:

dependency spring-cloud-starter-netflix-eureka-server

Enable Eureka:

java
Copy code
@EnableEurekaServer
@SpringBootApplication
public class NamingServerApplication { ... }
Configure application.properties (port 8761).

Register both microservices as Eureka clients using:

spring-cloud-starter-netflix-eureka-client

@EnableDiscoveryClient or rely on auto-config

Update Feign/RestTemplate calls to use service names instead of hardcoded localhost:port.

Learning Outcomes (Assignment 1)
Microservice-to-microservice communication

Difference between RestTemplate and Feign

Basic service discovery with Eureka

Avoiding hard-coded URLs for better scalability