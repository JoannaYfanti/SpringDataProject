package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteFromDBServiceImpl implements DeleteFromDBService {
    @Override
    public void deleteASpecificStudentByConcatenatedProperties(StudentRepository studentRepository, Student studentToDelete) {
        studentRepository.delete(studentToDelete);
    }

    @Override
    public void deleteASpecificStudentById(StudentRepository studentRepository, String idFromAStudent) {
        studentRepository.deleteById(Long.parseLong(idFromAStudent));
    }
}
