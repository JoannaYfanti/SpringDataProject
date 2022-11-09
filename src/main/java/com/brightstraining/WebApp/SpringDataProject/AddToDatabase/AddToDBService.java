package com.brightstraining.WebApp.SpringDataProject.AddToDatabase;

import com.brightstraining.WebApp.SpringDataProject.Student.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface AddToDBService {
    String addNewStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email, StudentRepository studentRepository);
}
