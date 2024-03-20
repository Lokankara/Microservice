package com.stack.manager.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Locale;
import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {
    private static final String NOT_FOUND = "errors/404";

    private final MessageSource messageSource;

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNoSuchElementException(
            NoSuchElementException exception,
            HttpServletResponse response,
            Locale locale,
            Model model) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("error",
                           this.messageSource.getMessage(
                                   exception.getMessage(),
                                   new Object[0],
                                   exception.getMessage(),
                                   locale));
        return NOT_FOUND;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(NoHandlerFoundException e) {
        return NOT_FOUND;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String handleNoResourceFoundException(NoResourceFoundException e) {
        return NOT_FOUND;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return NOT_FOUND;
    }
}
