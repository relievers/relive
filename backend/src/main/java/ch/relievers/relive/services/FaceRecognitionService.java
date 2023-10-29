package ch.relievers.relive.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class FaceRecognitionService {
    @EventListener(ApplicationReadyEvent.class)
    public void onStartup() {
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            String json = """
                {
                    "event_paths": [
                        "../frontend/static/media/1aTCYxJtxZB6fwt2fCShkeIAZoRf94yXP8QSbWlQpY0=.jpg",
                        "../frontend/static/media/Gb8kiODD13iF0J5RdAbEsr-6RmjfeuOVQmyIilRVgTI=.jpg"
                    ],
                    "user_paths": [
                        "linus.jpg"
                    ]
                }
                                
                """;

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("http://localhost:5000/find-user-imgs-in-event-imgs"))
                        .POST(HttpRequest.BodyPublishers.ofString(json))
                        .build();


            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

        }, 1, 1, TimeUnit.SECONDS);
    }
}
