package application.controller;


import application.DTO.CustomerDTO;
import application.model.CommonSV.ResponseDetail;
import application.model.impl.CustomerImpl;
import application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    private static final Logger logger = Logger.getLogger(AccountController.class.getName());
    @Autowired
    private final CustomerService customerService;

    /**
     * Instantiates a new Customer controller.
     *
     * @param customerService the customer service
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Gets customer.
     *
     * @param accountId the account id
     * @return the customer
     */
    @GetMapping("/accountId/{accountId}")
    public ResponseEntity<String> getCustomer(@PathVariable("accountId") @NonNull Long accountId) {
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();
        try {
            CustomerDTO customerDTO = customerService.findCustomer(accountId);
            responseDetail.setMessage(customerDTO.toString());
        } catch (NoSuchElementException e) {
            responseDetail.setMessage(e.toString());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was a problem finding customer with accountId %s", accountId));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }


    /**
     * Gets customer.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param address   the address
     * @return the customer
     */
    @PutMapping("/firstnames/{firstname}/lastnames/{lastname}/addresses/{address}")
    public ResponseEntity<String> getCustomer(@PathVariable("firstname") @NonNull String firstname,
                                              @PathVariable("lastname") @NonNull String lastname,
                                              @PathVariable("address") @NonNull String address) {
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();
        CustomerImpl customer = new CustomerImpl(firstname, lastname, address);

        try {
            customerService.creatCustomer(customer);
            customerService.setAccountCustomerId(customer);
            responseDetail.setMessage(customer.getiD().toString());
        } catch (Exception e) {
            responseDetail.setMessage(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("Something went wrong with finding customer %s with associated account",
                    customer.getFirstName()));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }

    /**
     * Update firstname response entity.
     *
     * @param accountId the account id
     * @param firstname the firstname
     * @return the response entity
     */
    @PutMapping("/accountId/{accountId}/firstnames/{firstname}")
    public ResponseEntity<String> updateFirstname(@PathVariable("accountId") @NonNull Long accountId,
                                                  @PathVariable("firstname") @NonNull String firstname) {

        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();

        try {
            customerService.updateCustomerFirstName(firstname, accountId);
        } catch (Exception e) {
            responseDetail.setMessage(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("Something went wrong with updating customer firstname %s for account %d",
                    firstname, accountId));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }

    /**
     * Update lastname response entity.
     *
     * @param accountId the account id
     * @param lastname  the lastname
     * @return the response entity
     */
    @PutMapping("/accountId/{accountId}/lastnames/{lastname}")
    public ResponseEntity<String> updateLastname(@PathVariable("accountId") @NonNull Long accountId,
                                                 @PathVariable("lastname") @NonNull String lastname) {

        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();

        try {
            customerService.updateCustomerLastName(lastname, accountId);
        } catch (Exception e) {
            responseDetail.setMessage(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("Something went wrong with updating customer lastname %s for account %d",
                    lastname, accountId));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }

    /**
     * Update address response entity.
     *
     * @param accountId the account id
     * @param address   the address
     * @return the response entity
     */
    @PutMapping("/accountId/{accountId}/addresses/{address}")
    public ResponseEntity<String> updateAddress(@PathVariable("accountId") @NonNull Long accountId,
                                                @PathVariable("address") @NonNull String address) {

        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();

        try {
            customerService.updateCustomerAddress(address, accountId);
        } catch (Exception e) {
            responseDetail.setMessage(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("Something went wrong with updating customer address %s for account %d",
                    address, accountId));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }
}
