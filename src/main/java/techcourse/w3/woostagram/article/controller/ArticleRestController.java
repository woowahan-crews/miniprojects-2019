package techcourse.w3.woostagram.article.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techcourse.w3.woostagram.article.dto.ArticleDto;
import techcourse.w3.woostagram.article.service.ArticleService;
import techcourse.w3.woostagram.common.support.LoggedInUser;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> list(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.findById(articleId));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody ArticleDto articleDto, @LoggedInUser String email) {
        articleService.update(articleDto, email);
        return ResponseEntity.ok().build();
    }
}