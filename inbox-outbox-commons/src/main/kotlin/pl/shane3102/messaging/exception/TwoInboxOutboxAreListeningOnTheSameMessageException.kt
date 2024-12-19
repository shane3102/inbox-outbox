package pl.shane3102.messaging.exception

import pl.shane3102.messaging.model.Message
import java.lang.RuntimeException

class TwoInboxOutboxAreListeningOnTheSameMessageException(type: Class<out Message>) : RuntimeException(
    "Two inbox/outbox methods are listening on same message type (%s). " +
            "Create separate types for each listener or aggregate operations into one listener"
                .format(type)
)