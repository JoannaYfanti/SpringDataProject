package com.brightstraining.WebApp.SpringDataProject.Controller;

import com.brightstraining.WebApp.SpringDataProject.Student.Student;
import com.brightstraining.WebApp.SpringDataProject.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DatabaseController {
    private StudentRepository studentRepository;

    @Autowired
    public DatabaseController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> addNewStudentToTheDatabase() {
        Student student = new Student();
        student.setName("Ioanna");
        student.setAge(36);
        student.setLastName("Yfanti");
        student.setEmail("i.yfanti@cosmote-evalue.gr");

        studentRepository.save(student);

        return ResponseEntity.ok("Save " + student.getName() +" " +student.getLastName() + " " + student.getAge()+ " " +student.getEmail() + " to database.");
    }
}
