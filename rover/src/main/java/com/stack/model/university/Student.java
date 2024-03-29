package com.stack.model.university;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Student extends Person {
    private static int count = 0;
    private boolean passedExam;
    private final List<Mark> marks;
    private final List<Course> courses;

    public Student() {
        this.marks = new ArrayList<>();
        this.courses = new ArrayList<>();
        increase();
    }

    void increase(){
        count++;
    }

    public Student(
            String lastName,
            String firstName,
            int age) {
        super.setAge(age);
        super.setLastName(lastName);
        super.setFirstName(firstName);
        this.marks = new ArrayList<>();
        this.courses = new ArrayList<>();
        increase();
    }

    public void enrollToCourse(Course course) {
        courses.add(course);
    }

    public void passExam(Mark mark) {
        this.passedExam = mark.getScore() >= 70;
    }

    public boolean hasPassedExam() {
        return passedExam;
    }

    public double calculateAverageMarks() {
        if (marks.isEmpty()) {
            return 0.0;
        } else {
            double sum = 0.0;
            for (Mark mark : marks) {
                sum += mark.getScore();
            }
            return sum / marks.size();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && passedExam == student.passedExam
                && Objects.equals(getLastName(), student.getLastName())
                && Objects.equals(getFirstName(), student.getFirstName())
                && Objects.equals(marks, student.marks)
                && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getLastName(), getFirstName(), getAge(),
                marks, passedExam, courses);
    }

    public void addMarks(List<Mark> marks) {
        this.marks.addAll(marks);
    }

    public void addMark(Mark mark) {
        this.marks.add(mark);
    }

    @Override
    public String toString() {
        return String.format(
                "Student{lastName='%s', firstName='%s', age=%d, marks=%s, passedExam=%s, courses=%s}",
                getLastName(), getFirstName(), getAge(),
                marks, passedExam, courses);
    }
}
