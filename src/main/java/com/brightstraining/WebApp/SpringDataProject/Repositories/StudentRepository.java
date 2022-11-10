package com.brightstraining.WebApp.SpringDataProject.Repositories;

import com.brightstraining.WebApp.SpringDataProject.Entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
