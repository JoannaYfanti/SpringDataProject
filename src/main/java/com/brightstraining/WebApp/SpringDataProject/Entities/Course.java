package com.brightstraining.WebApp.SpringDataProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Course {
    @OneToMany(mappedBy = "course")
    List<Student> students;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
