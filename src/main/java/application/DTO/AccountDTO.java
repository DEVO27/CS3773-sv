package application.DTO;

/**
 * The type Account dto.
 */
public class AccountDTO {
    private Long id;
    private String email;
    private String password;
    private String creditCard;

    /**
     * Instantiates a new Account dto.
     *
     * @param id         the id
     * @param email      the email
     * @param password   the password
     * @param creditCard the credit card
     */
    public AccountDTO(Long id, String email, String password, String creditCard) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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
        return String.format("""
                        Account [
                        "id" = '%d'
                        "email" = '%s'
                        "password" = '%s'
                        "credit card" = '%s'
                        ]""",
                getId(),
                getEmail(),
                getPassword(),
                getCreditCard());
    }
}
