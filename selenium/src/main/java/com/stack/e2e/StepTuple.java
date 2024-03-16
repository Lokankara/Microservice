package com.stack.e2e;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.Objects;

@Getter
public class StepTuple {
    private final By by;

    private final StepExecution step;

    public StepTuple(
            By by,
            StepExecution step) {
        this.by = by;
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepTuple stepTuple = (StepTuple) o;
        return Objects.equals(by, stepTuple.by) && step == stepTuple.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(by, step);
    }
}
