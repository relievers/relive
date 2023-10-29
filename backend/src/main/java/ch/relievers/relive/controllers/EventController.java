package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.entities.Participation;
import ch.relievers.relive.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public List<Event> getEvents(Principal principal) {
        return eventService.getAllEventsOfUser(Integer.valueOf(principal.getName()));
    }

    @PostMapping("/")
    public Event createEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            Principal principal) {
        return eventService.createEvent(eventRequest, Integer.valueOf(principal.getName()));
    }

    @PutMapping("/{id}")
    public Event updateEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            @PathVariable Integer id,
            Principal principal) {
        return eventService.updateEvent(eventRequest, id);
    }

    @PostMapping("/{id}/participations")
    public Participation participateEvent(@PathVariable Integer id, Principal principal) {
        return eventService.participateEvent(id, Integer.valueOf(principal.getName()));
    }
}
