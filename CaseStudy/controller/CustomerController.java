package CaseStudy.CaseStudy.controller;

import CaseStudy.CaseStudy.entity.Customer;
import CaseStudy.CaseStudy.repository.CustomerRepository;
import CaseStudy.CaseStudy.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> allCustomer = customerService.getCustomers();
        return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);

    }
}
