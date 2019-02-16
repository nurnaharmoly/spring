package com.example.crudtest;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stu")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String mobile;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name ="user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id")

    )

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(mobile, user.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mobile);
    }

    public User() {
    }


    public User(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }
}
