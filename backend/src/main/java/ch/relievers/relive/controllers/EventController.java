package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
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
    public List<EventControllerDtos.GenericEventResponse> getEvents(Principal principal) {
        List<Event> events = eventService.getAllEventsOfUser(Integer.valueOf(principal.getName()));
        List<EventControllerDtos.GenericEventResponse> response = new ArrayList<>();
        for(Event event : events) {
            response.add(convertDto(event));
        }
        return response;
    }

    @PostMapping("/")
    public EventControllerDtos.GenericEventResponse createEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            Principal principal) {
        Event newEvent = eventService.createEvent(eventRequest, Integer.valueOf(principal.getName()));
        return convertDto(newEvent);
    }

    @PutMapping("/{id}")
    public EventControllerDtos.GenericEventResponse updateEvent(
            @RequestBody EventControllerDtos.CreateEventRequest eventRequest,
            @PathVariable Integer id,
            Principal principal) {
        Event newEvent = eventService.updateEvent(eventRequest, id);
        return convertDto(newEvent);
    }

    @PostMapping("/{id}/participations")
    public void participateEvent(@PathVariable Integer id, Principal principal) {
        eventService.participateEvent(id, Integer.valueOf(principal.getName()));
    }


    private EventControllerDtos.GenericEventResponse convertDto(Event event) {
        EventControllerDtos.EventState state = eventService.calcEventState(event);
        return new EventControllerDtos.GenericEventResponse(
                event.getDisplayName(),
                event.getDescription(),
                event.getStartDateTime(),
                event.getDuration(),
                state
        );
    }
}
