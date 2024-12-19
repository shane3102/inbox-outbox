package pl.shane3102.messaging.quarkus.runtime.configuration

import io.quarkus.arc.DefaultBean
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.context.Dependent
import jakarta.enterprise.inject.Produces
import pl.shane3102.messaging.repository.impl.InMemoryInboxMessageRepository

@Dependent
class InboxOutboxConfiguration {

    private val inMemoryInboxMessageRepository = InMemoryInboxMessageRepository()

    @Produces
    @DefaultBean
    @ApplicationScoped
    fun inMemoryInboxMessageRepository(): InMemoryInboxMessageRepository {
        return inMemoryInboxMessageRepository
    }
}