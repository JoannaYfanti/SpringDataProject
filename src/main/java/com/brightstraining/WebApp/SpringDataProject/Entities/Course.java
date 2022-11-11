package com.brightstraining.WebApp.SpringDataProject.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @OneToMany(mappedBy = "course")
    List<Student> students;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public Course() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
