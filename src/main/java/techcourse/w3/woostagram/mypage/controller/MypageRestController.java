package techcourse.w3.woostagram.mypage.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techcourse.w3.woostagram.mypage.dto.MypageArticleDto;
import techcourse.w3.woostagram.mypage.service.MypageService;

@RestController
@RequestMapping("/api/mypage")
public class MypageRestController {
    private final MypageService mypageService;

    public MypageRestController(MypageService mypageService) {
        this.mypageService = mypageService;
    }

    @GetMapping
    public ResponseEntity<Page<MypageArticleDto>> read(Pageable pageable, String email){
        return ResponseEntity.ok(mypageService.getMypageArticles(email,pageable));
    }
}