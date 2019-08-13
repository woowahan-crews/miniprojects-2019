package techcourse.w3.woostagram.mediafile.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import techcourse.w3.woostagram.mediafile.MediaFile;

import java.io.File;
import java.io.FileInputStream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MediaFileRepositoryTest {
    @Autowired
    MediaFileRepository mediaFileRepository;

    @Test
    void findById_correctImage_true() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String path = classLoader.getResource("static/images/logo/instgram_logo.png").getFile();

        FileInputStream fileInputStream = new FileInputStream(new File(path));
        MultipartFile multipartFile = new MockMultipartFile("test.png", new FileInputStream(new File(path)));

        MediaFile mediaFile = new MediaFile(MediaType.IMAGE_PNG_VALUE, multipartFile.getBytes());
        mediaFileRepository.save(mediaFile);
        assertThat(mediaFileRepository.findById(1L).get().getData()).isEqualTo(multipartFile.getBytes());
    }
}