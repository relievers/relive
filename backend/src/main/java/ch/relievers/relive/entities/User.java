package ch.relievers.relive.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "`user`")
@NoArgsConstructor
@Getter
@Setter
public class User {

    public enum RegistrationState { AUTO_CREATED, REGISTERED }

    public User(String name, RegistrationState registrationState, String pwHash) {
        this.name = name;
        this.registrationState = registrationState;
        this.pwHash = pwHash;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String pwHash;

    private String name;

    private RegistrationState registrationState;


}
