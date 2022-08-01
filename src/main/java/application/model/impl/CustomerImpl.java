package application.model.impl;

import application.model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

/**
 * The type Customer.
 */

@Entity
@Table(name = "customer", schema = "public")
public class CustomerImpl implements customer {
    @Id
    @Column(name = "customer_id")
    private Long iD;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;

    /**
     * Instantiates a new Customer.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param address   the address
     */
    public CustomerImpl(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.iD = new Random().nextLong(200000 - 100000) + 100000;
    }

    public CustomerImpl(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iD = new Random().nextLong(200000 - 100000) + 100000;
    }

    /**
     * Instantiates a new Customer.
     */
    public CustomerImpl() {

    }

    @Override
    public Long getiD() {
        return iD;
    }

    @Override
    public void setiD(Long iD) {
        this.iD = iD;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
