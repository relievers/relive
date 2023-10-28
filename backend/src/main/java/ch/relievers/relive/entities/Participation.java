package ch.relievers.relive.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "`participation`")
@NoArgsConstructor
@Getter
@Setter
public class Participation {

    public Participation(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
}
