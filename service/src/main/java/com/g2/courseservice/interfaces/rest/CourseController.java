package com.g2.courseservice.interfaces.rest;

import com.g2.courseservice.api.rest.UrlPaths;
import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.courseinstance.CourseOccasionResponse;
import com.g2.courseservice.application.CourseService;
import com.g2.courseservice.domain.DomainObjectMapper;
import com.g2.courseservice.infrastructure.db.CourseOccasionRepository;
import com.g2.courseservice.infrastructure.generator.TestDataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    private final CourseOccasionRepository courseOccasionRepository;

    @Autowired
    private final TestDataGenerator testDataGenerator;


    @GetMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<List<CourseResponse>> getAllCourses(){
        val courses = service.getAll().stream()
                .map(course -> DomainObjectMapper.toCourseResponse(course))
                .collect(Collectors.toList());
        //return ResponseEntity.ok(ListCourseResponse.builder().courses(courses).build());
        return ResponseEntity.ok(courses);
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

    @GetMapping(UrlPaths.COURSE_INSTANCES)
    ResponseEntity<List<CourseOccasionResponse>> findCourseOccasionsByCourseCode(
            @RequestParam(value = "course_code", required = false) String courseCode
    ) {
        if (courseCode == null) {
            val courseOccasions = courseOccasionRepository.findAll().stream()
                    .map(occasion -> DomainObjectMapper.toCourseInstanceResponse(occasion))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(courseOccasions);
        } else {
            val course = service.findFromCourseCode(courseCode);
            val courseOccasions = courseOccasionRepository.findByCourse(course).stream()
                    .map(occasion -> DomainObjectMapper.toCourseInstanceResponse(occasion))
                    .collect(Collectors.toList());
            /*val courseOccasions =  courseOccasionRepository.findCourseOccasionsByCourseCourseCode(courseCode).stream()
                .map(occasion -> DomainObjectMapper.toCourseInstanceResponse(occasion))
                .collect(Collectors.toList());*/
            return ResponseEntity.ok(courseOccasions);
        }
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
