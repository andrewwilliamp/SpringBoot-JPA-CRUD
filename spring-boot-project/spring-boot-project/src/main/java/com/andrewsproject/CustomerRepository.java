package com.andrewsproject;

import org.springframework.data.jpa.repository.JpaRepository;

// Allows us to connect to JPA Customer database & do CRUD operations
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
