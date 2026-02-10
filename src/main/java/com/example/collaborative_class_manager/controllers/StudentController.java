package com.example.collaborative_class_manager.controllers;

import com.example.collaborative_class_manager.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.collaborative_class_manager.repository.StudentRepository;

import java.util.List;

@RestController()
@RequestMapping("/students")
public class StudentController {

    @Autowired
    public StudentRepository studentRepository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {

            student.setFirstname(studentDetails.getFirstname());
            student.setLastname(studentDetails.getLastname());
            student.setSubject(studentDetails.getSubject());
            student.setGrade(studentDetails.getGrade());
            return studentRepository.save(student);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }

}
//GET /teachers - Get a list of all teachers
//● GET /teachers/{id} - Get a specific teacher by ID
//● POST /teachers - Create a new teacher
//● PUT /teachers/{id} - Update an existing teacher
//● DELETE /teachers/{id} - Delete a teacher by ID
//● GET /students - Get a list of all students
//● GET /students/{id} - Get a specific student by ID
//● POST /students - Create a new student
//● PUT /students/{id} - Update an existing student
//● DELETE /students/{id} - Delete a student by ID
