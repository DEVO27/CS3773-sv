package application.model.impl;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class AccountImpl extends UserImpl {
    @Id
    private Long iD;

    public AccountImpl(String name, String userName, String password) {
        super(name, userName, password);
        this.iD = new Random().nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl(String userName, String password) {
        super(userName, password);
        this.iD = new Random().nextLong(20000 - 10000) + 10000;
    }

    public AccountImpl() {
    }


    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }
}
