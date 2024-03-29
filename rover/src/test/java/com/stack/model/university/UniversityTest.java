package com.stack.model.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UniversityTest {

    private Teacher teacher;
    private Student student1;
    private Student student2;
    private Course mqcCourse;
    private Course atqcCourse;
    private Course javaCourse;
    private final List<Mark> marks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<String> topics = Arrays.asList("Introduction to Java", "OOP", "Data Structures");
        student1 = new Student("Petrenko", "Ostap", 19);
        student2 = new Student("Romaniv", "Maryna", 21);
        javaCourse = new Course("Java", "CS101", topics);
        mqcCourse = new Course("MQC", "CS102", topics);
        atqcCourse = new Course("ATQC", "CS103", topics);
        List<Course> coursesTaught = new ArrayList<>();
        coursesTaught.add(mqcCourse);
        coursesTaught.add(javaCourse);
        teacher = new Teacher(coursesTaught);
    }

    @Test
    @DisplayName("Given a student enrolls in multiple courses, when enrolling, then student is enrolled in each course")
    void testEnrollStudentToCourse() {
        student1.enrollToCourse(javaCourse);
        student1.enrollToCourse(mqcCourse);
        student2.enrollToCourse(javaCourse);
        student2.enrollToCourse(atqcCourse);

        assertTrue(student1.getCourses().contains(javaCourse));
        assertTrue(student1.getCourses().contains(mqcCourse));
        assertTrue(student2.getCourses().contains(javaCourse));
        assertTrue(student2.getCourses().contains(atqcCourse));
    }


    @Test
    void testAssignMarkAndUpdateExistingMark() {
        Mark existingMark = new Mark(student1, 80, "OOP");
        student1.addMark(existingMark);

        Mark assignedMark = teacher.assignMark(student1, 90, "OOP");

        assertNotNull(assignedMark);
        assertEquals(90, existingMark.getScore());
        assertEquals(existingMark, assignedMark);
    }

    @Test
    void testAssignMarkAndCreateNewMark() {
        Mark assignedMark = teacher.assignMark(student1, 85, "Data Structures");

        assertNotNull(assignedMark);
        assertEquals(85, assignedMark.getScore());
        assertEquals("Data Structures", assignedMark.getTopic());
        assertTrue(student1.getMarks().contains(assignedMark));
    }

    @Test
    void testNotAssignMarkForInvalidTopic() {
        assertThrows(IllegalArgumentException.class,
                     () -> teacher.assignMark(student1, 90, "Algebra"),
                     "Topic not found in courses taught by the teacher");
    }

    @Test
    @DisplayName("Given a student enrolls in a course, when enrolling, then student is enrolled in the course")
    void testEnrollToCourse() {
        student1.enrollToCourse(javaCourse);
        student2.enrollToCourse(javaCourse);

        assertTrue(student1.getCourses().contains(javaCourse));
        assertTrue(student2.getCourses().contains(javaCourse));
    }

    @Test
    @DisplayName("Ensure average is 0.0 when the marks list is empty")
    void testCalculateAverageMarksEmptyList() {

        double average = student1.calculateAverageMarks();

        assertEquals(0.0, average);
    }

    @Test
    @DisplayName("Add a single mark with a score of 80")
    void testCalculateAverageMarksSingleMark() {
        Mark mark = new Mark(null, 80, "");
        marks.add(mark);
        student1.addMarks(marks);

        double average = student1.calculateAverageMarks();

        assertEquals(80.0, average);
    }

    @Test
    @DisplayName("Add multiple marks with scores 70, 80, 90, Ensure average is correct (80)")
    void testCalculateAverageMarksMultipleMarks() {
        marks.add(new Mark(null, 70, ""));
        marks.add(new Mark(null, 80, ""));
        marks.add(new Mark(null, 90, ""));
        student1.addMarks(marks);

        double average = student1.calculateAverageMarks();

        assertEquals(80.0, average);
    }

    @Test
    @DisplayName("Add multiple marks with scores 0, 0, 0, Ensure average is correct (0)")
    void testCalculateAverageMarksZeroScores() {
        marks.add(new Mark(null, 0, ""));
        marks.add(new Mark(null, 0, ""));
        marks.add(new Mark(null, 0, ""));

        double average = student1.calculateAverageMarks();

        assertEquals(0.0, average);
    }

    @Test
    @DisplayName("Given a student takes an exam, when passing the exam, then the student passes")
    void testPassExam() {
        student1.enrollToCourse(javaCourse);
        Mark passingMark = new Mark(student1, 70, "Java");

        student1.passExam(passingMark);

        assertTrue(student1.hasPassedExam());
    }

    @Test
    @DisplayName("Given a student takes an exam, when failing the exam, then the student fails")
    void testFailExam() {
        student1.enrollToCourse(javaCourse);
        Mark failingMark = new Mark(student1, 45, "Java");

        student1.passExam(failingMark);

        assertFalse(student1.hasPassedExam());
    }
}
