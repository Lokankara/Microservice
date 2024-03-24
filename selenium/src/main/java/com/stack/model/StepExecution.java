package com.stack.model;

import com.stack.model.action.AttributeAction;
import com.stack.model.action.ClickAction;
import com.stack.model.action.SendKeyAction;
import com.stack.model.action.SleepAction;
import com.stack.model.action.StepAction;
import com.stack.model.action.TextAction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Queue;

@Getter
@AllArgsConstructor
public enum StepExecution {
    CLICK(new ClickAction()),
    SEND(new SendKeyAction()),
    SLEEP(new SleepAction()),
    TEXT(new TextAction()),
    ATTRIBUTE(new AttributeAction());

    private final StepAction action;

    public static String execute(
            StepTuple tuple) {
        return getStepAction(tuple.step())
                .execute(tuple.element(), tuple.value());
    }

    private static StepAction getStepAction(
            StepExecution step) {
        return switch (step) {
            case TEXT -> new TextAction();
            case CLICK -> new ClickAction();
            case SLEEP -> new SleepAction();
            case SEND -> new SendKeyAction();
            case ATTRIBUTE -> new AttributeAction();
        };
    }

    public static void executeScenario(
            Queue<StepTuple> tuples) {
        while (!tuples.isEmpty()) {
            StepExecution.execute(tuples.poll());
        }
    }
}
