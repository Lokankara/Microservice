package com.stack.image.service.service;

import com.stack.image.service.dao.ImageRepository;
import com.stack.image.service.model.ImageFilter;
import com.stack.image.service.model.PagedData;
import com.stack.image.service.model.Thumbnail;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.util.ArrayList;
import java.util.List;

public class ImageService {

    private final ImageRepository imageRepository;
    private final CommonDatabaseService commonDatabaseService;
    private final ThumbnailService thumbnailService;

    public List<String> findDuplicatePaths(CompletedFileUpload file) {
        return new ArrayList<>();
    }

    public void loadMetadata(CompletedFileUpload file) {
    }

    public ImageService(
            ImageRepository imageRepository,
            CommonDatabaseService commonDatabaseService,
            ThumbnailService thumbnailService) {
        this.imageRepository = imageRepository;
        this.commonDatabaseService = commonDatabaseService;
        this.thumbnailService = thumbnailService;
    }

    public PagedData<Thumbnail> findThumbnails(ImageFilter filter) {
        PagedData<Thumbnail> result = new PagedData<>();

//        Pageable pageInfo = Pageable.from(filter.getPage(), filter.getSize(),
//                commonDatabaseService.getCustomFilterSpecification(filter));
//
//        Page<ImageEntity> page = imageRepository.findAll(
//                commonDatabaseService.getCustomFilterSpecification(filter),
//                pageInfo);
//
//        result.setTotalPages(page.getTotalPages());
//
//        result.setContent(page.getContent().stream().map(imageEntity -> {
//            ThumbnailEntity thumbnailEntity = imageEntity.getThumbnailEntity();
//            if (Objects.nonNull(thumbnailEntity)) {
//                return thumbnailService.convertEntityToModel(thumbnailEntity);
//            }
//            return null;
//        }).filter(Objects::nonNull).collect(Collectors.toList()));

        return result;
    }
}
