package ch.relievers.relive.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "`event`")
@NoArgsConstructor
@Getter
@Setter
public class Event {

    public Event(String displayName, String description, LocalDateTime startDateTime, Integer duration, EventState state) {
        this.displayName = displayName;
        this.description = description;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.state = state;
    }

    public enum EventState { PLANNED, ONGOING, PAST }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@ManyToOne()
    //private User owner;

    private String displayName;

    private String description;

    private LocalDateTime startDateTime;

    // Unit = minutes
    private Integer duration;

    private EventState state;

}
