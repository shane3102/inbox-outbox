package pl.shane3102.messaging.model

import pl.shane3102.messaging.model.Message

import java.time.OffsetDateTime

class TestMessage3 extends Message {

    TestMessage3() {
        super(UUID.randomUUID(), 0, OffsetDateTime.now())
    }

}