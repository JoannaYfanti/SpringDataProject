package com.brightstraining.WebApp.SpringDataProject.Controllers;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DatabaseController {
    private AddToDBService addToDBService;
    private CreateFormService createFormService;
    private StudentService studentService;
    private UpdateToDBService updateToDBService;
    private DeleteFromDBService deleteFromDBService;

    @Autowired
    public DatabaseController(AddToDBService addToDBService, CreateFormService createFormService, StudentService studentService, UpdateToDBService updateToDBService, DeleteFromDBService deleteFromDBService) {
        this.addToDBService = addToDBService;
        this.createFormService = createFormService;
        this.studentService = studentService;
        this.updateToDBService = updateToDBService;
        this.deleteFromDBService = deleteFromDBService;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> addNewStudentToTheDatabase() {
        return createFormService.createMainForm(studentService.createListFromStudent());
    }

    @PostMapping("/added")
    public ResponseEntity<String> successfullyAdded(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
        addToDBService.addNewStudent(name, lastName, age, email, studentService.getStudentRepository());

        return createFormService.createAddedForm(studentService.createListFromStudent());
    }

    @PostMapping("/added/delete")
    public ResponseEntity<String> removeStudentAfterAdd(@RequestParam String idFromAStudent) {
        deleteFromDBService.deleteASpecificStudentById(studentService.getStudentRepository(), idFromAStudent);

        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> removeStudent(@RequestParam String studentConcatenatedProperties) {
        deleteFromDBService.deleteASpecificStudentByConcatenatedProperties(studentService.getStudentRepository(), studentService.findASpecificStudentByConcatenatedProperties(studentConcatenatedProperties));

        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@RequestParam String studentConcatenatedProperties) {
        return createFormService.createUpdateForm(studentService.findASpecificStudentByConcatenatedProperties(studentConcatenatedProperties));
    }

    @PostMapping("/updated")

    public ResponseEntity<String> modifyStudent(@RequestParam Long id, @RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
        updateToDBService.updateAStudent(studentService.findASpecificStudentById(id), name, lastName, age, email, studentService.getStudentRepository());

        return ResponseEntity.ok("Student is updated");
    }

    @GetMapping("/edit")
    @ResponseBody
    public ResponseEntity<String> editStudent(@RequestParam String idFromAStudent) {
        return createFormService.createUpdateForm(studentService.findASpecificStudentById(Long.parseLong(idFromAStudent)));
    }
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<String> searchStudent(){
        return createFormService.createSearchForm();
    }

    @GetMapping("/searchresult")
    @ResponseBody
    public ResponseEntity<String> searchStudentResult(@RequestParam String property){
        List<Student> students = studentService.getStudentRepository().findStudentByName(property);
        String studentProperties = "";
        for(Student student : students){
           studentProperties += student.getName() + student.getLastName() + student.getAge() + student.getEmail() ;
        }

        return ResponseEntity.ok(studentProperties);

    }

}
