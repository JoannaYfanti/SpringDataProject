package com.brightstraining.WebApp.SpringDataProject.AddToDatabase;

import com.brightstraining.WebApp.SpringDataProject.Student.Student;
import com.brightstraining.WebApp.SpringDataProject.Student.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AddToDBServiceImpl implements AddToDBService {

    private String studentList ="";
    @Override
    public void  addNewStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email, StudentRepository studentRepository) {
        Student student = new Student(name, lastName, Integer.parseInt(age), email);
        studentRepository.save(student);
    }
}
