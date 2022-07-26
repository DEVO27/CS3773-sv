package application.model.impl;

import application.model.user;

public class UserImpl implements user {
    private String name;
    private String userName;
    private String password;

    public UserImpl(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }
    public UserImpl() {}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
