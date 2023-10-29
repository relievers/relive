package ch.relievers.relive.services;

import ch.relievers.relive.dtos.UserControllerDtos;
import ch.relievers.relive.dtos.UserControllerDtos.RegisterUserRequest;
import ch.relievers.relive.dtos.UserControllerDtos.RegisterUserResponse;
import ch.relievers.relive.entities.User;
import ch.relievers.relive.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserResponse;

@RequiredArgsConstructor
@Service
public class UserService {

    @Value("${relive.app.autoUserDefaultPassword}")
    private String defaultPassword;

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Transactional
    public RequestAutoUserResponse createAutoUser(String name) {
        User newUser = new User(name, User.RegistrationState.AUTO_CREATED, encoder.encode(defaultPassword));
        User createdUser = userRepository.save(newUser);
        return new RequestAutoUserResponse(createdUser.getId(), createdUser.getName(), createdUser.getRegistrationState().name(), null);
    }

    public RegisterUserResponse registerUser(int userId, RegisterUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setEmail(request.getEmail());
        user.setPwHash(encoder.encode(request.getPassword()));
        user.setRegistrationState(User.RegistrationState.REGISTERED);
        userRepository.save(user);
        return new RegisterUserResponse(user.getId(), user.getName(), user.getEmail(), user.getRegistrationState().name());
    }
}
