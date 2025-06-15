package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.model.Customer;
import one.digitalinnovation.parking.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Implement methods for customer management, such as create, update, delete, and find customers
    // Example method to find all customers
    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Example method to find a customer by ID
    @Transactional(readOnly = true)
    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    // Example method to create a new customer
    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    // Example method to update an existing customer
    @Transactional
    public Customer update(String id, Customer customer) {
        Customer existingCustomer = findById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        // Update other fields as necessary
        return customerRepository.save(existingCustomer);
    }

    // Example method to delete a customer
    @Transactional
    public void delete(String id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }

    // Additional methods for customer management can be added here
}
