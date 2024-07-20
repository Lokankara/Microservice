package com.stack.kafka.provider;

import com.stack.common.model.AirPort;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@Component
@ConfigurationProperties(prefix = "application")
public class AirPortProvider {

    private final List<AirPort> ports = new ArrayList<>();

}
