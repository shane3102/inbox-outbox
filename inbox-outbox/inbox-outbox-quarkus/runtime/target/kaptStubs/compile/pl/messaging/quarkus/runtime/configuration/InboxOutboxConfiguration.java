package pl.messaging.quarkus.runtime.configuration;

@jakarta.enterprise.context.Dependent()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lpl/messaging/quarkus/runtime/configuration/InboxOutboxConfiguration;", "", "()V", "inMemoryInboxMessageRepository", "Lpl/messaging/repository/impl/InMemoryInboxMessageRepository;", "inbox-outbox-quarkus"})
public final class InboxOutboxConfiguration {
    @org.jetbrains.annotations.NotNull()
    private final pl.messaging.repository.impl.InMemoryInboxMessageRepository inMemoryInboxMessageRepository = null;
    
    public InboxOutboxConfiguration() {
        super();
    }
    
    @jakarta.enterprise.inject.Produces()
    @io.quarkus.arc.DefaultBean()
    @jakarta.enterprise.context.ApplicationScoped()
    @org.jetbrains.annotations.NotNull()
    public final pl.messaging.repository.impl.InMemoryInboxMessageRepository inMemoryInboxMessageRepository() {
        return null;
    }
}