package ch.relievers.relive.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "`media`")
@NoArgsConstructor
@Getter
@Setter
public class MediaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public MediaItem(LocalDateTime time, String hash, Event event, User creator) {
        this.time = time;
        this.hash = hash;
        this.event = event;
        this.creator = creator;
    }

    private LocalDateTime time;

    private String hash;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;


}
