package pl.shane3102.messaging.quarkus.deployment

import io.quarkus.arc.deployment.AdditionalBeanBuildItem
import io.quarkus.deployment.annotations.BuildStep
import io.quarkus.deployment.builditem.FeatureBuildItem
import pl.shane3102.messaging.quarkus.runtime.aggregator.InboxOutbox
import pl.shane3102.messaging.quarkus.runtime.annotation.MessagingAwareComponent
import pl.shane3102.messaging.quarkus.runtime.configuration.InboxOutboxConfiguration

class InboxOutboxQuarkusProcessor {

    private val FEATURE = "inbox-outbox-quarkus"

    @BuildStep
    fun feature(): FeatureBuildItem {
        return FeatureBuildItem(FEATURE)
    }

    @BuildStep
    fun inbox(): AdditionalBeanBuildItem {
        return AdditionalBeanBuildItem(
            InboxOutbox::class.java,
            InboxOutboxConfiguration::class.java,
            MessagingAwareComponent::class.java
        )
    }


}