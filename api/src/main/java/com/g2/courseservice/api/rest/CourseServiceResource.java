package com.g2.courseservice.api.rest;

import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.courseinstance.CourseOccasionResponse;
import com.g2.courseservice.api.rest.teacher.TeacherListResponse;
import com.g2.courseservice.api.rest.teacher.TeacherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CourseServiceResource {
    @GetMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<List<CourseResponse>> getAllCourses();

    @GetMapping(UrlPaths.GET_COURSE)
    ResponseEntity<CourseResponse> findOneCourse(@PathVariable String courseCode);

    @GetMapping(UrlPaths.GET_COURSE_INSTANCE)
    ResponseEntity<CourseOccasionResponse> findOneCourseOccasion(@PathVariable long courseOccasionId);

    @GetMapping(UrlPaths.COURSE_INSTANCES)
    ResponseEntity<List<CourseOccasionResponse>> findCourseOccasionsByCourseCode(
            @RequestParam(value = "course_code", required = false) String courseCode
    );

    @PostMapping(UrlPaths.COURSE_RESOURCE)
    ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest);

    @GetMapping(UrlPaths.GET_TEACHER)
    ResponseEntity<TeacherResponse> findOne(@PathVariable long teacherId);

    @GetMapping(UrlPaths.TEACHER_RESOURCE)
    ResponseEntity<TeacherListResponse> getAll();

}
