package com.example.springdataexclusive.controller;

import com.example.springdataexclusive.service.InstructorDetailService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InstructorDetailController {

    private InstructorDetailService instructorDetailService;

    public InstructorDetailController(InstructorDetailService instructorDetailService) {
        this.instructorDetailService = instructorDetailService;
    }

    @DeleteMapping("/instructor-detail/{id}")
    public String deleteInstructorDetail(@PathVariable int id){
        instructorDetailService.delete(id);
        return "Deleted instructor detail id - " + id;

    }


}
