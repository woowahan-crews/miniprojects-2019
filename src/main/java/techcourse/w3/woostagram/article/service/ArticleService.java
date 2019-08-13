package techcourse.w3.woostagram.article.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import techcourse.w3.woostagram.article.assembler.ArticleAssembler;
import techcourse.w3.woostagram.article.domain.Article;
import techcourse.w3.woostagram.article.domain.ArticleRepository;
import techcourse.w3.woostagram.article.dto.ArticleDto;
import techcourse.w3.woostagram.mediafile.domain.MediaFile;
import techcourse.w3.woostagram.mediafile.service.MediaFileService;

@Service
@Transactional
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final MediaFileService mediaFileService;

    public ArticleService(final ArticleRepository articleRepository, final MediaFileService mediaFileService) {
        this.articleRepository = articleRepository;
        this.mediaFileService = mediaFileService;
    }

    public Article save(ArticleDto articleDto) throws Exception{
        MediaFile mediaFile = mediaFileService.saveFile(articleDto.getImage());
        return articleRepository.save(new Article(articleDto.getContents(), mediaFile));
    }
}
