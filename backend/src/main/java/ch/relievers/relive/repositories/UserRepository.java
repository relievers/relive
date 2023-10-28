package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
