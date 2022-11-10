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

        String listOfStudents = "<select name=\"listOfStudents\">";
        List<Student> students = (List<Student>) studentRepository.findAll();
        for (Student newStudents:students) {
            listOfStudents += "<option>" + newStudents.getName() + " " + newStudents.getLastName() +  newStudents.getAge() + newStudents.getEmail() + "</option>";
        }
        listOfStudents += "</select>";


        return ResponseEntity.ok("<form action=\"/added\" method=\"POST\">" +
                "<input name=\"name\" placeholder=\"Student's first name\">" +
                "<input name=\"lastName\" placeholder=\"Student's last name\">" +
                "<input name=\"age\" placeholder=\"Student's age\">" +
                "<input name=\"email\" placeholder=\"Student's email address\">" +
                "<button>Add</button>" +
                listOfStudents+
                "<button formaction=\"/update\" formmethod=\"GET\">Update</button>" +
                "<button formaction=\"/delete\" method=\"POST\">Remove</button>" +
                "</form>");
    }

    @PostMapping("/added")
    public ResponseEntity<String> successfullyAdded(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email) {

        String studentAttributes = "<form action=\"/added/delete\" method=\"POST\"><dl>";
        addToDBService.addNewStudent( name, lastName,age, email, studentRepository);
        List<Student> students = (List<Student>) studentRepository.findAll();
        for (Student student:students) {
            studentAttributes += "<dt>" + student.getName() + " " + student.getLastName()  + "  " + "<button name=\"studentToDeleteById\" value = \"" + student.getId() + "\">Remove</button><button formaction=\"/edit\" formmethod=\"GET\" name=\"studentToEditById\" value = \"" + student.getId() + "\">Edit</button></dt><dd>" + student.getAge()+"</dd><dd>" + student.getEmail() + "</dd>";
        }
        return ResponseEntity.ok(studentAttributes + "</dl></form>");

    }
    @PostMapping("/added/delete")
    public ResponseEntity<String> removeStudentAfterAdd(@RequestParam String studentToDeleteById) {

      studentRepository.deleteById(Long.parseLong(studentToDeleteById));

        return ResponseEntity.ok("Student deleted");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> removeStudent(@RequestParam String listOfStudents) {

        List<Student> students = (List<Student>) studentRepository.findAll();
        for (Student student:students) {
            String st = student.getName() + " " + student.getLastName()+ student.getAge()+ student.getEmail();
            if(st.equals(listOfStudents)){
                studentRepository.delete(student);
                break;
            }
        }
        return ResponseEntity.ok("Student deleted");
    }
    @GetMapping("/update")
    @ResponseBody
    public ResponseEntity <String> updateStudent (@RequestParam String listOfStudents){

        List<Student> students = (List<Student>) studentRepository.findAll();
        Student studentToUpdate = null;
        for (Student student:students) {
            String st = student.getName() + " " + student.getLastName()+ student.getAge()+ student.getEmail();
            if(st.equals(listOfStudents)){
                studentToUpdate= student;
                break;
            }

            }
        return ResponseEntity.ok("<form action=\"/updated\" method=\"POST\">" +
                "<input name=\"name\" value= " + studentToUpdate.getName()+">" +
                "<input name=\"lastName\" value= " + studentToUpdate.getLastName()+ ">" +
                "<input name=\"age\" value=" + studentToUpdate.getAge()+ ">"+
                "<input name=\"email\" value=" + studentToUpdate.getEmail()+ ">"+
                "<input name=\"id\" readonly value=" + studentToUpdate.getId()+ ">"+
                "<button>Save</button>" +
                "</form>");
    }
    @PostMapping("/updated")

    public ResponseEntity <String> modifyStudent (@RequestParam Long id, @RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email){
        Student studentToModify = (Student) studentRepository.findById(id).get();

        studentToModify.setName(name);
        studentToModify.setLastName(lastName);
        studentToModify.setAge(Integer.parseInt(age));
        studentToModify.setEmail(email);

        studentRepository.save(studentToModify);


        return ResponseEntity.ok("Student " +studentToModify.getName() + " " + studentToModify.getLastName() + " is updated.");
    }

    @GetMapping("/edit")
    @ResponseBody
    public ResponseEntity <String> editStudent(@RequestParam String studentToEditById){

        Student studentToEdit =  studentRepository.findById(Long.parseLong(studentToEditById)).get();
        studentRepository.findById(Long.parseLong(studentToEditById)).get();


        return  ResponseEntity.ok("<form action=\"/updated\" method=\"POST\">" +
                "<input name=\"name\" value= " + studentToEdit.getName()+">" +
                "<input name=\"lastName\" value= " + studentToEdit.getLastName()+ ">" +
                "<input name=\"age\" value=" + studentToEdit.getAge()+ ">"+
                "<input name=\"email\" value=" + studentToEdit.getEmail()+ ">"+
                "<input name=\"id\" readonly value=" + studentToEdit.getId()+ ">"+
                "<button>Save</button>" +
                "</form>");
    }
}
