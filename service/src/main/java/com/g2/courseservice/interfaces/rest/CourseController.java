package com.g2.courseservice.interfaces.rest;

import com.g2.courseservice.api.rest.UrlPaths;
import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.course.ListCourseResponse;
import com.g2.courseservice.api.rest.courseinstance.CourseOccasionResponse;
import com.g2.courseservice.application.CourseService;
import com.g2.courseservice.domain.DomainObjectMapper;
import com.g2.courseservice.infrastructure.db.CourseOccasionRepository;
import com.g2.courseservice.infrastructure.generator.TestDataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    private final CourseOccasionRepository courseOccasionRepository;

    @Autowired
    private final TestDataGenerator testDataGenerator;


    @GetMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<ListCourseResponse> getAllCourses(){
        val courses = service.getAll().stream()
                .map(course -> DomainObjectMapper.toCourseResponse(course))
                .collect(Collectors.toList());
        return ResponseEntity.ok(ListCourseResponse.builder().courses(courses).build());
    }

    @GetMapping(UrlPaths.GET_COURSE)
    ResponseEntity<CourseResponse> findOneCourse(@PathVariable String courseCode){
        val course = service.findFromCourseCode(courseCode);
        return ResponseEntity.ok(DomainObjectMapper.toCourseResponse(course));
    }

    @GetMapping(UrlPaths.GET_COURSE_INSTANCE)
    ResponseEntity<CourseOccasionResponse> findOneCourseOccasion(@PathVariable long courseOccasionId){
        val courseOccasion = courseOccasionRepository.findById(courseOccasionId);
        return ResponseEntity.ok(DomainObjectMapper.toCourseInstanceResponse(courseOccasion.get()));
    }

    @PostMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest){
        val course = service.create(courseRequest);
        return ResponseEntity.ok(DomainObjectMapper.toCourseResponse(course));
    }

    @PostMapping(UrlPaths.BASE_URI+"/test")
    ResponseEntity<Void> createTestCourses(){
        testDataGenerator.generate();
        return ResponseEntity.accepted().build();
    }

}
