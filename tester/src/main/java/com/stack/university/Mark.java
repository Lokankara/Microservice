package com.stack.university;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Mark {
    private Student student;
    private String topic;
    private double score;

    public Mark(
            Student student,
            double score,
            String topic) {
        this.student = student;
        this.score = score;
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Double.compare(score, mark.score) == 0
                && Objects.equals(student, mark.student)
                && Objects.equals(topic, mark.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, score, topic);
    }

    @Override
    public String toString() {
        return String.format(
                "Mark{student=%s, score=%s, topic='%s'}",
                student, score, topic);
    }
}
