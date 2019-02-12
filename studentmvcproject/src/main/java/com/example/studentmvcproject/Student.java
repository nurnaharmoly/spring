package com.example.studentmvcproject;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "stu")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotNull
   @Size(min = 2, max = 30,message = "Hey, Size must be between 2 and 30")
   private String name;

   @NotEmpty(message = "Enter An Email Address")
   @Email
   @Column(name = "email", unique = true)
   private String email;

   @Min(value = 18,message = "Hey, Minium Age is 18")
   private int age;

   @NotNull(message = "Enter Gender")
   private String gender;

   @NotEmpty(message = "Enter A Course at least")
   private String[] courseComplete;

   @NotEmpty(message = "Enter Round")
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


    private long fileSize;
    private String fileName;
    private String filePath;
    private String fileExtension;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "stu_role",
            joinColumns = @JoinColumn(name = "stu_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private Set<Role> roles;


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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
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

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Hey, Size must be between 2 and 30") String name, @NotNull(message = "Enter An Email Address") @Email String email, @Min(value = 18, message = "Hey, Minium Age is 18") int age, @NotNull(message = "Enter Gender") String gender, @NotNull(message = "Enter A Course at least") String[] courseComplete, @NotNull(message = "Enter Round") String round, Date regiDate, Date lastModifiedDate, Date birthDate, long fileSize, String fileName, String filePath, String fileExtension) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.courseComplete = courseComplete;
        this.round = round;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
        this.fileSize = fileSize;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", courseComplete=" + Arrays.toString(courseComplete) +
                ", round='" + round + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", birthDate=" + birthDate +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                fileSize == student.fileSize &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(email, student.email) &&
                Objects.equals(gender, student.gender) &&
                Arrays.equals(courseComplete, student.courseComplete) &&
                Objects.equals(round, student.round) &&
                Objects.equals(regiDate, student.regiDate) &&
                Objects.equals(lastModifiedDate, student.lastModifiedDate) &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(fileName, student.fileName) &&
                Objects.equals(filePath, student.filePath) &&
                Objects.equals(fileExtension, student.fileExtension);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, email, age, gender, round, regiDate, lastModifiedDate, birthDate, fileSize, fileName, filePath, fileExtension);
        result = 31 * result + Arrays.hashCode(courseComplete);
        return result;
    }
}
