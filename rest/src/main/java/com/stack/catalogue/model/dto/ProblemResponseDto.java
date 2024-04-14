package com.stack.catalogue.model.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Stream;

public class ProblemResponseDto
        extends ProblemDetail implements BaseDto {

    public static ProblemResponseDto forStatusAndDetail(
            HttpStatus status, String message, List<ObjectError> errors) {
        ProblemResponseDto
                problemResponseDto = new ProblemResponseDto();
        Stream<String> stream = errors.stream().map(ObjectError::getDefaultMessage);
        problemResponseDto.setProperty("errors", stream);
        problemResponseDto.setStatus(status);
        problemResponseDto.setDetail(message);
        return problemResponseDto;
    }
}
