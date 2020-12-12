package com.g2.courseservice.domain;

import com.g2.courseservice.api.rest.course.Location;
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

    @ManyToMany
    @JoinTable(
            name = "courseInstance_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_instance_id"))
    private List<Teacher> teachers;
}
