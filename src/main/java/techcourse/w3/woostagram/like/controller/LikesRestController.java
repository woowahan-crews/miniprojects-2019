package techcourse.w3.woostagram.like.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techcourse.w3.woostagram.common.support.LoggedInUser;
import techcourse.w3.woostagram.like.service.LikesService;
import techcourse.w3.woostagram.user.dto.UserInfoDto;

import java.util.List;

@RestController
@RequestMapping("/api/articles/{articleId}/likes")
public class LikesRestController {
    private final LikesService likesService;

    public LikesRestController(LikesService likesService) {
        this.likesService = likesService;
    }

    @PostMapping
    public ResponseEntity create(@PathVariable Long articleId, @LoggedInUser String email) {
        likesService.save(email, articleId);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserInfoDto>> listLikedUsers(@PathVariable Long articleId) {
        return ResponseEntity.ok(likesService.findLikedUserByArticleId(articleId));
    }

    @GetMapping("/num")
    public ResponseEntity<Integer> listNumberOfLiked(@PathVariable Long articleId) {
        return ResponseEntity.ok(likesService.findLikedUserByArticleId(articleId).size());
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long articleId, @LoggedInUser String email) {
        likesService.delete(articleId, email);
        return ResponseEntity.ok().build();
    }
}
