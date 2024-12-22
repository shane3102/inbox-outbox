package pl.shane3102.messaging.inbox.quarkus.it.model

import pl.shane3102.messaging.model.Message
import java.time.OffsetDateTime
import java.util.*

class TestMessageFailing : Message {
    constructor() : super(UUID.randomUUID(), 0, OffsetDateTime.now())

    constructor(id: UUID) : super(id, 0, OffsetDateTime.now())
}
