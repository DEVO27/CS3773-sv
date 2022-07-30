package application.model.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name = "account", schema = "public")
public class AccountImpl {
    @Id
    @Column(name = "id")
    private Long iD;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "credit_card")
    private String creditCard;

    public AccountImpl(String email, String password, String creditCard) {
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.iD = new Random().nextLong(200000 - 100000) + 100000;
    }

    public AccountImpl() {
    }

    public Long getID() {
        return iD;
    }

    public void setID(Long accountId) {
        this.iD = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    /*@Id
    private Long iD;

    public AccountImpl(String name, String userName, String password) {
        //super(name, userName, password);
        this.iD = new Random().nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl(String userName, String password) {
        //super(userName, password);
        this.iD = new Random().nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl() {
    }


    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    } */
}
