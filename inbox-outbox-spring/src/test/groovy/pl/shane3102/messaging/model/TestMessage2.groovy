package pl.shane3102.messaging.model

import pl.shane3102.messaging.model.Message

import java.time.OffsetDateTime

class TestMessage2 extends Message {
    TestMessage2() {
        super(UUID.randomUUID(), 0, OffsetDateTime.now())
    }
}
