package com.stack.automation.company.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ValidEmailProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of("verylongemail@google-one.com"),
                Arguments.of("verylongemail@subgoogle.google-with-hyphen.com"),
                Arguments.of("verylongemail@i.ua"),
                Arguments.of("123.email@0372.ua"),
                Arguments.of("google@google.com"),
                Arguments.of("123longemail@google.com"),
                Arguments.of("verylong.email@google.com"),
                Arguments.of("verylongemail@google.name"),
                Arguments.of("123.email@google.name"),
                Arguments.of("email.email.email@google.name"),
                Arguments.of("1234567890ABCDEF@host.com"),
                Arguments.of("verylongemail@google.co.jp"),
                Arguments.of("verylong.123@google.ua.com"),
                Arguments.of("verylongemail@google.museum"),
                Arguments.of("verylong.email@google.travel"),
                Arguments.of("verylongemail@google.museum"),
                Arguments.of("validemail@google.com"),
                Arguments.of("valid.email123@google.com"),
                Arguments.of("verylongemail@subgoogle.google.com"),
                Arguments.of("user123@subgoogle.google.com"),
                Arguments.of("firstname.lastname@google.com"),
                Arguments.of("another.valid.email@google.co.uk"),
                Arguments.of("email.email.email.email.emails@google.name"),
                // Valid emails
                Arguments.of("valid.email@google.com"),
                Arguments.of("john.doe123@google.co.uk"),
                Arguments.of("user12345@google.com"),
                Arguments.of("user.name123@google.com"),
                Arguments.of("user.name123@google.co.uk"),
                Arguments.of("user.name.123@google.co.uk"),
                Arguments.of("username@google.com"),
                Arguments.of("username@google.co.uk"),
                Arguments.of("user.name@google.com"),
                Arguments.of("user.name@google.co.uk"),
                Arguments.of("user.name.123@google.co.uk"),
                Arguments.of("user123@google.co.uk"),
                Arguments.of("user.name.123@google.com"),
                Arguments.of("user.name.123@google.com"),
                Arguments.of("user123@google.com"),
                Arguments.of("verylongemail@verylonggooglenamewithmorethan255characters.com")
        );
    }
}
