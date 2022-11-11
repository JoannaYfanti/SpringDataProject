package com.brightstraining.WebApp.SpringDataProject.Repositories;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentByName(String name);
    List<Student> findStudentByNameOrLastNameOrAgeOrEmail(String name, String lastName, int age, String email);



}
