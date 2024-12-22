package pl.shane3102.messaging.inbox.quarkus.it.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import pl.shane3102.messaging.model.Message;

public class TestMessage3 extends Message {
    public TestMessage3() {
        super(UUID.randomUUID(), 0, OffsetDateTime.now());
    }
}
