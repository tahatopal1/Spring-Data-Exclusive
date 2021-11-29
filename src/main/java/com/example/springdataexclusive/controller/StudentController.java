package com.example.springdataexclusive.controller;

import com.example.springdataexclusive.model.Student;
import com.example.springdataexclusive.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findById(id);
    }


    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        student.setId(0);
        studentService.save(student);
        return student;
    }

    @PutMapping("/student")
    public Student updateEmployee(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.findById(id);
        studentService.delete(id);
        return "Deleted employee id - " + id;
    }
}
