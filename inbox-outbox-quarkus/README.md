# Inbox-Outbox - Quarkus
### Configuration
<details>
    <summary>Dependency - maven configuration</summary>

Following repository has to be added:
```xml
<repositories>
    <repository>
        <id>Self hosted nexus</id>
        <url>https://nexus.shane3102.pl/repository/maven-releases/</url>
    </repository>
</repositories>
```

Dependencies:
```xml
<dependency>
     <groupId>pl.shane3102.messaging</groupId>
     <artifactId>inbox-outbox-quarkus</artifactId>
     <version>${inbox-outbox.version}</version>
</dependency>

<dependency>
    <groupId>pl.shane3102.messaging</groupId>
    <artifactId>inbox-outbox-commons</artifactId>
    <version>${inbox-outbox.version}</version>
</dependency>
```
</details>

<details>
    <summary>Quarkus bean configuration</summary>

It is recommended to implement interfaces `LoadMessages`, `SaveMessage` and `DeleteMessage`
default implementations are based on in-memory repository


</details>

#### Inbox-outbox message handling:

Sending messages to be handled by inbox-outbox:

```java
import org.springframework.context.event.EventListener;

@ApplicationScoped
public class SomeEventHandlerService {

    @Inject
    private final InboxOutbox inboxOutbox;

    @EventListener(SomeEvent.class)
    public void handleEvent(SomeEvent event) {
        SomeInboxOutboxEvent inboxEvent = event.toInboxOutboxEvent();
        inboxOutbox.publish(inboxEvent);
    }
}

```

Handing event send to inbox-outbox:

```java
@ApplicationScoped
@MessagingAwareComponent
public class SomeHandlerService {

    @InboxOutboxListener(
            retryCount = 2,
            batchSize = 10,
            cron = "* * * * * *"
    )
    public void handleSomeInboxEvent(SomeInboxOutboxEvent someEvent) {
        // implementation - seding message further (outbox) or handling message and saving result (inbox)
    }
}
```
