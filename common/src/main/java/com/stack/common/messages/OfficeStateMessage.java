package com.stack.common.messages;

import com.stack.common.model.Source;
import com.stack.common.model.Type;

public class OfficeStateMessage extends Message {

    public OfficeStateMessage() {
        this.source = Source.OFFICE;
        this.type = Type.STATE;
    }
}
