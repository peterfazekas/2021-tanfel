package hu.course.controller;

import hu.course.model.domain.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private final List<Course> courses;

    public CourseService(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * 2. feladat: Hány bejegyzés található az állományban?
     */
    public int getCourseCount() {
        return courses.size();
    }

}
