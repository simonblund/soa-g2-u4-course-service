package com.g2.courseservice.infrastructure.db;

import com.g2.courseservice.domain.Course;
import com.g2.courseservice.domain.CourseOccasion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOccasionRepository extends CrudRepository<CourseOccasion, Long> {

}
