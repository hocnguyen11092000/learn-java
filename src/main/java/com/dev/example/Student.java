package com.dev.example;

import jakarta.persistence.*;

@Entity
@Table(name = "T_STUDENT")
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true
    )
    private String email;
    private int age;
    @Column(
            updatable = false
    )
    private String some_column;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
