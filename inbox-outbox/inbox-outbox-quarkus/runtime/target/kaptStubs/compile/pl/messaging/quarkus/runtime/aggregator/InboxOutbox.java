package pl.messaging.quarkus.runtime.aggregator;

@jakarta.enterprise.context.ApplicationScoped()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0012J\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0012J\u0010\u0010\u000e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\b8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\nX\u0092\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0012@\u0012X\u0093.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lpl/messaging/quarkus/runtime/aggregator/InboxOutbox;", "", "()V", "annotation", "", "getAnnotation", "()Ljava/lang/annotation/Annotation;", "deleteMessage", "Lpl/messaging/repository/DeleteMessage;", "inboxes", "", "Lio/quarkus/arc/InstanceHandle;", "loadMessages", "Lpl/messaging/repository/LoadMessages;", "saveMessage", "Lpl/messaging/repository/SaveMessage;", "scheduler", "Lio/quarkus/scheduler/Scheduler;", "loadAndPerformTasks", "", "inboxClass", "Ljava/lang/Class;", "batchSize", "", "maxRetryCount", "consumer", "Ljava/util/function/Consumer;", "Lpl/messaging/model/Message;", "performTask", "inboxMessage", "startJobs", "inbox-outbox-quarkus"})
public class InboxOutbox {
    @jakarta.inject.Inject()
    @jakarta.enterprise.inject.Default()
    private pl.messaging.repository.LoadMessages loadMessages;
    @jakarta.inject.Inject()
    @jakarta.enterprise.inject.Default()
    private pl.messaging.repository.SaveMessage saveMessage;
    @jakarta.inject.Inject()
    @jakarta.enterprise.inject.Default()
    private pl.messaging.repository.DeleteMessage deleteMessage;
    @jakarta.inject.Inject()
    @jakarta.enterprise.inject.Default()
    private io.quarkus.scheduler.Scheduler scheduler;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.annotation.Annotation annotation = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends io.quarkus.arc.InstanceHandle<java.lang.Object>> inboxes;
    
    public InboxOutbox() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.annotation.Annotation getAnnotation() {
        return null;
    }
    
    public void saveMessage(@org.jetbrains.annotations.NotNull()
    pl.messaging.model.Message inboxMessage) {
    }
    
    private void loadAndPerformTasks(java.lang.Class<? extends java.lang.Object> inboxClass, int batchSize, int maxRetryCount, java.util.function.Consumer<pl.messaging.model.Message> consumer) {
    }
    
    private void performTask(pl.messaging.model.Message inboxMessage, java.util.function.Consumer<pl.messaging.model.Message> consumer) {
    }
    
    @jakarta.annotation.PostConstruct()
    public void startJobs() {
    }
}