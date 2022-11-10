package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public interface UpdateToDBService {
    void updateAStudent(Student studentToUpdate, String name, String lastName, String age, String email, StudentRepository studentRepository);
}
