package application.service;

import application.model.impl.AccountImpl;
import application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    /*** Should call database to find record ***/
    public List<AccountImpl> findAccount(String userName) {
        return accountRepository.findAll();
    }
}
