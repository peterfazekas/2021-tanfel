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

    /**
     * 3. feladat
     */
    public int getTotalLessonCount() {
        return courses.stream()
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    /**
     * 4. feladat
     */
    public int getTeacherWeeklyLesson(String name) {
        return courses.stream()
                .filter(course -> course.getTeacher().equals(name))
                .mapToInt(Course::getWeeklyLessonNumber)
                .sum();
    }

    /**
     * 5. feladat
     */
    public List<String> getMasterTeachers() {
        return courses.stream()
                .filter(course -> "osztalyfonoki".equals(course.getSubject()))
                .map(course -> String.format("%s - %s", course.getClassId(), course.getTeacher()))
                .collect(Collectors.toList());
    }

    /**
     * 6. feladat
     */
    public String getCourseStatus(String subject, String classId) {
        return getCertainCourseCount(subject, classId) == 1
                ? "Osztályszinten tanulják."
                : "Csoportbontásban tanulják.";
    }

    private long getCertainCourseCount(String subject, String classId) {
        return courses.stream()
                .filter(i -> i.getSubject().equals(subject) && i.getClassId().equals(classId))
                .count();
    }

    /**
     * 7. feladat
     */
    public long getTeacherCount() {
        return courses.stream()
                .map(Course::getTeacher)
                .distinct()
                .count();
    }
}
