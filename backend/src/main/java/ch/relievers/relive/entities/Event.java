package ch.relievers.relive.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "`event`")
@NoArgsConstructor
@Getter
@Setter
public class Event {

    public enum EventState { PLANNED, ONGOING, PAST }

    public Event(String displayName, String description, LocalDateTime startDateTime, Integer duration) {
        this.displayName = displayName;
        this.description = description;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.state = EventState.PLANNED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<MediaItem> medias;

    private String displayName;

    private String description;

    private LocalDateTime startDateTime;

    // Unit = minutes
    private Integer duration;

    private EventState state;

}
