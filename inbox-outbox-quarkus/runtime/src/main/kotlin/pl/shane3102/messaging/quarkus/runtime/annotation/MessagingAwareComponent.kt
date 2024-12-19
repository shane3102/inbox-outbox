package pl.shane3102.messaging.quarkus.runtime.annotation

import jakarta.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class MessagingAwareComponent
