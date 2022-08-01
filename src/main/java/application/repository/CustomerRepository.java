package application.repository;

import application.DTO.CustomerDTO;
import application.model.impl.CustomerImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerRepository extends
        JpaRepository<CustomerImpl, Long> {

    /**
     * Find customer by account id optional.
     *
     * @param accountId the account id
     * @return the optional
     */
    @Query(value =
            "SELECT new application.DTO.CustomerDTO(c.iD, c.firstName, c.lastName, c.address) " +
                    "FROM CustomerImpl c " +
                    "WHERE EXISTS(SELECT a FROM AccountImpl a WHERE a.id = ?1 " +
                    "AND c.iD = a.customerId)")
    Optional<CustomerDTO> findCustomerByAccountId(Long accountId);

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     * @param accountId  the account id
     */
    @Modifying
    @Query("UPDATE AccountImpl " +
            "SET customerId = ?1 " +
            "WHERE id = ?2")
    void setCustomerId(Long customerId, Long accountId);

    /**
     * Update firstname.
     *
     * @param firstname the firstname
     * @param accountId the account id
     */
    @Modifying
    @Query("UPDATE CustomerImpl c " +
            "SET c.firstName = ?1 " +
            "WHERE EXISTS(SELECT a FROM AccountImpl a WHERE a.id = ?2 " +
            "AND c.iD = a.customerId)")
    void updateFirstname(String firstname, Long accountId);

    /**
     * Update lastname.
     *
     * @param lastname  the lastname
     * @param accountId the account id
     */
    @Modifying
    @Query("UPDATE CustomerImpl c " +
            "SET c.lastName = ?1 " +
            "WHERE EXISTS(SELECT a FROM AccountImpl a WHERE a.id = ?2 " +
            "AND c.iD = a.customerId)")
    void updateLastname(String lastname, Long accountId);

    /**
     * Update address.
     *
     * @param address   the address
     * @param accountId the account id
     */
    @Modifying
    @Query("UPDATE CustomerImpl c " +
            "SET c.address = ?1 " +
            "WHERE EXISTS(SELECT a FROM AccountImpl a WHERE a.id = ?2 " +
            "AND c.iD = a.customerId)")
    void updateAddress(String address, Long accountId);
}
