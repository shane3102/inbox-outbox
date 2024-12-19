package pl.shane3102.messaging

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.spock.Testcontainers
import pl.shane3102.messaging.aggregator.InboxOutbox
import pl.shane3102.messaging.configuration.InboxOutboxConfiguration
import pl.shane3102.messaging.service.TestInboxMessageService
import spock.lang.Specification

@SpringBootTest(classes = [InboxOutbox, InboxOutboxConfiguration, TestInboxMessageService])
@Testcontainers
@EnableScheduling
@ContextConfiguration
@ExtendWith(SpringExtension.class)
abstract class SpecificationIT extends Specification {

}