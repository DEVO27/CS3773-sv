package application.model.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class AccountImpl extends UserImpl {
    @Id
    private Long iD;
    private final Random rand = new Random();

    public AccountImpl(String name, String userName, String password) {
        super(name, userName, password);
        this.iD = rand.nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl(String userName, String password) {
        super(userName, password);
        this.iD = rand.nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl() {
    }

    /*@Override
    public String toString() {
        return """
                name = %s
                username = %s
                password = %s
                iD = %d
                """, super.getName(),

        return String.format("name = %s\nusername = %s\n" +
                        "password = %s\n" +
                        "iD = %d",
                super.getName(),
                super.getUsername(),
                super.getPassword(),
                getiD());
    } */

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }
}
