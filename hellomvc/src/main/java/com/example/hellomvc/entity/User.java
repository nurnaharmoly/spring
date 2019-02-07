package com.example.hellomvc.entity;

import java.util.Objects;

public class User {
    private Long id;
    private String userName;
    private String mobile;

    public User(Long id, String userName, String mobile) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobile() {
        return mobile;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(mobile, user.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, mobile);
    }
}
