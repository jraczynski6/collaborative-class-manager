package com.example.collaborative_class_manager.repository;

import com.example.collaborative_class_manager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
