package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.Event;
import ch.relievers.relive.entities.MediaItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MediaItemRepository extends CrudRepository<MediaItem, Integer> {

    List<MediaItem> getAllByEvent(Event event);
}
