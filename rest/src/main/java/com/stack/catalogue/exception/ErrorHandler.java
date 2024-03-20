package com.stack.catalogue.exception;

import com.stack.catalogue.model.BaseDto;
import com.stack.catalogue.model.ProblemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@ControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(BindException.class)
    public ResponseEntity<BaseDto> handleBindException(BindException exception, Locale locale){
        return errorRequest(locale, messageSource, exception.getAllErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<BaseDto> handleNoSuchElementException(
            BindException exception, Locale locale){
        return errorRequest(locale, messageSource, exception.getAllErrors(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<BaseDto> errorRequest(
            Locale locale,
            MessageSource messageSource,
            List<ObjectError> allErrors,
            HttpStatus httpStatus) {
        return ResponseEntity.badRequest().body(
                ProblemResponseDto.forStatusAndDetail(
                httpStatus, getMessage(locale, messageSource), allErrors));

    }

    private static String getMessage(
            Locale currentLocale,
            MessageSource messageSource) {
        return messageSource.getMessage(
                "errors.403.title", new Object[0],
                "errors.403.title", currentLocale);
    }
}
