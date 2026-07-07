# Week 4 Microservices Exercises

This folder contains Spring Boot 3 solutions for the Week 4 microservices exercises.

## Included modules

- `account` and `loan`: bank microservices with `/accounts/{number}` and `/loans/{number}`.
- `eureka-discovery-server`: service registry on port `8761`.
- `greet-service`: sample service with `/greet`.
- `api-gateway`: Spring Cloud Gateway on port `9090` with discovery routing, path rewriting, circuit-breaker fallbacks, and request logging.
- `customer-service` and `billing-service`: services used by the gateway routing exercise.
- `user-service` and `order-service`: REST services with JPA persistence; `order-service` calls `user-service` using OpenFeign.
- `product-service`, `inventory-service`, and `config-server`: Eureka discovery plus centralized config.
- `payment-service`: Resilience4j circuit breaker and fallback logging.

## Useful commands

```bash
mvn -f deepskilling/week_4/pom.xml clean package
mvn -f deepskilling/week_4/eureka-discovery-server/pom.xml spring-boot:run
mvn -f deepskilling/week_4/account/pom.xml spring-boot:run
mvn -f deepskilling/week_4/loan/pom.xml spring-boot:run
mvn -f deepskilling/week_4/greet-service/pom.xml spring-boot:run
mvn -f deepskilling/week_4/api-gateway/pom.xml spring-boot:run
```

After starting Eureka, a service, and the gateway, try:

- `http://localhost:8080/accounts/00987987973432`
- `http://localhost:8081/loans/H00987987972342`
- `http://localhost:9090/greet-service/greet`
- `http://localhost:9090/account-service/accounts/00987987973432`
- `http://localhost:9090/loan-service/loans/H00987987972342`
