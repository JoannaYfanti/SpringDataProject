package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateFormServiceImpl implements CreateFormService {
    @Override
    public ResponseEntity<String> createMainForm(List<Student> students) {
        String dropDownListForStudents = "<select name=\"studentConcatenatedProperties\">";
        for (Student student : students) {
            dropDownListForStudents += "<option>" + student.getName() + " " + student.getLastName() + student.getAge() + student.getEmail() + "</option>";
        }
        dropDownListForStudents += "</select>";

        return ResponseEntity.ok("<form action=\"/added\" method=\"POST\">" +
                "<input name=\"name\" placeholder=\"Student's first name\">" +
                "<input name=\"lastName\" placeholder=\"Student's last name\">" +
                "<input name=\"age\" placeholder=\"Student's age\">" +
                "<input name=\"email\" placeholder=\"Student's email address\">" +
                "<button>Add</button>" +
                dropDownListForStudents +
                "<button formaction=\"/update\" formmethod=\"GET\">Update</button>" +
                "<button formaction=\"/delete\" formmethod=\"POST\">Remove</button>" +
                "<button formaction=\"/search\" formmethod=\"GET\">Search</button>" +
                "</form>");
    }

    @Override
    public ResponseEntity<String> createUpdateForm(Student studentToUpdate) {
        return ResponseEntity.ok("<form action=\"/updated\" method=\"POST\">" +
                "<input name=\"name\" value= " + studentToUpdate.getName() + ">" +
                "<input name=\"lastName\" value= " + studentToUpdate.getLastName() + ">" +
                "<input name=\"age\" value=" + studentToUpdate.getAge() + ">" +
                "<input name=\"email\" value=" + studentToUpdate.getEmail() + ">" +
                "<input name=\"id\" readonly value=" + studentToUpdate.getId() + ">" +
                "<button>Save</button>" +
                "</form>");
    }

    @Override
    public ResponseEntity<String> createAddedForm(List<Student> students) {
        String studentAttributes = "<form action=\"/added/delete\" method=\"POST\"><dl>";

        for (Student student : students) {
            studentAttributes += "<dt>" + student.getName() + " " + student.getLastName() + "  " + "<button name=\"idFromAStudent\" value = \"" + student.getId() + "\">Remove</button>" + "  " + "<button formaction=\"/edit\" formmethod=\"GET\" name=\"idFromAStudent\" value = \"" + student.getId() + "\">Edit</button></dt><dd>" + student.getAge() + "</dd><dd>" + student.getEmail() + "</dd>";
        }
        return ResponseEntity.ok(studentAttributes + "</dl></form>");
    }

    @Override
    public ResponseEntity<String> createSearchForm() {
        return ResponseEntity.ok("<form action =\"/searchresult\" method=\"GET\">" +
                "<input name=\"property\" placeholder =\"First Name, Last Name, Age, Email\">" +
                "<button>Go</button>" +
                "</form>");
    }
}
