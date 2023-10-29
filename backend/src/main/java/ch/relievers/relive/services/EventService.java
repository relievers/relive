package ch.relievers.relive.services;

import ch.relievers.relive.dtos.EventControllerDtos;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.entities.Participation;
import ch.relievers.relive.entities.User;
import ch.relievers.relive.repositories.EventRepository;
import ch.relievers.relive.repositories.ParticipationRepository;
import ch.relievers.relive.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ParticipationRepository participationRepository;

    @Transactional
    public Event createEvent(EventControllerDtos.CreateEventRequest eventRequest, Integer ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(EntityNotFoundException::new);
        Event newEvent = new Event(
                eventRequest.getDisplayName(),
                eventRequest.getDescription(),
                eventRequest.getStartDateTime(),
                eventRequest.getDuration());
        newEvent.setOwner(owner);
        newEvent = eventRepository.save(newEvent);
        Participation participation = new Participation(owner, newEvent);
        participationRepository.save(participation);
        newEvent.setState(calcEventState(newEvent));
        return newEvent;
    }

    @Transactional
    public Event updateEvent(EventControllerDtos.CreateEventRequest eventRequest, Integer eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(EntityNotFoundException::new);
        if(eventRequest.getDisplayName() != null) event.setDisplayName(eventRequest.getDisplayName());
        if(eventRequest.getDescription() != null) event.setDescription(eventRequest.getDescription());
        if(eventRequest.getDuration() != null) event.setDuration(eventRequest.getDuration());
        if(eventRequest.getStartDateTime() != null) event.setStartDateTime(eventRequest.getStartDateTime());
        event = eventRepository.save(event);
        event.setState(calcEventState(event));
        return event;
    }

    @Transactional
    public Participation participateEvent(Integer eventId, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Event event = eventRepository.findById(eventId).orElseThrow(EntityNotFoundException::new);
        Participation participation = new Participation(user, event);
        return participationRepository.save(participation);
    }


    public List<Event> getAllEventsOfUser(Integer userId) {
        Set<Participation> participations = participationRepository.findAllByUserId(userId);
        List<Event> events = new ArrayList<>();
        for(Participation p : participations) {
            Event event = p.getEvent();
            event.setState(calcEventState(event));
            events.add(event);
        }
        return events;
    }

    public Event.EventState calcEventState(Event event) {
        LocalDateTime now = LocalDateTime.now();
        if(now.isBefore(event.getStartDateTime())) return Event.EventState.PLANNED;
        if(now.isBefore(event.getStartDateTime().plusMinutes(event.getDuration()))) return Event.EventState.ONGOING;
        return Event.EventState.PAST;
    }
}
