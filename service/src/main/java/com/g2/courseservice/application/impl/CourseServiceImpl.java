package com.g2.courseservice.application.impl;

import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.application.CourseService;
import com.g2.courseservice.domain.Course;
import com.g2.courseservice.domain.CourseOccasion;
import com.g2.courseservice.infrastructure.db.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    @Override
    public Course create(CourseRequest request) {
        try{
            val course = Course.builder().courseCode(request.getCourseCode()).name(request.getName()).build();
            return repository.save(course);

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Course findFromCourseCode(String courseCode) {
        return repository.findOneByCourseCode(courseCode);
    }

    @Override
    public List<Course> getAll(){
        return repository.findAll();
    }

}
