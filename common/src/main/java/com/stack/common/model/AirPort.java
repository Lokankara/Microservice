package com.stack.common.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AirPort {

    private String name;
    private List<String> boards = new ArrayList<>();
    private int x;
    private int y;

    private void addBoard(String boardName) {
        int i = boards.indexOf(boardName);
        if (i >= 0) {
            boards.set(i, boardName);
        } else {
            boards.add(boardName);
        }
    }

    private void removeBoard(String boardName) {
        boards.remove(boardName);
    }
}
