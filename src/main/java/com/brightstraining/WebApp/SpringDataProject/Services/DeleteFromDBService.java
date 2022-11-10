package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public interface DeleteFromDBService {
    void deleteASpecificStudentByConcatenatedProperties(StudentRepository studentRepository, Student studentToDelete);

    void deleteASpecificStudentById(StudentRepository studentRepository, String idFromAStudent);
}
