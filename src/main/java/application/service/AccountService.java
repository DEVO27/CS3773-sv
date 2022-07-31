package application.service;

import application.model.impl.AccountImpl;
import application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountService {
    private static final Logger logger = Logger.getLogger(AccountService.class.getName());
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void findAccount(AccountImpl account) {
        Optional<AccountImpl> accountOptional = accountRepository.findAccountByUserNamePassword(
                account.getEmail(),
                account.getPassword());
        if (accountOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public void registerAccount(AccountImpl account) {
        Optional<AccountImpl> accountOptional = accountRepository.findAccountByUserNamePassword(
                account.getEmail(),
                account.getPassword());
        if (accountOptional.isPresent()) {
            throw new IllegalArgumentException();
        }
        accountRepository.saveAndFlush(account);
    }
}
