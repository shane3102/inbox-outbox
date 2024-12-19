package pl.messaging.quarkus.deployment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lpl/messaging/quarkus/deployment/InboxQuarkusProcessor;", "", "()V", "FEATURE", "", "feature", "Lio/quarkus/deployment/builditem/FeatureBuildItem;", "inbox", "Lio/quarkus/arc/deployment/AdditionalBeanBuildItem;", "inbox-outbox-quarkus-deployment"})
public final class InboxQuarkusProcessor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String FEATURE = "inbox-quarkus";
    
    public InboxQuarkusProcessor() {
        super();
    }
    
    @io.quarkus.deployment.annotations.BuildStep()
    @org.jetbrains.annotations.NotNull()
    public final io.quarkus.deployment.builditem.FeatureBuildItem feature() {
        return null;
    }
    
    @io.quarkus.deployment.annotations.BuildStep()
    @org.jetbrains.annotations.NotNull()
    public final io.quarkus.arc.deployment.AdditionalBeanBuildItem inbox() {
        return null;
    }
}