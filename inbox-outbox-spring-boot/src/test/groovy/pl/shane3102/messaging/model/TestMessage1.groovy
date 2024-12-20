package pl.shane3102.messaging.model

import pl.shane3102.messaging.model.Message

import java.time.OffsetDateTime

class TestMessage1 extends Message {
    TestMessage1() {
        super(UUID.randomUUID(), 0, OffsetDateTime.now())
    }
}
