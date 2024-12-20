package pl.shane3102.messaging.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.config.ScheduledTaskRegistrar
import pl.shane3102.messaging.annotation.MessagingAwareComponent
import pl.shane3102.messaging.repository.DeleteMessage
import pl.shane3102.messaging.repository.LoadMessages
import pl.shane3102.messaging.repository.SaveMessage
import pl.shane3102.messaging.repository.impl.InMemoryInboxMessageRepository

@Configuration
open class InboxOutboxConfiguration(
    @Autowired
    applicationContext: ApplicationContext
) {

    private var inboxes: List<Any> = applicationContext.getBeansWithAnnotation(MessagingAwareComponent::class.java)
        .values.toList()

    private val inMemoryInboxMessageRepository = InMemoryInboxMessageRepository()

    @Bean
    open fun scheduledTaskRegistrar(taskScheduler: TaskScheduler): ScheduledTaskRegistrar {
        val scheduledTaskRegistrar = ScheduledTaskRegistrar()
        scheduledTaskRegistrar.setScheduler(taskScheduler)
        scheduledTaskRegistrar.afterPropertiesSet()
        return scheduledTaskRegistrar
    }

    @Bean
    open fun taskScheduler(): TaskScheduler {
        val scheduler = ThreadPoolTaskScheduler()
        scheduler.poolSize = if (inboxes.isEmpty()) 1 else inboxes.size
        scheduler.initialize()
        return scheduler
    }

    @Bean
    @ConditionalOnMissingBean(LoadMessages::class, SaveMessage::class, DeleteMessage::class)
    open fun inMemoryInboxMessageRepository(): InMemoryInboxMessageRepository {
        return inMemoryInboxMessageRepository
    }

}