package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.EventControllerDtos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping("/ping")
    public EventControllerDtos.PingResponse pingPong() {
        return new EventControllerDtos.PingResponse();
    }
}
