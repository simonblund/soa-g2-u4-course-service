package com.g2.courseservice.domain;

import com.g2.courseservice.api.rest.course.CourseResponse;
import com.g2.courseservice.api.rest.courseinstance.CourseInstanceResponse;
import com.g2.courseservice.api.rest.teacher.TeacherResponse;
import lombok.val;

import java.util.stream.Collectors;

public class DomainObjectMapper {
    public static CourseResponse toCourseResponse(Course input){
        val instances = input.getCourseInstances().stream()
                .map(courseInstance -> toCourseInstanceResponse(courseInstance))
                .collect(Collectors.toList());
        return CourseResponse.builder()
                .courseId(input.getCourseId())
                .courseCode(input.getCourseCode())
                .ects(input.getEcts())
                .name(input.getCourseCode())
                .courseInstances(instances)
                .build();
    }

    public static TeacherResponse toTeacherResponse(Teacher input){
        return TeacherResponse.builder()
                .teacherId(input.getTeacherId())
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .userName(input.getUserName())
                .build();
    }

    public static CourseInstanceResponse toCourseInstanceResponse(CourseInstance input){
        val teachers = input.getTeachers().stream()
                .map(teacher -> toTeacherResponse(teacher))
                .collect(Collectors.toList());
        return CourseInstanceResponse.builder()
                .courseInstanceId(input.getCourseInstanceId())
                .courseCode(input.getCourse().getCourseCode())
                .location(input.getLocation())
                .year(input.getYear())
                .periods(input.getPeriods())
                .teachers(teachers)
                .build();
    }

}
