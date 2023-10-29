package ch.relievers.relive.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
}
