package techcourse.w3.woostagram.mediafile.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class MediaFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fileType;

    @Column
    @Lob
    private byte[] data;

    public MediaFile(final MultipartFile multipartFile) throws Exception {
        this.fileType = multipartFile.getContentType();
        this.data = multipartFile.getBytes();
    }
}
