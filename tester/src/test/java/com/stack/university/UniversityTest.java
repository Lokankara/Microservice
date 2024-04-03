package com.stack.university;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityTest {

    private Teacher teacher;
    private Student student1;
    private Student student2;
    private Course mqcCourse;
    private Course atqcCourse;
    private Course javaCourse;
    private final List<Mark> marks = new ArrayList<>();

    @BeforeMethod
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
    public void testEnrollStudentToCourse() {
        student1.enrollToCourse(javaCourse);
        student1.enrollToCourse(mqcCourse);
        student2.enrollToCourse(javaCourse);
        student2.enrollToCourse(atqcCourse);

        Assert.assertTrue(student1.getCourses().contains(javaCourse));
        Assert.assertTrue(student1.getCourses().contains(mqcCourse));
        Assert.assertTrue(student2.getCourses().contains(javaCourse));
        Assert.assertTrue(student2.getCourses().contains(atqcCourse));
    }

    @Test
    public void testAssignMarkAndUpdateExistingMark() {
        Mark existingMark = new Mark(student1, 80, "OOP");
        student1.addMark(existingMark);

        Mark assignedMark = teacher.assignMark(student1, 90, "OOP");

        Assert.assertNotNull(assignedMark);
        Assert.assertEquals(existingMark.getScore(), 90);
        Assert.assertEquals(existingMark, assignedMark);
    }

    @Test
    public void testAssignMarkAndCreateNewMark() {
        Mark assignedMark = teacher.assignMark(student1, 85, "Data Structures");

        Assert.assertNotNull(assignedMark);
        Assert.assertEquals(assignedMark.getScore(), 85);
        Assert.assertEquals(assignedMark.getTopic(), "Data Structures");
        Assert.assertTrue(student1.getMarks().contains(assignedMark));
    }

    @Test
    public void testEnrollToCourse() {
        student1.enrollToCourse(javaCourse);
        student2.enrollToCourse(javaCourse);

        Assert.assertTrue(student1.getCourses().contains(javaCourse));
        Assert.assertTrue(student2.getCourses().contains(javaCourse));
    }

    @Test
    public void testCalculateAverageMarksEmptyList() {
        double average = student1.calculateAverageMarks();
        Assert.assertEquals(average, 0.0);
    }

    @Test
    public void testCalculateAverageMarksSingleMark() {
        Mark mark = new Mark(null, 80, "");
        marks.add(mark);
        student1.addMarks(marks);

        double average = student1.calculateAverageMarks();

        Assert.assertEquals(average, 80.0);
    }

    @Test
    public void testCalculateAverageMarksMultipleMarks() {
        marks.add(new Mark(null, 70, ""));
        marks.add(new Mark(null, 80, ""));
        marks.add(new Mark(null, 90, ""));
        student1.addMarks(marks);

        double average = student1.calculateAverageMarks();

        Assert.assertEquals(average, 80.0);
    }

    @Test
    public void testCalculateAverageMarksZeroScores() {
        marks.add(new Mark(null, 0, ""));
        marks.add(new Mark(null, 0, ""));
        marks.add(new Mark(null, 0, ""));

        double average = student1.calculateAverageMarks();
        Assert.assertEquals(average, 0.0);
    }

    @Test
    public void testPassExam() {
        student1.enrollToCourse(javaCourse);
        Mark passingMark = new Mark(student1, 70, "Java");

        student1.passExam(passingMark);

        Assert.assertTrue(student1.hasPassedExam());
    }

    @Test
    public void testFailExam() {
        student1.enrollToCourse(javaCourse);
        Mark failingMark = new Mark(student1, 45, "Java");

        student1.passExam(failingMark);

        Assert.assertFalse(student1.hasPassedExam());
    }
}
