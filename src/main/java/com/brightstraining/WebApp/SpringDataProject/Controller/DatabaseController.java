package com.brightstraining.WebApp.SpringDataProject.Controller;

import com.brightstraining.WebApp.SpringDataProject.AddToDatabase.AddToDBService;
import com.brightstraining.WebApp.SpringDataProject.Student.Student;
import com.brightstraining.WebApp.SpringDataProject.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DatabaseController {
    private StudentRepository studentRepository;
    private AddToDBService addToDBService;

    @Autowired
    public DatabaseController(StudentRepository studentRepository, AddToDBService addToDBService) {
        this.studentRepository = studentRepository;
        this.addToDBService = addToDBService;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> addNewStudentToTheDatabase() {
//        Student student = new Student();
//        student.setName("Ioanna");
//        student.setAge(36);
//        student.setLastName("Yfanti");
//        student.setEmail("i.yfanti@cosmote-evalue.gr");
//
//        studentRepository.save(student);
//
//        return ResponseEntity.ok("Save " + student.getName() +" " +student.getLastName() + " " + student.getAge()+ " " +student.getEmail() + " to database.");
        return ResponseEntity.ok("<form action=\"/added\" method=\"POST\">" +
                "<input name=\"name\" placeholder=\"Student's first name\">" +
                "<input name=\"lastName\" placeholder=\"Student's last name\">" +
                "<input name=\"age\" placeholder=\"Student's age\">" +
                "<input name=\"email\" placeholder=\"Student's email address\">" +
                "<button>Add</button>" +
                "</form>");
    }

    @PostMapping("/added")
    public ResponseEntity<String> successfullyAdded(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
//        return ResponseEntity.ok(addToDBService.addNewStudent(name, lastName, age, email, studentRepository));
        String studentAttributes = "<dl>";
        addToDBService.addNewStudent( name, lastName,age, email, studentRepository);
        List<Student> students = (List<Student>) studentRepository.findAll();
        for (Student newStudents:students) {
            studentAttributes += "<dt>" + newStudents.getName() + " " + newStudents.getLastName() + "</dt><dd>" + newStudents.getAge()+"</dd><dd>" + newStudents.getEmail() + "</dd>";
        }
        return ResponseEntity.ok(studentAttributes + "</dl>");
    }


}
