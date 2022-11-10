package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateToDBServiceImpl implements UpdateToDBService {

    @Override
    public void updateAStudent(Student studentToUpdate, String name, String lastName, String age, String email, StudentRepository studentRepository) {
        studentToUpdate.setName(name);
        studentToUpdate.setLastName(lastName);
        studentToUpdate.setAge(Integer.parseInt(age));
        studentToUpdate.setEmail(email);

        studentRepository.save(studentToUpdate);
    }
}
