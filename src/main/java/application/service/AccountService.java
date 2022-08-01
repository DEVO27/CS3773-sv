package application.service;

import application.DTO.AccountDTO;
import application.model.impl.AccountImpl;
import application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * The type Account service.
 */
@Service
public class AccountService {
    private static final Logger logger = Logger.getLogger(AccountService.class.getName());
    private static Long id;
    private final AccountRepository accountRepository;

    /**
     * Instantiates a new Account service.
     *
     * @param accountRepository the account repository
     */
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public static Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public static void setId(Long id) {
        AccountService.id = id;
    }

    /**
     * Find account account dto.
     *
     * @param account the account
     * @return the account dto
     */
    public AccountDTO findAccount(AccountImpl account) {
        Optional<AccountDTO> optionalAccountDTO = accountRepository.findAccountByUserNamePassword(
                account.getEmail(),
                account.getPassword());
        if (!optionalAccountDTO.isPresent()) {
            throw new NoSuchElementException();
        }

        return optionalAccountDTO.get();
    }

    /**
     * Register account.
     *
     * @param account the account
     */
    public void registerAccount(AccountImpl account) {
        Optional<AccountDTO> optionalAccountDTO = accountRepository.findAccountByUserNamePassword(
                account.getEmail(),
                account.getPassword());
        if (optionalAccountDTO.isPresent()) {
            throw new IllegalArgumentException();
        }

        id = account.getID();
        accountRepository.save(account);
        logger.info("New Account created");
    }

    /**
     * Update account email.
     *
     * @param email     the email
     * @param accountId the account id
     */
    @Transactional
    @Modifying
    public void updateAccountEmail(String email, Long accountId) {
        accountRepository.updateEmail(email, accountId);
    }


    /**
     * Update account password.
     *
     * @param password  the password
     * @param accountId the account id
     */
    @Transactional
    @Modifying
    public void updateAccountPassword(String password, Long accountId) {
        accountRepository.updatePassword(password, accountId);
    }

    /**
     * Update account credit card.
     *
     * @param creditCard the credit card
     * @param accountId  the account id
     */
    @Transactional
    @Modifying
    public void updateAccountCreditCard(String creditCard, Long accountId) {
        accountRepository.updateCreditCard(creditCard, accountId);
    }

}
