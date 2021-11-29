package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.Review;

public interface CourseService {

    void delete(int id);

    String addReviewToCourse(int id, Review review);

    String addStudentToCourse(int studentId, int courseId);

}
