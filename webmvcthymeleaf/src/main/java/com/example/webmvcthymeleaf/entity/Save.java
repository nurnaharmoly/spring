package com.example.webmvcthymeleaf.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "user")
public class Save {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Min(value = 18, message = "Hey, Minimum Age is 18")
    private byte age;


    @NotNull(message = "Enter An Email Addesss")
    @Column(name = "email", unique = true)
    private String email;

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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserController{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Save(@NotNull @Size(min = 2, max = 30) String name, @Min(value = 18, message = "Hey, Minimum Age is 18") byte age) {
        this.name = name;
        this.age = age;
    }

    public Save() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Save save = (Save) o;
        return age == save.age &&
                Objects.equals(id, save.id) &&
                Objects.equals(name, save.name) &&
                Objects.equals(email, save.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email);
    }
}
