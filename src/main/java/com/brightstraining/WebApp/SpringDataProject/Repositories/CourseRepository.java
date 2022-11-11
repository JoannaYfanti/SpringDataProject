package com.brightstraining.WebApp.SpringDataProject.Repositories;

import com.brightstraining.WebApp.SpringDataProject.Entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findCourseById(Long id);
}
