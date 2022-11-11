package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseRepository getRepository() {
        return courseRepository;
    }
}
