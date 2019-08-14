package techcourse.w3.woostagram.article.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDto {
    private Long mediaFileId;
    private MultipartFile image;
    private String contents;

    @Builder
    public ArticleDto(final Long mediaFileId, final MultipartFile image, final String contents) {
        this.mediaFileId = mediaFileId;
        this.image = image;
        this.contents = contents;
    }
}
