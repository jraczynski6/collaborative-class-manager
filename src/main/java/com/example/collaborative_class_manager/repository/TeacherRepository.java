package com.example.collaborative_class_manager.repository;

import com.example.collaborative_class_manager.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
