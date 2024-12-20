package pl.shane3102.messaging.service

import org.springframework.stereotype.Component
import pl.shane3102.messaging.annotation.InboxOutboxListener
import pl.shane3102.messaging.annotation.MessagingAwareComponent
import pl.shane3102.messaging.model.Message
import pl.shane3102.messaging.model.TestMessage1
import pl.shane3102.messaging.model.TestMessage2
import pl.shane3102.messaging.model.TestMessage3
import pl.shane3102.messaging.model.TestMessageFailing

@Component
@MessagingAwareComponent
class TestInboxMessageService {
    static final def DEFAULT_EXECUTE_COUNT_BY_INBOX = new HashMap<>(
            Map.of(
                    TestMessage3.class as Class<Message>, 0,
                    TestMessage2.class as Class<Message>, 0,
                    TestMessageFailing.class as Class<Message>, 0,
                    TestMessage1.class as Class<Message>, 0
            )
    )

    Map<Class<Message>, Integer> executeCountByInbox = DEFAULT_EXECUTE_COUNT_BY_INBOX

    def resetCount() {
        executeCountByInbox = DEFAULT_EXECUTE_COUNT_BY_INBOX
    }

    @InboxOutboxListener(
            retryCount = 2,
            batchSize = 10,
            cron = "* * * * * *"
    )
    void testInboxMessageFixedRate(TestMessage3 message) {
        def count = executeCountByInbox.get(message.class)
        count = count + 1
        executeCountByInbox.put(message.class, count)
    }

    @InboxOutboxListener(
            retryCount = 2,
            batchSize = 10,
            cron = "* * * * * *"
    )
    void testInboxMessageFixedDelay(TestMessage2 message) {
        def count = executeCountByInbox.get(message.class)
        count = count + 1
        executeCountByInbox.put(message.class, count)
    }

    @InboxOutboxListener(
            retryCount = 2,
            batchSize = 10,
            cron = "* * * * * *"
    )
    void testInboxMessageCron(TestMessage1 message) {
        def count = executeCountByInbox.get(message.class)
        count = count + 1
        executeCountByInbox.put(message.class, count)
    }

    @InboxOutboxListener(
            retryCount = 3,
            batchSize = 10,
            cron = "* * * * * *"
    )
    void testInboxMessageFailing(TestMessageFailing message) {
        throw new RuntimeException()
    }
}
