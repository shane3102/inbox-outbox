package pl.shane3102.messaging.inbox.quarkus.it.service

import jakarta.enterprise.context.ApplicationScoped
import pl.shane3102.messaging.annotation.InboxOutboxListener
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage1
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage2
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage3
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessageFailing
import pl.shane3102.messaging.model.Message
import pl.shane3102.messaging.quarkus.runtime.annotation.MessagingAwareComponent

@ApplicationScoped
@MessagingAwareComponent
class TestInboxMessageService {
    var executeCountByInbox: MutableMap<Class<out Message?>, Int> = DEFAULT_EXECUTE_COUNT_BY_INBOX

    fun resetCount() {
        executeCountByInbox = DEFAULT_EXECUTE_COUNT_BY_INBOX
    }

    @InboxOutboxListener(retryCount = 2, batchSize = 10, cron = "* * * * * ?")
    fun testInboxMessageFixedRate(message: TestMessage3) {
        var count = executeCountByInbox[message.javaClass]
        count = count!! + 1
        executeCountByInbox[message.javaClass] = count
    }

    @InboxOutboxListener(retryCount = 2, batchSize = 10, cron = "* * * * * ?")
    fun testInboxMessageFixedDelay(message: TestMessage2) {
        var count = executeCountByInbox[message.javaClass]
        count = count!! + 1
        executeCountByInbox[message.javaClass] = count
    }

    @InboxOutboxListener(retryCount = 2, batchSize = 10, cron = "* * * * * ?")
    fun testInboxMessageCron(message: TestMessage1) {
        var count = executeCountByInbox[message.javaClass]
        count = count!! + 1
        executeCountByInbox[message.javaClass] = count
    }

    @InboxOutboxListener(retryCount = 3, batchSize = 10, cron = "* * * * * ?")
    fun testInboxMessageFailing(message: TestMessageFailing?) {
        throw RuntimeException()
    }

    companion object {
        val DEFAULT_EXECUTE_COUNT_BY_INBOX: MutableMap<Class<out Message?>, Int> = hashMapOf(
            TestMessage3::class.java to 0,
            TestMessage2::class.java to 0,
            TestMessageFailing::class.java to 0,
            TestMessage1::class.java to 0
        )
    }
}
