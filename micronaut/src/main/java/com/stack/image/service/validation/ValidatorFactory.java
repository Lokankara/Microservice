package com.stack.image.service.validation;

import com.stack.image.service.model.ImageFilter;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;

import javax.validation.ConstraintValidator;

@Factory
public class ValidatorFactory {

//    @Singleton
//    @Replaces(ConstraintValidator.class)
//    ConstraintValidator<ConsistentSearch, ImageFilter> consistentSearchValidator() {
//        return (value, annotationMetadata, context) ->
//                !(StringUtils.isEmpty(value.getFormat())
//                        && StringUtils.isEmpty(value.getName())
//                        && StringUtils.isEmpty(value.getAlternativeText())
//                        && value.getWidth() == 0
//                        && value.getHeight() == 0);
//    }
//
//    @Singleton
//    @Replaces(ConstraintValidator.class)
//    ConstraintValidator<SortOrder, String> sortOrderValidator() {
//        return (value, annotationMetadata, context) ->
//                "asc".equalsIgnoreCase(value) || "desc".equalsIgnoreCase(value);
//    }
}
