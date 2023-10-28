package ch.relievers.relive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MediaItemDtos {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateRequest {
        private LocalDateTime dateTime;
        private String imgDataBase64;
        private int eventId;
        private int creatorId;
    }
}
