package application.model.impl;

import application.model.user;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserImpl implements user {
    private String name;
    private String username;
    private String password;

    public UserImpl(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserImpl() {
    }

    public UserImpl(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }
}
