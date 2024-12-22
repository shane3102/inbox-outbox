package pl.shane3102.messaging.inbox.quarkus.it.model

import pl.shane3102.messaging.model.Message
import java.time.OffsetDateTime
import java.util.*

class TestMessage2 : Message(UUID.randomUUID(), 0, OffsetDateTime.now())
