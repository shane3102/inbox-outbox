package pl.shane3102.messaging.inbox.quarkus.it

import io.quarkus.test.junit.QuarkusTest
import jakarta.enterprise.inject.Any
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage1
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage2
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessage3
import pl.shane3102.messaging.inbox.quarkus.it.model.TestMessageFailing
import pl.shane3102.messaging.inbox.quarkus.it.service.TestInboxMessageService
import pl.shane3102.messaging.model.Message
import pl.shane3102.messaging.quarkus.runtime.aggregator.InboxOutbox
import pl.shane3102.messaging.repository.LoadMessages
import java.util.UUID
import java.util.function.Consumer

@QuarkusTest
class InboxTest {
    @Inject
    var inboxOutbox: InboxOutbox? = null

    @Any
    @Inject
    var testInboxMessageService: TestInboxMessageService? = null

    @Inject
    var loadMessages: LoadMessages? = null

    @Test
    fun inboxSimpleTest() {
        // given
        val sentMessages = listOf(TestMessage3(), TestMessage3(), TestMessage2(), TestMessageFailing(), TestMessage1())
        val expectedCountByMessage = mapOf(
            TestMessage3::class.java to 2,
            TestMessage2::class.java to 1,
            TestMessageFailing::class.java to 0,
            TestMessage1::class.java to 1
        )

        // when
        sentMessages.forEach(Consumer { inboxMessage: Message? ->
            inboxOutbox!!.saveMessage(
                inboxMessage!!
            )
        })
        try {
            Thread.sleep(1100)
        } catch (ignored: Exception) {
        }

        // then
        expectedCountByMessage.forEach { (inboxMessageType: Class<out Message>?, expectedCount: Int?) ->
            val realCount = testInboxMessageService!!.executeCountByInbox[inboxMessageType]
            Assertions.assertEquals(
                expectedCount,
                realCount,
                "Count for class $inboxMessageType not equal expected. Real count: $realCount, Expected count: $expectedCount"
            )
        }
    }

    @Test
    fun shouldHaveExpectedCountOfRetryOnFailingInboxMessage() {
        testInboxMessageService!!.resetCount()
        val id = UUID.randomUUID()

        inboxOutbox!!.saveMessage(TestMessageFailing(id))
        try {
            Thread.sleep(1500)
        } catch (ignored: Exception) {
        }

        val failingMessages = loadMessages!!.loadLatestByTypeNonExpired(
            TestMessageFailing::class.java.toString(), 5, 5
        )
        val sentInboxMessage =
            failingMessages.stream().filter { failingInboxMessage: Message -> failingInboxMessage.id == id }
                .findFirst().orElseThrow { AssertionError() }

        Assertions.assertTrue(sentInboxMessage.retryCount >= 1, "Expected to have at least one in retry count")
        Assertions.assertTrue(sentInboxMessage.retryCount <= 3, "Expected to have at most 3 in retry count")
    }

    @Test
    fun shouldHaveExpectedCountOfRetryWithMaxValueOnFailingInboxMessage() {
        testInboxMessageService!!.resetCount()
        val id = UUID.randomUUID()

        inboxOutbox!!.saveMessage(TestMessageFailing(id))
        try {
            Thread.sleep(5000)
        } catch (ignored: Exception) {
        }

        val failingMessages = loadMessages!!.loadLatestByTypeNonExpired(
            TestMessageFailing::class.java.toString(), 5, 5
        )
        val sentMessage =
            failingMessages.stream().filter { failingInboxMessage: Message -> failingInboxMessage.id == id }
                .findFirst().orElseThrow { AssertionError() }

        Assertions.assertEquals(3, sentMessage.retryCount, "Expected to have exactly 3 in retry count")
    }
}
