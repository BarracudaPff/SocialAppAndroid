package com.samsung.socialappandroid.models;

import java.util.Date;

public class User {
    public String name;
    public String email;
    public String description;
    public long creationDate;

    public User() {
        //do not remove
    }

    public User(String name, String email, String description, long creationDate) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
