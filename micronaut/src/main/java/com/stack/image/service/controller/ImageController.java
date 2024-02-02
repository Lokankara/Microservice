package com.stack.image.service.controller;

import com.image.service.model.ImageFilter;
import com.image.service.model.PagedData;
import com.image.service.model.Thumbnail;
import com.image.service.service.ImageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import java.util.List;

@Controller("/images")
@Validated
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Get("/{?filter}")
    public PagedData<Thumbnail> getThumbnails(@Valid @QueryValue ImageFilter filter) {
        return imageService.findThumbnails(filter);
    }

    @Post(value = "/duplicates", consumes = MediaType.MULTIPART_FORM_DATA)
    public List<String> findDuplicates(CompletedFileUpload file) {
        return imageService.findDuplicatePaths(file);
    }

    @Post(value = "/metadata", consumes = MediaType.MULTIPART_FORM_DATA)
    public void processImageMetadata(CompletedFileUpload file) {
        imageService.loadMetadata(file);
    }
}
