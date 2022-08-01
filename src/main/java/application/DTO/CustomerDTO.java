package application.DTO;

/**
 * The type Customer dto.
 */
public class CustomerDTO {
    private Long iD;
    private String firstname;
    private String lastname;
    private String address;

    /**
     * Instantiates a new Customer dto.
     *
     * @param iD        the d
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param address   the address
     */
    public CustomerDTO(Long iD, String firstname, String lastname, String address) {
        this.iD = iD;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    /**
     * Instantiates a new Customer dto.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     */
    public CustomerDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public Long getiD() {
        return iD;
    }

    /**
     * Sets d.
     *
     * @param iD the d
     */
    public void setiD(Long iD) {
        this.iD = iD;
    }

    /**
     * Gets firstname.
     *
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets firstname.
     *
     * @param firstname the firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("""
                        Customer [
                        "id" = '%d'
                        "firstName" = '%s'
                        "lastName" = '%s'
                        "address" = '%s'
                        ]""",
                getiD(),
                getFirstname(),
                getLastname(),
                getAddress());
    }
}
