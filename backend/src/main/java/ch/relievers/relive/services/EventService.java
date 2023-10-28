package ch.relievers.relive.services;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.repositories.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                eventRequest.getDuration(),
                Event.EventState.PLANNED);
        return eventRepository.save(newEvent);
    }

}
