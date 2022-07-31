package application.service;

import application.model.impl.CustomerImpl;
import application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Here you will insert a customer if and only if there account does not exists
    public void insertNewCustomer(CustomerImpl customer) {

    }

}
