package ch.relievers.relive.dtos;

import lombok.Data;

public class EventControllerDtos {

    @Data
    public static class PingResponse {
        private String ping = "pong";
    }
}
