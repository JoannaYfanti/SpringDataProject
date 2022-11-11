package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Course;
import com.brightstraining.WebApp.SpringDataProject.Repositories.CourseRepository;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface AddToDBService {
    void  addNewStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email, StudentRepository studentRepository, Course course);
    void  addNewCourse(@RequestParam String courseName, CourseRepository courseRepository);
}
