package com.g2.courseservice.interfaces.rest;

import com.g2.courseservice.api.rest.UrlPaths;
import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.application.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestCourseController {

    private final CourseService service;

    @PostMapping(UrlPaths.COURSE_RESOURCE)
    public ResponseEntity<Response> create(CourseRequest request){
        try {
            service.create(request);

            return ResponseEntity.status(200).build();
        }catch (Exception e){
            throw e;
        }
    }
}
