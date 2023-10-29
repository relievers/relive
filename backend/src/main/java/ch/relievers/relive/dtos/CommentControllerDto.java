package ch.relievers.relive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CommentControllerDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateCommentRequest {
        private String content;
        private Integer mediaId;
        private Integer userId;
    }

}
