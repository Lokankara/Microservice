package com.stack.common.messages;

import com.stack.common.model.Board;
import com.stack.common.model.Source;
import com.stack.common.model.Type;

public class BoardStateMessage extends Message {
    private Board board;

    public BoardStateMessage() {
        this.source = Source.BOARD;
        this.type = Type.STATE;
    }

    public BoardStateMessage(Board board) {
        this();
        this.board = board;
    }
}
