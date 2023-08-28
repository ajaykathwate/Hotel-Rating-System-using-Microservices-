# Hotel Rating System using SpringBoot Microservices

This project is a Hotel Rating System implemented using Spring Boot and microservices architecture. 
It consists of three main services: USER-SERVICE, HOTEL-SERVICE and RATING-SERVICE. 
The services communicate with each other and are registered with an Eureka Server. The API Gateway handles external requests and utilizes the Feign client for internal communication between services.

## Technologies Used

- Spring Boot
- Spring Cloud (Eureka Server, API Gateway)
- Feign Client  
- MySQL
- MongoDB
- Maven (for dependency management)
- Java 8

## Project Structure

The project is organized into the following modules:

1. `USER-SERVICE`: Manages user-related functionality.
2. `HOTEL-SERVICE`: Handles hotel information and details.
3. `RATING-SERVICE`: Deals with user ratings and reviews.

## Usage

- The Eureka Server dashboard can be accessed at: `http://localhost:8761`
- The API Gateway handles external requests at: `http://127.0.0.1:8085`
- Example endpoints for services:
  - user-service: `http://localhost:8081/api/users`
  - hotel-service: `http://localhost:8082/api/hotels`
  - rating-service: `http://localhost:8083/api/ratings`

## Contributing

Contributions are welcome! If you find any issues or want to add enhancements, feel free to open a pull request.
