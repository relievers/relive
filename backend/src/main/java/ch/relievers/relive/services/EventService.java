package ch.relievers.relive.services;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.repositories.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public Event createEvent(EventControllerDtos.CreateEventRequest eventRequest) {
        Event newEvent = new Event(
                eventRequest.getDisplayName(),
                eventRequest.getDescription(),
                eventRequest.getStartDateTime(),
                eventRequest.getDuration());
        return eventRepository.save(newEvent);
    }

    public EventControllerDtos.EventState calcEventState(Event event) {
        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(event.getStartDateTime())) return EventControllerDtos.EventState.PLANNED;
        if(now.isBefore(event.getStartDateTime().plusMinutes(event.getDuration()))) return EventControllerDtos.EventState.ONGOING;
        return EventControllerDtos.EventState.PAST;
    }
}
