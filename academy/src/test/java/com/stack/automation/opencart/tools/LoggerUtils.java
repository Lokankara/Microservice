package com.stack.automation.opencart.tools;

import com.stack.automation.opencart.pages.TopPart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerUtils {
    private static final Logger logger = LoggerFactory.getLogger(TopPart.class.getSimpleName());
    private static final String WARN = "⚠️ ";
    private static final String ERROR = "❌ ";
    private static final String FATAL = "❗ ";
    private static final String INFO = "✔️ ";

    public static void logInfo(String message) {
        logger.info(INFO + message);
    }

    public static void logWarning(String message) {
        logger.warn(WARN + message);
    }

    public static void logError(String message) {
        logger.error(ERROR + message);
    }

    public static void logTrace(String message) {
        logger.trace(FATAL + message);
    }
}
