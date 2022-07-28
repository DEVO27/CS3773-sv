package application.service;

import application.model.impl.AccountImpl;
import application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void findAccount(AccountImpl account) {
        Optional<AccountImpl> accountOptional = accountRepository.findAccountByUserNamePassword(
                account.getUsername(),
                account.getPassword());

        if (accountOptional.isPresent()) {
            throw new IllegalArgumentException();
        }

        accountRepository.saveAndFlush(account);
    }
}
