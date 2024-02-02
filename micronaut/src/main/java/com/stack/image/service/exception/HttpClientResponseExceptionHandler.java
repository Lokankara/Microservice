package com.stack.image.service.exception;

import io.micronaut.core.exceptions.ExceptionHandler;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import jakarta.inject.Singleton;

@Produces
@Singleton
public class HttpClientResponseExceptionHandler{}
//        implements ExceptionHandler<HttpClientResponseException, HttpResponse> {
//    @Override
//    public HttpResponse handle(HttpRequest request,
//            HttpClientResponseException exception) {
//        return HttpResponse.badRequest(exception.getLocalizedMessage());
//    }
//
//    @Override
//    public void handle(HttpClientResponseException exception) {
//
//    }
//}
