package application.repository;

import application.DTO.AccountDTO;
import application.model.impl.AccountImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Account repository.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountImpl, Long> {
    /**
     * Find account by user name password optional.
     *
     * @param email    the email
     * @param password the password
     * @return the optional
     */
    @Query("SELECT new application.DTO.AccountDTO(a.id, a.email, a.password, a.creditCard) " +
            "FROM AccountImpl a " +
            "WHERE a.email = ?1 AND a.password = ?2")
    Optional<AccountDTO> findAccountByUserNamePassword(String email, String password);

    /**
     * Update email.
     *
     * @param email     the email
     * @param accountId the account id
     */
    @Modifying
    @Query("UPDATE AccountImpl a " +
            "SET a.email = ?1 " +
            "WHERE a.id = ?2")
    void updateEmail(String email, Long accountId);

    /**
     * Update password.
     *
     * @param password  the password
     * @param accountId the account id
     */
    @Modifying
    @Query("UPDATE AccountImpl a " +
            "SET a.password = ?1 " +
            "WHERE a.id = ?2")
    void updatePassword(String password, Long accountId);

    /**
     * Update credit card.
     *
     * @param creditCard the credit card
     * @param accountId  the account id
     */
    @Modifying
    @Query("UPDATE AccountImpl a " +
            "SET a.creditCard = ?1 " +
            "WHERE a.id = ?2")
    void updateCreditCard(String creditCard, Long accountId);

}
