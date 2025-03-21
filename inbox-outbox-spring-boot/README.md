# Inbox-Outbox - Spring boot

### Configuration
<details>
    <summary>Dependency - maven configuration</summary>

Following repository has to be added:
```xml
<repositories>
    <repository>
        <id>Self hosted reposilite</id>
        <url>https://reposilite.shane3102.pl/releases</url>
    </repository>
</repositories>
```

Dependencies:
```xml

<dependency>
    <groupId>pl.shane3102.messaging</groupId>
    <artifactId>inbox-outbox-spring-boot</artifactId>
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
    <summary>Spring bean configuration</summary>

Following configuration extending `InboxOutboxConfiguration` with `InboxOutbox` bean has to be registered:
```java
@Configuration
public class InboxOutboxBeanConfiguration extends InboxOutboxConfiguration {

    public InboxOutboxBeanConfiguration(@NotNull ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Bean
    InboxOutbox inboxOutbox(
        ScheduledTaskRegistrar scheduledTaskRegistrar,
        LoadMessages loadMessages,
        SaveMessage saveMessage,
        DeleteMessage deleteMessage,
        ApplicationContext applicationContext
    ) {
        return new InboxOutbox(
            scheduledTaskRegistrar,
            loadMessages,
            saveMessage,
            deleteMessage,
            applicationContext
        );
    }
}
```

It is recommended to implement interfaces `LoadMessages`, `SaveMessage` and `DeleteMessage`
default implementations are based on in-memory repository
    

</details>

<details>
  <summary>App configuration</summary>

Folowing annotation has to be present in class starting Spring boot

```java
@EnableScheduling
```

</details>

### Usage example

#### Inbox-outbox message handling:

Sending messages to be handled by inbox-outbox:
```java
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeEventHandlerService {

    private final InboxOutbox inboxOutbox;

    @EventListener(SomeEvent.class)
    public void handleEvent(SomeEvent event) {
        SomeInboxOutboxEvent inboxOutboxEvent = event.toInboxOutboxEvent();
        inboxOutbox.publish(inboxOutboxEvent);
    }
}

```

Handing event send to inbox-outbox:
```java
@Service
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
