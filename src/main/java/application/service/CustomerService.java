package application.service;

import application.DTO.CustomerDTO;
import application.model.impl.CustomerImpl;
import application.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {
    private static final Logger logger = Logger.getLogger(CustomerService.class.getName());
    private final CustomerRepository customerRepository;

    /**
     * Instantiates a new Customer service.
     *
     * @param customerRepository the customer repository
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Find customer customer dto.
     *
     * @param accountId the account id
     * @return the customer dto
     */
    public CustomerDTO findCustomer(Long accountId) {
        Optional<CustomerDTO> optionalCustomerDTO = customerRepository.findCustomerByAccountId(accountId);

        if (!optionalCustomerDTO.isPresent()) {
            throw new NoSuchElementException();
        }
        System.out.println(optionalCustomerDTO.get().getAddress());
        return optionalCustomerDTO.get();
    }

    /**
     * Creat customer.
     *
     * @param customer the customer
     */
    public void creatCustomer(CustomerImpl customer) {
        customerRepository.save(customer);
    }

    /**
     * Sets account customer id.
     *
     * @param customer the customer
     */
    @Transactional
    @Modifying
    public void setAccountCustomerId(CustomerImpl customer) {
        customerRepository.setCustomerId(customer.getiD(), AccountService.getId());
    }

    /**
     * Update customer first name.
     *
     * @param firstname the firstname
     * @param accountId the account id
     */
    @Transactional
    @Modifying
    public void updateCustomerFirstName(String firstname, Long accountId) {
        customerRepository.updateFirstname(firstname, accountId);
    }

    /**
     * Update customer last name.
     *
     * @param lastname  the lastname
     * @param accountId the account id
     */
    @Transactional
    @Modifying
    public void updateCustomerLastName(String lastname, Long accountId) {
        customerRepository.updateLastname(lastname, accountId);
    }

    /**
     * Update customer address.
     *
     * @param address   the address
     * @param accountId the account id
     */
    @Transactional
    @Modifying
    public void updateCustomerAddress(String address, Long accountId) {
        customerRepository.updateAddress(address, accountId);
    }
}
