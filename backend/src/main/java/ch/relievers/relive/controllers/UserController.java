package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserRequest;
import ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserResponse;
import ch.relievers.relive.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public RequestAutoUserResponse requestAutoUser(@RequestBody @Valid RequestAutoUserRequest request) {
        return userService.createAutoUser(request.getName());
    }

}
