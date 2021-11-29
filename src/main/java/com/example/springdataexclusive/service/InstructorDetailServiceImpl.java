package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.InstructorDetail;
import com.example.springdataexclusive.repository.InstructorDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

    private InstructorDetailRepository instructorDetailRepository;

    public InstructorDetailServiceImpl(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    @Transactional
    public void delete(int id) {

        InstructorDetail instructorDetail = instructorDetailRepository.findById(id).get();

        // We break the bi-directional link in order to achieve removing
        instructorDetail.getInstructor().setInstructorDetail(null);
        instructorDetailRepository.delete(instructorDetail);
    }
}
