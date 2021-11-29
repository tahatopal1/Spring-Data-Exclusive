package com.example.springdataexclusive.controller;

import com.example.springdataexclusive.model.Review;
import com.example.springdataexclusive.service.CourseService;
import com.example.springdataexclusive.service.InstructorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;
    private InstructorService instructorService;

    public CourseController(CourseService courseService, InstructorService instructorService) {
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.delete(id);
        return "Course is deleted. Id: " + id;
    }

    @PostMapping("/course/{id}/review")
    public String addReviewToCourse(@PathVariable int id, @RequestBody Review review){
        return courseService.addReviewToCourse(id, review);
    }

    @PostMapping("/course/{course}/student/{student}")
    public String addStudentToCourse(@PathVariable int student,@PathVariable int course){
        return courseService.addStudentToCourse(student, course);
    }

}
