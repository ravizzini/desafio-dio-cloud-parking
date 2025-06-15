package one.digitalinnovation.parking.controller.mapper;

import one.digitalinnovation.parking.controller.dto.CustomerCreateDTO;
import one.digitalinnovation.parking.controller.dto.CustomerDTO;
import one.digitalinnovation.parking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parking.controller.dto.ParkingDTO;
import one.digitalinnovation.parking.model.Customer;
import one.digitalinnovation.parking.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public CustomerDTO toCustomerDTO(Customer customer) {
        return MODEL_MAPPER.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> toCustomerDTOList(List<Customer> customerList) {
        return customerList.stream().map(this::toCustomerDTO).collect(Collectors.toList());
    }

    public Customer toCustomer(CustomerDTO dto) {
        return MODEL_MAPPER.map(dto, Customer.class);
    }

    public Customer toCustomerCreate(CustomerCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Customer.class);
    }




}
