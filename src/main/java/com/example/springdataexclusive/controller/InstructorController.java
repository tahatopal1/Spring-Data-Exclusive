package com.example.springdataexclusive.controller;

import com.example.springdataexclusive.model.Course;
import com.example.springdataexclusive.model.Instructor;
import com.example.springdataexclusive.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/instructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        // This will also save InstructorDetail object
        // because of CascadeType.ALL
        instructorService.save(instructor);
        return instructor;
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructor(@PathVariable int id){
        return instructorService.findById(id);
    }

    @GetMapping("/instructor")
    public List<Instructor> getAllInstructor(){
        return instructorService.findAll();
    }

    @PutMapping("/instructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        instructorService.save(instructor);
        return instructor;
    }

    @DeleteMapping("/instructor/{id}")
    public String deleteInstructor(@PathVariable int id){
        instructorService.findById(id);
        instructorService.delete(id);
        return "Deleted instructor id - " + id;
    }

    @PostMapping("/instructor/{id}/course")
    public String assignCourseForInstructor(@PathVariable int id, @RequestBody Course course){
        instructorService.addCourseToInstructor(id, course);
        return "Assigning is successful!";
    }

    @GetMapping("/instructor/{id}/course")
    public List<Course> getCoursesForInstructor(@PathVariable int id){
        return instructorService.findById(id).getCourses();
    }


}
