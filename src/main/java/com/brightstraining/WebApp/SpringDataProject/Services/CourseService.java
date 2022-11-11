package com.brightstraining.WebApp.SpringDataProject.Services;

import com.brightstraining.WebApp.SpringDataProject.Repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    CourseRepository getRepository();
}
