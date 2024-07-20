package com.stack.common.processor;

import com.stack.common.messages.Message;

public interface MessageProcessor<T extends Message> {

    void process(String jsonMessage);
}
