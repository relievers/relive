package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    List<Comment> findAllByMediaItemId(Integer eventId);
}
