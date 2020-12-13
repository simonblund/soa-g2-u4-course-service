package com.g2.courseservice.interfaces.rest;

import com.g2.courseservice.api.rest.UrlPaths;
import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.course.ListCourseResponse;
import com.g2.courseservice.application.CourseService;
import com.g2.courseservice.domain.DomainObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;


    @GetMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<ListCourseResponse> getAllCourses(){
        val courses = service.getAll().stream()
                .map(course -> DomainObjectMapper.toCourseResponse(course))
                .collect(Collectors.toList());
        return ResponseEntity.ok(ListCourseResponse.builder().courses(courses).build());
    }
}
