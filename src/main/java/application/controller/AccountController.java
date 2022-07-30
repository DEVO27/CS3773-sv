package application.controller;

import application.model.CommonSV.ActionStatus;
import application.model.CommonSV.ResponseDetail;
import application.model.impl.AccountImpl;
import application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    private static final Logger logger = Logger.getLogger(AccountController.class.getName());
    private final AccountService accountService;
    ResponseDetail responseDetail = new ResponseDetail();

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users/{email}/passwords/{password}")
    public ResponseEntity<String> getAccount(@PathVariable("email") @NonNull String email,
                                             @PathVariable("password") @NonNull String password) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";
        try {
            accountService.findAccount(new AccountImpl(email, password, "4446659827819783"));
        } catch (IllegalArgumentException e) {
            errorMessage = e.toString();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was a problem finding username %s with password %s", email, password));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    }

    /*@PostMapping("/user/{email}/passphrase/{password}/card/{creditcard}")
    public ResponseEntity<String> registerNewAccount(@PathVariable("email") @NonNull String email,
                                                     @PathVariable("password") @NonNull String password,
                                                     @PathVariable("creditCard") @NonNull String creditCard) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "";

        try {

           // accountService.findAccount(new AccountImpl(name, username, password));
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was issue as account already exists for username %s", username));
        }

        return new ResponseEntity<>(errorMessage, httpStatus);
    } */
}