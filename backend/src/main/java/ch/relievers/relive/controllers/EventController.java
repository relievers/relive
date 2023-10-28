package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/ping")
    public EventControllerDtos.PingResponse pingPong() {
        return new EventControllerDtos.PingResponse();
    }

    @PostMapping("/")
    public Event createEvent(@RequestBody EventControllerDtos.CreateEventRequest eventRequest) {
        return eventService.createEvent(eventRequest);
    }
}
