package com.g2.courseservice.application;

import com.g2.courseservice.api.rest.course.CourseRequest;
import com.g2.courseservice.domain.Course;

public interface CourseService {
    Course create(CourseRequest course);
    Course findFromCourseCode(String courseCode);
}
