package com.g2.courseservice.infrastructure.db;

import com.g2.courseservice.domain.Course;
import com.g2.courseservice.domain.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
