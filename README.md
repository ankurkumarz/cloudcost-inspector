# cloudcost-inspector
To inspect cloud cost and advise accordingly

## Features
- Architecture Layer: Controller -> Service -> Repository
- REST API (OpenAPI Specification)
- HTTP Standard - API Best Practices for Error Codes
- Health Metrics using Actuator
- Enable Transaction Management
- JPA (SQL) - DONE
- JPA (NOSQL - MongoDB)
- Exception Handling
- Global Exception Handler
- Event-driven Service
- Docker Image - DONE
- Enable Native Image
- Java Best Practices - Generics, Streams
- Lombok (Getter/Setter) Code Generation - DONE
- Spring Boot Best Practices
- Logging using SL4J Lombok - DONE
- Auditing JPA - DONE
- Prometheus Instrumentation - DONE
- Configured GitHub Action to build Docker Image - DONE

## REST Endpoints
- http://localhost:8080/compute/virtualmachines
- http://localhost:8080/h2-console
- http://localhost:8080/api-docs/
- http://localhost:8080/api-docs.yaml
change path using springdoc.api-docs.path=/api-docs
- http://localhost:8080/actuator/prometheus

## References:
- https://spring.io/guides/tutorials/rest/
- https://github.com/spring-guides/tut-rest
- https://medium.com/@berkaybasoz/spring-boot-h2-database-setup-6996a1c18cc
- https://github.com/eugenp/tutorials/blob/master/persistence-modules/spring-jpa-2/
- https://www.baeldung.com/spring-rest-openapi-documentation
- https://www.baeldung.com/intro-to-project-lombok
- https://www.baeldung.com/database-auditing-jpa
- https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html
- https://www.baeldung.com/spring-boot-actuators
- https://www.baeldung.com/spring-liveness-readiness-probes
- https://spring.io/blog/2020/03/25/liveness-and-readiness-probes-with-spring-boot
- [Prometheus Instrumentation](https://www.baeldung.com/spring-boot-self-hosted-monitoring)