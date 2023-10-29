package ch.relievers.relive.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserControllerDtos {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestAutoUserRequest {
        @Size(min = 2, max = 100)
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestAutoUserResponse {
        private int id;
        private String name;
        private String registrationState;
        private String token;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterUserResponse {
        private int id;
        private String name;
        private String email;
        private String registrationState;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterUserRequest {
        @Email
        private String email;

        @Size(min = 10)
        private String password;
    }
}
