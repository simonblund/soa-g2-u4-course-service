package com.g2.courseservice.api.rest.courseinstance;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.g2.courseservice.api.rest.course.Location;
import com.g2.courseservice.api.rest.course.Period;
import com.g2.courseservice.api.rest.teacher.TeacherResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseInstanceResponse {
    private long courseInstanceId;
    private String courseCode;
    private Location location;
    private int year;
    private List<Period> periods;
    private List<TeacherResponse> teachers;

}
