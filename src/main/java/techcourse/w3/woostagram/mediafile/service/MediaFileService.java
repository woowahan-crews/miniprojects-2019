package techcourse.w3.woostagram.mediafile.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import techcourse.w3.woostagram.mediafile.MediaFile;
import techcourse.w3.woostagram.mediafile.domain.MediaFileRepository;

@Service
public class MediaFileService {
    private final MediaFileRepository mediaFileRepository;

    public MediaFileService(final MediaFileRepository mediaFileRepository) {
        this.mediaFileRepository = mediaFileRepository;
    }

    public MediaFile saveFile(MultipartFile multipartFile) throws Exception{
        MediaFile mediaFile = new MediaFile(multipartFile.getContentType(), multipartFile.getBytes());
        return mediaFileRepository.save(mediaFile);
    }

    public MediaFile getFile(Long fileId){
        return mediaFileRepository.findById(fileId)
                .orElseThrow(RuntimeException::new);
    }
}
