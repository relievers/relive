package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.MediaItem;
import org.springframework.data.repository.CrudRepository;

public interface MediaItemRepository extends CrudRepository<MediaItem, Integer> {
}
