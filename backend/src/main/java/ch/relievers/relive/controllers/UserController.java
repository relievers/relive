package ch.relievers.relive.controllers;

import ch.relievers.relive.JwtUtils;
import ch.relievers.relive.dtos.UserControllerDtos;
import ch.relievers.relive.dtos.UserControllerDtos.RegisterUserRequest;
import ch.relievers.relive.dtos.UserControllerDtos.RegisterUserResponse;
import ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserRequest;
import ch.relievers.relive.dtos.UserControllerDtos.RequestAutoUserResponse;
import ch.relievers.relive.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Value("${relive.app.autoUserDefaultPassword}")
    private String defaultPassword;

    @PostMapping("/")
    public ResponseEntity<RequestAutoUserResponse> requestAutoUser(@RequestBody @Valid RequestAutoUserRequest request) {
        var newUserDto = userService.createAutoUser(request.getName());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(newUserDto.getId(), defaultPassword));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Authorization", "Bearer " + jwt)
                .body(newUserDto);
    }

    @PutMapping("/")
    public RegisterUserResponse registerUser(@RequestBody @Valid RegisterUserRequest request, Principal principal) {
        System.out.println(principal);
        return null;
    }

}
