package com.andrewsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class Controller {


    private final CustomerRepository customerRepository;

    public Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello",
                List.of("Java", "Python", "Javascript"),
                new Person("Andrew", 24, 30_000));
        return response;
    }

    record Person (String name, int age, double savings) {

    }
    record GreetResponse(String greet,
                         List<String> favProgrammingLanguages,
                         Person person
    ) {}
    // get request
    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {}

    // post request
    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    // delete request
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable ("customerId") Integer id, @RequestBody NewCustomerRequest request) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        // Update the customer's information
        Customer customer = optionalCustomer.get();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        // Save the updated customer to the database
        customerRepository.save(customer);

    }
}
