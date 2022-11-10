package com.brightstraining.WebApp.SpringDataProject.Controllers;

import com.brightstraining.WebApp.SpringDataProject.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DatabaseController {
    private AddToDBService addToDBService;
    private CreateFormService createFormService;
    private StudentService listingStudentsService;
    private UpdateToDBService updateToDBService;
    private DeleteFromDBService deleteFromDBService;

    @Autowired
    public DatabaseController(AddToDBService addToDBService, CreateFormService createFormService, StudentService listingStudentsService, UpdateToDBService updateToDBService, DeleteFromDBService deleteFromDBService) {
        this.addToDBService = addToDBService;
        this.createFormService = createFormService;
        this.listingStudentsService = listingStudentsService;
        this.updateToDBService = updateToDBService;
        this.deleteFromDBService = deleteFromDBService;
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> addNewStudentToTheDatabase() {
        return createFormService.createMainForm(listingStudentsService.createListFromStudent());
    }

    @PostMapping("/added")
    public ResponseEntity<String> successfullyAdded(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
        addToDBService.addNewStudent(name, lastName, age, email, listingStudentsService.getStudentRepository());

        return createFormService.createAddedForm(listingStudentsService.createListFromStudent());
    }

    @PostMapping("/added/delete")
    public ResponseEntity<String> removeStudentAfterAdd(@RequestParam String idFromAStudent) {
        deleteFromDBService.deleteASpecificStudentById(listingStudentsService.getStudentRepository(), idFromAStudent);

        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> removeStudent(@RequestParam String studentConcatenatedProperties) {
        deleteFromDBService.deleteASpecificStudentByConcatenatedProperties(listingStudentsService.getStudentRepository(), listingStudentsService.findASpecificStudentByConcatenatedProperties(studentConcatenatedProperties));

        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateStudent(@RequestParam String studentConcatenatedProperties) {
        return createFormService.createUpdateForm(listingStudentsService.findASpecificStudentByConcatenatedProperties(studentConcatenatedProperties));
    }

    @PostMapping("/updated")

    public ResponseEntity<String> modifyStudent(@RequestParam Long id, @RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {
        updateToDBService.updateAStudent(listingStudentsService.findASpecificStudentById(id), name, lastName, age, email, listingStudentsService.getStudentRepository());

        return ResponseEntity.ok("Student is updated");
    }

    @GetMapping("/edit")
    @ResponseBody
    public ResponseEntity<String> editStudent(@RequestParam String idFromAStudent) {
        return createFormService.createUpdateForm(listingStudentsService.findASpecificStudentById(Long.parseLong(idFromAStudent)));
    }
}
