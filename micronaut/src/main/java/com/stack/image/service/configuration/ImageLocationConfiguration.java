package com.stack.image.service.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;

@Getter
@ConfigurationProperties("app.path")
public class ImageLocationConfiguration {

    private String imageFolder;
    private String thumbnailsBucket;
    private Integer batchSize;
    private Integer threadsCount;
    private String assetHost;
}
