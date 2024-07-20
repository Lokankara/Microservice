package com.stack.common.messages;

import com.stack.common.model.Source;
import com.stack.common.model.Type;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Message {
    protected Type type;
    protected Source source;

    public String getCode() {
        return source.name() + "_" + type.name();
    }
}
