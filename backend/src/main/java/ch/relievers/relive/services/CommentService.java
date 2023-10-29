package ch.relievers.relive.services;

import ch.relievers.relive.dtos.CommentControllerDto;
import ch.relievers.relive.entities.Comment;
import ch.relievers.relive.entities.MediaItem;
import ch.relievers.relive.entities.User;
import ch.relievers.relive.repositories.CommentRepository;
import ch.relievers.relive.repositories.MediaItemRepository;
import ch.relievers.relive.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private UserRepository userRepository;
    private MediaItemRepository mediaItemRepository;
    private CommentRepository commentRepository;

    @Transactional
    public Comment createComment(CommentControllerDto.CreateCommentRequest commentRequest) {
        User owner = userRepository.findById(commentRequest.getUserId()).orElseThrow();
        MediaItem mediaItem = mediaItemRepository
                .findById(commentRequest.getMediaId()).orElseThrow();
        Comment comment = new Comment(
                mediaItem,
                owner,
                commentRequest.getContent(),
                LocalDateTime.now()
        );
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForMediaItem(Integer mediaId) {
        return commentRepository.findAllByMediaItemId(mediaId);
    }
}
