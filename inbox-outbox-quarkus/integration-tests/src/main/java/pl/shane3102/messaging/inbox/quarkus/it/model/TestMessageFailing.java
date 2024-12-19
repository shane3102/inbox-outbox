package pl.shane3102.messaging.inbox.quarkus.it.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import pl.shane3102.messaging.model.Message;

public class TestMessageFailing extends Message {
    public TestMessageFailing() {
        super(UUID.randomUUID(), 0, OffsetDateTime.now());
    }

    public TestMessageFailing(@NotNull UUID id) {
        super(id, 0, OffsetDateTime.now());
    }
}
