package pl.shane3102.messaging.base

import pl.shane3102.messaging.model.Message
import java.util.function.Consumer

class BaseInboxOutbox<T : Message>(
    val retryCount: Int,
    val batchSize: Int,
    val cron: String,
    val type: Class<out T>,
    val performedJob: Consumer<T>
)