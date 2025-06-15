package one.digitalinnovation.parking.repository;

import one.digitalinnovation.parking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    // Additional query methods can be defined here if needed
}
