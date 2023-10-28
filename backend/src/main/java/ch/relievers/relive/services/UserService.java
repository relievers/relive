package ch.relievers.relive.services;

import ch.relievers.relive.entities.User;
import ch.relievers.relive.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserResponse;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public RequestAutoUserResponse createAutoUser(String name) {
        User newUser = new User(name, User.RegistrationState.AUTO_CREATED);
        User createdUser = userRepository.save(newUser);
        return new RequestAutoUserResponse(createdUser.getId(), createdUser.getName(), createdUser.getRegistrationState().name());
    }
}
