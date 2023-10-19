package com.student.studentRegistration.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "name")
    String studentName;

    @Column(name = "age")
    int studentAge;

    @Column(name = "gender")
    char studentSex;

    @Column(name = "class")
    String studentClass;

    public Student() {
    }

    public Student(int id, String studentName, int studentAge, char studentSex, String studentClass) {
        this.id = id;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentSex = studentSex;
        this.studentClass = studentClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public char getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(char studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
