package com.g2.courseservice.infrastructure.generator;

import com.g2.courseservice.api.rest.course.Location;
import com.g2.courseservice.api.rest.course.Period;
import com.g2.courseservice.domain.Course;
import com.g2.courseservice.domain.CourseOccasion;
import com.g2.courseservice.domain.Teacher;
import com.g2.courseservice.infrastructure.db.CourseOccasionRepository;
import com.g2.courseservice.infrastructure.db.CourseRepository;
import com.g2.courseservice.infrastructure.db.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDataGenerator {

    private final TeacherRepository teacherRepository ;
    private final CourseRepository courseRepository;
    private final CourseOccasionRepository courseOccasionRepository;

    private List<Teacher> teachers = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();


    @PostConstruct
    public void generate(){
        generateTeachers();
        generateCourses();
        generateCourseOccasions();
    }

    private void generateTeachers(){
        Teacher teacher1 = Teacher.builder()
                .firstName("Martin")
                .lastName("Beck")
                .userName("marbec").build();

        Teacher teacher2 = Teacher.builder()
                .firstName("Gunvald")
                .lastName("Larsson")
                .userName("gunlar").build();

        Teacher teacher3 = Teacher.builder()
                .firstName("Inger")
                .lastName("Beck")
                .userName("ingbec").build();

        Teacher real1 = Teacher.builder()
                .firstName("Svante")
                .lastName("Edzen")
                .userName("svaedz").build();

        teachers.add(teacherRepository.save(teacher1));
        teachers.add(teacherRepository.save(teacher2));
        teachers.add(teacherRepository.save(teacher3));
        teachers.add(teacherRepository.save(real1));

    }

    private void generateCourses(){
        Course course1 = Course.builder()
                .courseCode("TC001")
                .name("Polisväsendet då och nu")
                .ects(7.5)
                .build();

        Course course2 = Course.builder()
                .courseCode("TC002")
                .name("Mordutredningar 1")
                .ects(7.5)
                .build();

        Course course3 = Course.builder()
                .courseCode("TC003")
                .name("TV-poliser genom tiderna")
                .ects(7.5)
                .build();

        Course realCourse1 = Course.builder()
                .courseCode("D0031N")
                .name("Enterprise Architecture och SOA")
                .ects(7.5)
                .build();

        courses.add(courseRepository.save(course1));
        courses.add(courseRepository.save(course2));
        courses.add(courseRepository.save(course3));
        courses.add(courseRepository.save(realCourse1));

    }

    private void generateCourseOccasions(){
        CourseOccasion occasion1 = CourseOccasion.builder()
                .course(courses.get(0))
                .teachers(teachers.subList(0,2))
                .location(Location.CAMPUS_KIRUNA)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion occasion2 = CourseOccasion.builder()
                .course(courses.get(0))
                .teachers(teachers.subList(0,2))
                .location(Location.DISTANCE)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion occasion3 = CourseOccasion.builder()
                .course(courses.get(1))
                .teachers(teachers.subList(1,3))
                .location(Location.DISTANCE)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion occasion4 = CourseOccasion.builder()
                .course(courses.get(1))
                .teachers(teachers.subList(1,3))
                .location(Location.CAMPUS_LULEA)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion occasion5 = CourseOccasion.builder()
                .course(courses.get(2))
                .teachers(teachers.subList(1,3))
                .location(Location.CAMPUS_LULEA)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion occasion6 = CourseOccasion.builder()
                .course(courses.get(2))
                .teachers(teachers.subList(1,3))
                .location(Location.DISTANCE)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        CourseOccasion realOccasion7 = CourseOccasion.builder()
                .course(courses.get(3))
                .teachers(teachers.subList(2,3))
                .location(Location.DISTANCE)
                .timeEditObjectId(132867)
                .year(2021)
                .periods(List.of(Period.P3, Period.P4))
                .build();

        courseOccasionRepository.save(occasion1);
        courseOccasionRepository.save(occasion2);
        courseOccasionRepository.save(occasion3);
        courseOccasionRepository.save(occasion4);
        courseOccasionRepository.save(occasion5);
        courseOccasionRepository.save(occasion6);
        courseOccasionRepository.save(realOccasion7);
    }


}
