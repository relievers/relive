package ch.relievers.relive.controllers;

import ch.relievers.relive.dtos.MediaItemDtos.CreateRequest;
import ch.relievers.relive.services.MediaItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/media-items")
@RequiredArgsConstructor
public class MediaItemController {

    private final MediaItemService mediaItemService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/")
    public void uploadNewMediaItem(@RequestBody CreateRequest request) throws IOException, NoSuchAlgorithmException {
        mediaItemService.create(request);
    }

}
