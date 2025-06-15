package one.digitalinnovation.parking.controller;

import one.digitalinnovation.parking.controller.dto.CustomerCreateDTO;
import one.digitalinnovation.parking.controller.dto.CustomerDTO;
import one.digitalinnovation.parking.controller.mapper.CustomerMapper;
import one.digitalinnovation.parking.model.Customer;
import one.digitalinnovation.parking.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    // Define methods for handling customer-related requests here
    // For example, you might have methods like:
     @GetMapping
     public ResponseEntity<List<CustomerDTO>> findAll() {
         List<Customer> customers = customerService.findAll();
         List<CustomerDTO> result = customerMapper.toCustomerDTOList(customers);
         return ResponseEntity.ok(result);
     }

    // Add more methods as needed, such as findById, create, update, delete, etc.
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        CustomerDTO result = customerMapper.toCustomerDTO(customer);
        return ResponseEntity.ok(result);
    }

    // Additional methods for creating, updating, and deleting customers can be added here
     @PostMapping
     public ResponseEntity<CustomerDTO> create(@RequestBody CustomerCreateDTO dto) {
         var customerCreate = customerMapper.toCustomerCreate(dto);
         var parking = customerService.create(customerCreate);
         var result = customerMapper.toCustomerDTO(parking);
         return ResponseEntity.status(HttpStatus.CREATED).body(result);
     }

     @PutMapping("/{id}")
     public ResponseEntity<CustomerDTO> update(@PathVariable String id, @RequestBody CustomerCreateDTO customerCreateDTO) {
         Customer customerUpdate = customerMapper.toCustomerCreate(customerCreateDTO);
         Customer customer = customerService.update(id, customerUpdate);
         return ResponseEntity.ok(customerMapper.toCustomerDTO(customer));
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable String id) {
         customerService.delete(id);
         return ResponseEntity.noContent().build();
     }
     
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        CustomerDTO result = customerMapper.toCustomerDTO(customer);
        return ResponseEntity.ok(result);
    }
}
