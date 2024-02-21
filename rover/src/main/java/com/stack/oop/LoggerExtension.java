package com.stack.oop;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LoggerExtension
        implements BeforeEachCallback, AfterEachCallback {

    private final ListAppender<ILoggingEvent> appender = new ListAppender<>();
    private final Logger logger = (Logger) LoggerFactory.getLogger("ROOT");

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        appender.stop();
        appender.list.clear();
        logger.detachAppender(appender);
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        logger.addAppender(appender);
        appender.start();
    }

    public List<String> getFormattedMessages() {
        return appender.list.stream()
                            .map(ILoggingEvent::getFormattedMessage)
                            .toList();
    }
}
