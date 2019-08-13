package techcourse.w3.woostagram.article.assembler;

import techcourse.w3.woostagram.article.domain.Article;
import techcourse.w3.woostagram.article.dto.ArticleDto;
import techcourse.w3.woostagram.mediafile.domain.MediaFile;

public class ArticleAssembler {
    public static Article toArticle(ArticleDto articleDto) throws Exception{
        return Article.builder()
                .contents(articleDto.getContents())
                .mediaFile(new MediaFile(articleDto.getImage()))
                .build();
    }

//    public static ArticleDto toArticleDto(Article article) {
//        return ArticleDto.builder()
//                .contents(article.getContents())
//                .image()
//                .build();
//    }
}
