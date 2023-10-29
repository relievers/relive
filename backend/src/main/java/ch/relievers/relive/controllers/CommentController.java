package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.CommentControllerDto;
import ch.relievers.relive.entities.Comment;
import ch.relievers.relive.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/events/{event_id}/medias/{media_id}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/")
    public List<Comment> receiveCommentsForMediaItem(
            @PathVariable Integer media_id) {
        return commentService.getCommentsForMediaItem(media_id);
    }

    @PostMapping("/")
    public CommentControllerDto.CreateCommentResponse createNewComment(
            @RequestBody CommentControllerDto.CreateCommentRequest commentRequest,
            @PathVariable int media_id,
            Principal principal) {
        commentRequest.setUserId(Integer.valueOf(principal.getName()));
        commentRequest.setMediaId(media_id);
        return commentService.createComment(commentRequest);
    }
}
