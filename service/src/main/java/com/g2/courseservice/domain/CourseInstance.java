package com.g2.courseservice.domain;

import com.g2.courseservice.api.rest.course.Location;
import com.g2.courseservice.api.rest.course.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseInstanceId;

    @ManyToOne
    private Course course;

    private Location location;
    private int year;

    @ElementCollection(targetClass = Period.class)
    @JoinTable(name = "tblInstancePeriods", joinColumns = @JoinColumn(name = "courseInstanceId"))
    @Enumerated(EnumType.STRING)
    private List<Period> periods;

    @ManyToMany
    private List<Teacher> teachers;
}
