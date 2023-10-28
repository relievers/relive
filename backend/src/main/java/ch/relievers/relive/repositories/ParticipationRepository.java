package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.Participation;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ParticipationRepository extends CrudRepository<Participation, Integer> {

    Set<Participation> findAllByEventId(Integer eventId);

    Set<Participation> findAllByUserId(Integer userId);
}
