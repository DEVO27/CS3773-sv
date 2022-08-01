package application.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

/**
 * The type Account.
 */
@Entity
@Table(name = "account", schema = "public")
public class AccountImpl {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "credit_card")
    private String creditCard;

    @Column(name = "customer_id")
    private Long customerId;

    /**
     * Instantiates a new Account.
     *
     * @param email      the email
     * @param password   the password
     * @param creditCard the credit card
     */
    public AccountImpl(String email, String password, String creditCard) {
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.id = new Random().nextLong(200000 - 100000) + 100000;
    }

    /**
     * Instantiates a new Account.
     *
     * @param email    the email
     * @param password the password
     */
    public AccountImpl(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Instantiates a new Account.
     */
    public AccountImpl() {
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getID() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param accountId the account id
     */
    public void setID(Long accountId) {
        this.id = accountId;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets credit card.
     *
     * @return the credit card
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Sets credit card.
     *
     * @param creditCard the credit card
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "AccountImpl {" +
                "iD=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
