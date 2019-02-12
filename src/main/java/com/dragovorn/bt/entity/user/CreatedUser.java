package com.dragovorn.bt.entity.user;

public class CreatedUser {

    private String email;
    private String username;
    private String password;

    public CreatedUser(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "CreatedUser[email=" + this.email + ",username=" + this.username + ",password=" + this.password + "]";
    }
}
