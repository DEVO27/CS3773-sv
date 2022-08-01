package application.controller;

import application.DTO.AccountDTO;
import application.model.CommonSV.ResponseDetail;
import application.model.impl.AccountImpl;
import application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * The type Account controller.
 */
@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    private static final Logger logger = Logger.getLogger(AccountController.class.getName());
    @Autowired
    private final AccountService accountService;

    /**
     * Instantiates a new Account controller.
     *
     * @param accountService the account service
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Gets account.
     *
     * @param email    the email
     * @param password the password
     * @return the account
     */
    @GetMapping("/users/{email}/passwords/{password}")
    public ResponseEntity<String> getAccount(@PathVariable("email") @NonNull String email,
                                             @PathVariable("password") @NonNull String password) {
        HttpStatus httpStatus = HttpStatus.OK;
        ResponseDetail responseDetail = new ResponseDetail();
        try {
            AccountDTO accountDTO = accountService.findAccount(new AccountImpl(email, password));
            responseDetail.setMessage(accountDTO.toString());
        } catch (NoSuchElementException e) {
            responseDetail.setMessage(e.toString());
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was a problem finding email %s with password %s", email, password));
        }

        return new ResponseEntity<>(responseDetail.getMessage(), httpStatus);
    }

    /**
     * Register new account response entity.
     *
     * @param email      the email
     * @param password   the password
     * @param creditCard the credit card
     * @return the response entity
     */
    @PostMapping("/users/{email}/passwords/{password}/cards/{creditcard}")
    public ResponseEntity<String> registerNewAccount(@PathVariable("email") @NonNull String email,
                                                     @PathVariable("password") @NonNull String password,
                                                     @PathVariable("creditcard") @NonNull String creditCard) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";

        try {
            accountService.registerAccount(new AccountImpl(email, password, creditCard));
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was issue as account already exists for email %s", email));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    }

    /**
     * Update email response entity.
     *
     * @param accountId the account id
     * @param email     the email
     * @return the response entity
     */
    @PutMapping("/accounts/{accountId}/users/{email}")
    public ResponseEntity<String> updateEmail(@PathVariable("accountId") @NonNull Long accountId,
                                              @PathVariable("email") @NonNull String email) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        try {
            accountService.updateAccountEmail(email, accountId);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was issue as setting email for account %d", accountId));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    }

    /**
     * Update password response entity.
     *
     * @param accountId the account id
     * @param password  the password
     * @return the response entity
     */
    @PutMapping("/accounts/{accountId}/passwords/{password}")
    public ResponseEntity<String> updatePassword(@PathVariable("accountId") @NonNull Long accountId,
                                                 @PathVariable("password") @NonNull String password) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        try {
            accountService.updateAccountPassword(password, accountId);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was issue as setting password for account %d", accountId));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    }

    /**
     * Update credit card response entity.
     *
     * @param accountId  the account id
     * @param creditcard the creditcard
     * @return the response entity
     */
    @PutMapping("/accounts/{accountId}/creditcards/{creditcard}")
    public ResponseEntity<String> updateCreditCard(@PathVariable("accountId") @NonNull Long accountId,
                                                   @PathVariable("creditcard") @NonNull String creditcard) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        try {
            accountService.updateAccountCreditCard(creditcard, accountId);
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was issue as setting credit card for account %d", accountId));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    }
}