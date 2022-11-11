package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Entities.Course;
import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import com.brightstraining.WebApp.SpringDataProject.Repositories.CourseRepository;
import com.brightstraining.WebApp.SpringDataProject.Repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class AddToDBServiceImpl implements AddToDBService {
    @Override
    public void addNewStudent(@RequestParam String name, @RequestParam String lastName, @RequestParam String age, @RequestParam String email, StudentRepository studentRepository, Course course) {
        Student student = new Student(name, lastName, Integer.parseInt(age), email, course);
        studentRepository.save(student);
    }

    @Override
    public void addNewCourse(String courseName, CourseRepository courseRepository) {
        Course course = new Course(courseName);
        courseRepository.save(course);
    }
}
