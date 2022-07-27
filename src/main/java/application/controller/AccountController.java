package application.controller;

import application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(path = "api/v1/account")
public class AccountController {
    private static final Logger logger = Logger.getLogger(AccountController.class.getName());
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/user/{username}/passphrase/{password}")
    public ResponseEntity<String> getAccount(@PathVariable("username") @NonNull String username,
                                             @PathVariable("password") @NonNull String password) {
        HttpStatus httpStatus = HttpStatus.OK;
        String errorMessage = "All Good";
        try{
            accountService.findAccount("name", "password");
        } catch (NullPointerException e) {
            errorMessage = e.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            logger.info(String.format("There was a problem finding username %s with password %s", username, password));
        }
        return new ResponseEntity<>(errorMessage, httpStatus);
    }
}