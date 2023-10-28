package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    /*
    @GetMapping("/")
    public List<EventControllerDtos.GenericEventResponse> getEvents(Principal principal) {

    }*/

    @PostMapping("/")
    public EventControllerDtos.GenericEventResponse createEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            Principal principal) {
        Event newEvent = eventService.createEvent(eventRequest, Integer.valueOf(principal.getName()));
        EventControllerDtos.EventState state = eventService.calcEventState(newEvent);
        return new EventControllerDtos.GenericEventResponse(
                newEvent.getDisplayName(),
                newEvent.getDescription(),
                newEvent.getStartDateTime(),
                newEvent.getDuration(),
                state
        );
    }

    @PutMapping("/{id}")
    public EventControllerDtos.GenericEventResponse updateEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            @PathVariable Integer id,
            Principal principal) {
        Event newEvent = eventService.updateEvent(eventRequest, id);
        EventControllerDtos.EventState state = eventService.calcEventState(newEvent);
        return new EventControllerDtos.GenericEventResponse(
                newEvent.getDisplayName(),
                newEvent.getDescription(),
                newEvent.getStartDateTime(),
                newEvent.getDuration(),
                state
        );
    }

    @PostMapping("/{id}/participations")
    public void participateEvent(@PathVariable Integer id, Principal principal) {
        eventService.participateEvent(id, Integer.valueOf(principal.getName()));
    }
}
