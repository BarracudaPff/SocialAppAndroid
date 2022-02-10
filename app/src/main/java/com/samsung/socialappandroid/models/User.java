package com.samsung.socialappandroid.models;

import java.util.Date;

public class User {
    public String name;
    public String email;
    public Date creationDate;

    public User() {
    }

    public User(String name, String email, long creationDate) {
        this.name = name;
        this.email = email;
        this.creationDate = new Date(creationDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
