package com.example.validationcurd;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "uu")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30")
    private String name;

    @Min(value = 18, message = "Hey, Minimum Age is 18")
    private byte age;

    @NotNull(message = "Enter An Email Address")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Enter A Course At least")
    private String[] courseCompleted;

    @NotEmpty(message = "Enter Gender")
    private String gender;

    @NotEmpty(message = "Enter round")
    private String round;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;


    private Long fileSize;
    private String fileName;
    private String filePath;
    private String fileExtension;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, @Min(value = 18, message = "Hey, Minimum Age is 18") byte age, @NotNull(message = "Enter An Email Address") @Email String email, @NotEmpty(message = "Enter A Course At least") String[] courseCompleted, @NotEmpty(message = "Enter Gender") String gender, @NotEmpty(message = "Enter round") String round, Date regiDate, Date lastModifiedDate, Date birthDate, Long fileSize, String fileName, String filePath, String fileExtension, Set<Role> roles) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.courseCompleted = courseCompleted;
        this.gender = gender;
        this.round = round;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
        this.roles = roles;
    }

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

    public String[] getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String[] courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Arrays.equals(courseCompleted, user.courseCompleted) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(round, user.round) &&
                Objects.equals(regiDate, user.regiDate) &&
                Objects.equals(lastModifiedDate, user.lastModifiedDate) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(fileSize, user.fileSize) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(filePath, user.filePath) &&
                Objects.equals(fileExtension, user.fileExtension) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, age, email, gender, round, regiDate, lastModifiedDate, birthDate, fileSize, fileName, filePath, fileExtension, roles);
        result = 31 * result + Arrays.hashCode(courseCompleted);
        return result;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", courseCompleted=" + Arrays.toString(courseCompleted) +
                ", gender='" + gender + '\'' +
                ", round='" + round + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", birthDate=" + birthDate +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", roles=" + roles +
                '}';
    }
}
