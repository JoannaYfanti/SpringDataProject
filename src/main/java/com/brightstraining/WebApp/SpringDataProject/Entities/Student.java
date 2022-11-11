package com.brightstraining.WebApp.SpringDataProject.Entities;

import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;

import javax.persistence.*;

@Entity
public class Student {
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String email;

    public Student(String name, String lastName, int age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
