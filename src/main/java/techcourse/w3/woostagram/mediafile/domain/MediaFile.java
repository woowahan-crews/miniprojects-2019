package techcourse.w3.woostagram.mediafile;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode(of  ="id")
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

    public MediaFile(final String fileType, final byte[] data) {
        this.fileType = fileType;
        this.data = data;
    }
}
