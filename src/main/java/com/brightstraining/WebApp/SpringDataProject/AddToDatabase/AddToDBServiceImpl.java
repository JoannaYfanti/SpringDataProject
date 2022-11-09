package com.brightstraining.WebApp.SpringDataProject.AddToDatabase;

import com.brightstraining.WebApp.SpringDataProject.Student.Student;
import com.brightstraining.WebApp.SpringDataProject.Student.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AddToDBServiceImpl implements AddToDBService {
    @Override
    public String addNewStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email, StudentRepository studentRepository) {
        Student student = new Student(name, lastName, Integer.parseInt(age), email);

        studentRepository.save(student);

        return "Save " + student.getName() +" " +student.getLastName() + " " + student.getAge()+ " " +student.getEmail() + " to database.";
    }
}
