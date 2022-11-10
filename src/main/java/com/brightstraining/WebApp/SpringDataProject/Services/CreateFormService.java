package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreateFormService {
    ResponseEntity<String> createMainForm(List<Student> students);

    ResponseEntity<String> createUpdateForm(Student studentToUpdate);

    ResponseEntity<String> createAddedForm(List<Student> students);
}
