package CaseStudy.CaseStudy.service;


import CaseStudy.CaseStudy.entity.Customer;
import CaseStudy.CaseStudy.exception.CustomerNotFoundException;
import CaseStudy.CaseStudy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customersService")
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long theId){
        return customerRepository.findById(theId)
                .orElseThrow(() ->
                 new CustomerNotFoundException("Aranan Müşteri Bulunamadı"));
    }

}
