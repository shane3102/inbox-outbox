package pl.shane3102.messaging.repository

import pl.shane3102.messaging.model.Message

interface LoadMessages {
    fun loadLatestByTypeNonExpired(className: String, batchSize: Int, maxRetryCount: Int): List<Message>
}