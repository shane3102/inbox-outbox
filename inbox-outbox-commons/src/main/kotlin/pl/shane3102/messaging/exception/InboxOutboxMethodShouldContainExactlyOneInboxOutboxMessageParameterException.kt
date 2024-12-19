package pl.shane3102.messaging.exception

import pl.shane3102.messaging.model.Message

class InboxOutboxMethodShouldContainExactlyOneInboxOutboxMessageParameterException : RuntimeException(
    "Inbox-outbox message method should contain exactly one parameter of %s type".format(Message::class)
)