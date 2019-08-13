package techcourse.w3.woostagram.article.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import techcourse.w3.woostagram.article.dto.ArticleDto;

@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/form")
    public String createForm(){
        return "article-form";
    }

    @PostMapping
    public String create(ArticleDto articleDto) {
        log.info("articleDto is {}", articleDto.getImage());
        return "/";
    }
}
