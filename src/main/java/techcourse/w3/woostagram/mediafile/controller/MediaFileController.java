package techcourse.w3.woostagram.mediafile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techcourse.w3.woostagram.mediafile.MediaFile;
import techcourse.w3.woostagram.mediafile.service.MediaFileService;

@Slf4j
@RestController
@RequestMapping("/api/mediafiles")
public class MediaFileController {
    private final MediaFileService mediaFileService;

    public MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> show(@PathVariable Long id) {
        MediaFile mediaFile = mediaFileService.getFile(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaFile.getFileType()))
                .body(new ByteArrayResource(mediaFile.getData()));
    }
}
