package ch.relievers.relive.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "`comment`")
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    public Comment(MediaItem mediaItem, User owner, String content, LocalDateTime dateTime) {
        this.mediaItem = mediaItem;
        this.owner = owner;
        this.content = content;
        this.dateTime = dateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private MediaItem mediaItem;

    @ManyToOne
    private User owner;

    private String content;

    private LocalDateTime dateTime;


}
