
Overview: 
This project is a simple Spring Boot application that provides RESTful endpoints for managing customers. It allows you to perform CRUD (Create, Read, Update, Delete) operations on a customer entity stored in a database.

Prerequisites: 
Before running this application, make sure you have the following installed:

Java Development Kit (JDK) version 8 or higher
Maven

Getting Started: 
Clone this repository to your local machine.
Open the project in your preferred IDE (Integrated Development Environment).
Build the project using Maven: mvn clean install.
Run the application using your IDE or via command line: mvn spring-boot:run.

Usage: 
Once the application is running, you can access the following endpoints:

1. GET /api/v1/customers
Description: Retrieves a list of all customers stored in the database.
Response: Returns a JSON array containing customer objects.

3. POST /api/v1/customers
Description: Adds a new customer to the database.
Request Body: Requires a JSON object representing the new customer's details (name, email, age).
Response: No content. The new customer is added to the database.

4. DELETE /api/v1/customers/{customerId}
Description: Deletes a customer from the database based on the provided customer ID.
Path Parameter: {customerId} - The ID of the customer to be deleted.
Response: No content. The specified customer is deleted from the database.

5. PUT /api/v1/customers/{customerId}
Description: Updates an existing customer's information in the database.
Path Parameter: {customerId} - The ID of the customer to be updated.
Request Body: Requires a JSON object representing the updated customer's details (name, email, age).
Response: No content. The specified customer's information is updated in the database.

6. GET /api/v1/customers/greet
Description: Generates a greeting response with some hardcoded data.
Response: Returns a JSON object containing a greeting message, a list of favorite programming languages, and a person object.

Technologies Used: 
Spring Boot
Spring Data JPA
Maven
Java Persistence API (JPA)
H2 Database (in-memory database for development)

Contributors: 
Andrew Palmer (@andrewsproject)
