package com.g2.courseservice.infrastructure.db;

import com.g2.courseservice.domain.Course;
import com.g2.courseservice.domain.CourseOccasion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOccasionRepository extends CrudRepository<CourseOccasion, Long> {
    //List<CourseOccasion> findCourseOccasionsByCourseCourseCode(String courseCode);
    List<CourseOccasion> findByCourse(Course course);
}
