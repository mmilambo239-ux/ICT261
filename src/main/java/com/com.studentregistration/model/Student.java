package com.studentregistration.model;

public class Student {
    private String studentId;
    private String name;
    private String program;
    private String email;

    public Student(String studentId, String name, String program, String email) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}