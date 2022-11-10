package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> createListFromStudent();

    Student findASpecificStudentByConcatenatedProperties(String studentConcatenatedProperties);

    Student findASpecificStudentById(Long id);

    StudentRepository getStudentRepository();


}
