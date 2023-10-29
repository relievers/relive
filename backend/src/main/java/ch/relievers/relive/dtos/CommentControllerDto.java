package ch.relievers.relive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class CommentControllerDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCommentRequest {
        private String content;
        private Integer mediaId;
        private Integer userId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCommentResponse {
        private int commentId;
        private String content;
        private String authorName;
        private LocalDateTime dateTime;
    }

}
