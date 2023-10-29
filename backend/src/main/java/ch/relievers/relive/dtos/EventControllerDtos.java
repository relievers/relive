package ch.relievers.relive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class EventControllerDtos {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateEventRequest {
        private String displayName;
        private String description;
        private LocalDateTime startDateTime;
        private Integer duration;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReLivePostItem {

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Comment {
            private int commentId;
            private int authorId;
            private String authorName;
            private LocalDateTime dateTime;
            private String content;
        }

        private int mediaItemId;
        private LocalDateTime dateTime;
        private String imageHash;
        private String creatorName;
        private List<Comment> comments;
    }
}
