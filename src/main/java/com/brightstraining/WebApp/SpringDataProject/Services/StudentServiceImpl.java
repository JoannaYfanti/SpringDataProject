package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Override
    public List<Student> createListFromStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findASpecificStudentByConcatenatedProperties(String studentConcatenatedProperties) {
        for (Student student : createListFromStudent()) {
            String currentStudentConcatenatedProperties = student.getName() + " " + student.getLastName() + student.getAge() + student.getEmail();
            if (currentStudentConcatenatedProperties.equals(studentConcatenatedProperties)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public Student findASpecificStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
}
