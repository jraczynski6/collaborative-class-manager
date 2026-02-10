package com.example.collaborative_class_manager.controllers;

import com.example.collaborative_class_manager.model.Teacher;
import com.example.collaborative_class_manager.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable Integer id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Integer id,
                                 @RequestBody Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setFirstname(teacherDetails.getFirstname());
            teacher.setLastname(teacherDetails.getLastname());
            teacher.setSubject(teacherDetails.getSubject());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Integer id) {
        teacherRepository.deleteById(id);
    }


}
