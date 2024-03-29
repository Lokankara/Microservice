package com.stack.model.university;

import java.util.List;

public class Teacher extends Person {
    private final List<Course> coursesTaught;

    public Teacher(List<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    protected Mark assignMark(Student student, double score, String topic) {
        for (Mark mark : student.getMarks()) {
            if (mark.getTopic().equals(topic)) {
                mark.setScore(score);
                return mark;
            }
        }

        for (Course course : coursesTaught) {
            if (course.topics().contains(topic)) {
                Mark newMark = new Mark(student, score, topic);
                student.addMark(newMark);
                return newMark;
            }
        }

        throw new IllegalArgumentException("Topic not found in courses taught by the teacher");
    }

}
