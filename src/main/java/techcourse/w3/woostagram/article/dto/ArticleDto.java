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
    private MultipartFile image;
    private String contents;

    @Builder
    public ArticleDto(final MultipartFile image, final String contents) {
        this.image = image;
        this.contents = contents;
    }
}
