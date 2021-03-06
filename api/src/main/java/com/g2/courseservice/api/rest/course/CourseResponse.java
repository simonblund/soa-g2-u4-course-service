package com.g2.courseservice.api.rest.course;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.g2.courseservice.api.rest.courseinstance.CourseOccasionResponse;
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
public class CourseResponse {
    private long courseId;
    private String name;
    private String courseCode;
    private double ects;
    private List<CourseOccasionResponse> courseInstances;
}
