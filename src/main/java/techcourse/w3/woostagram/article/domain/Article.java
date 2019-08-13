package techcourse.w3.woostagram.article.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import techcourse.w3.woostagram.mediafile.domain.MediaFile;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String contents;

    @OneToOne
    @JoinColumn(name = "mediaFile", referencedColumnName = "id")
    private MediaFile mediaFile;

    @Builder
    public Article(final String contents, final MediaFile mediaFile) {
        this.contents = contents;
        this.mediaFile = mediaFile;
    }
}
