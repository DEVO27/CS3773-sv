package application.model.impl;
import javax.persistence.*;
import java.util.Random;
public class AccountImpl extends UserImpl{
    private Long iD;

    public AccountImpl(String name, String userName, String password) {
        super(name, userName, password);
        this.iD = generateId();
    }

    public AccountImpl(){};

    private Long generateId() {
        Random rand = new Random();
        return rand.nextLong(20000 - 10000) + 10000;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s", super.getName(), super.getUserName(), super.getPassword());
    }
}
