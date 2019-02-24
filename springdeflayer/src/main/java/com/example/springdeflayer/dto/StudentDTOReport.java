package com.example.springdeflayer.dto;

public class StudentDTOReport {

    private long noOfStudent;
    private  String email;

    public StudentDTOReport() {
    }

    public StudentDTOReport(long noOfStudent, String email) {
        this.noOfStudent = noOfStudent;
        this.email = email;
    }

    public long getNoOfStudent() {
        return noOfStudent;
    }

    public void setNoOfStudent(long noOfStudent) {
        this.noOfStudent = noOfStudent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
