package com.example.studentmvcproject;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "stu")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotNull
   @Size(min = 2, max = 30,message = "Hey, Size must be between 2 and 30")
   private String name;

   @NotNull(message = "Enter An Email Address")
   @Email
   @Column(name = "email", unique = true)
   private String email;

   private int phone;

   @Min(value = 18,message = "Hey, Minium Age is 18")
   private int age;

   private String gender;

   private String[] courseComplete;

   private String Round;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getCourseComplete() {
        return courseComplete;
    }

    public void setCourseComplete(String[] courseComplete) {
        this.courseComplete = courseComplete;
    }

    public String getRound() {
        return Round;
    }

    public void setRound(String round) {
        Round = round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return phone == student.phone &&
                age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(gender, student.gender) &&
                Arrays.equals(courseComplete, student.courseComplete) &&
                Objects.equals(Round, student.Round);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, email, phone, age, gender, Round);
        result = 31 * result + Arrays.hashCode(courseComplete);
        return result;
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, @NotNull(message = "Enter An Email Address") @Email String email, int phone, @Min(value = 18, message = "Hey, Minium Age is 18") int age, String gender, String[] courseComplete, String round) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.courseComplete = courseComplete;
        Round = round;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", courseComplete=" + Arrays.toString(courseComplete) +
                ", Round='" + Round + '\'' +
                '}';
    }

    public Student() {
    }
}
