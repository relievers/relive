package ch.relievers.relive.repositories;

import ch.relievers.relive.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByName(String name);
}
