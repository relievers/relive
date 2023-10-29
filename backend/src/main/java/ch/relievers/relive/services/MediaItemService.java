package ch.relievers.relive.services;

import ch.relievers.relive.dtos.MediaItemDtos.CreateRequest;
import ch.relievers.relive.entities.Event;
import ch.relievers.relive.entities.MediaItem;
import ch.relievers.relive.entities.User;
import ch.relievers.relive.repositories.EventRepository;
import ch.relievers.relive.repositories.MediaItemRepository;
import ch.relievers.relive.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class MediaItemService {

    @Value("${relive.app.mediaDir}")
    private String mediaDir;

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final MediaItemRepository mediaItemRepository;


    @Transactional
    public void create(CreateRequest data) throws IOException, NoSuchAlgorithmException {
        byte[] imgData = Base64.getDecoder().decode(data.getImgDataBase64());

        String imgHashBase64 = Base64.getUrlEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(imgData));

        // TODO: Remove comments as soon as event can be created
        Event event = eventRepository.findById(data.getEventId()).orElseThrow();
        User user = userRepository.findById(data.getCreatorId()).orElseThrow();

        MediaItem mediaItem = new MediaItem(LocalDateTime.now(), imgHashBase64, event, user);
        mediaItemRepository.save(mediaItem);

        // write img to file
        Files.createDirectories(Paths.get(mediaDir));
        Files.write(Path.of(mediaDir + imgHashBase64 + ".jpg"), imgData);
    }
}
