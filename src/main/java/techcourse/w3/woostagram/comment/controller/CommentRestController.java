package techcourse.w3.woostagram.comment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import techcourse.w3.woostagram.article.exception.RequestTooFastException;
import techcourse.w3.woostagram.comment.dto.CommentDto;
import techcourse.w3.woostagram.comment.service.CommentService;
import techcourse.w3.woostagram.common.support.LoggedInUser;
import techcourse.w3.woostagram.common.support.UserRateLimiter;

import java.util.List;

@RestController
@RequestMapping("/api/articles/{articleId}/comments")
public class CommentRestController {
    private final CommentService commentService;

    public CommentRestController(final CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentDto commentDto, @PathVariable Long articleId,
                                             @LoggedInUser String email) {
        return new ResponseEntity<>(commentService.save(commentDto, email, articleId), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> read(@PathVariable Long articleId, @LoggedInUser String email) {
        return ResponseEntity.ok(commentService.findByArticleId(articleId, email));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long commentId, @LoggedInUser String email) {
        commentService.deleteById(commentId, email);
        return ResponseEntity.ok().build();
    }
}
