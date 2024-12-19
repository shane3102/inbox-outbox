package pl.shane3102.messaging.repository.impl

import pl.shane3102.messaging.model.Message
import pl.shane3102.messaging.repository.DeleteMessage
import pl.shane3102.messaging.repository.LoadMessages
import pl.shane3102.messaging.repository.SaveMessage
import java.util.UUID

class InMemoryInboxMessageRepository(
    private val repo: HashMap<UUID, Message> = HashMap()
) : LoadMessages, SaveMessage, DeleteMessage {

    override fun loadLatestByTypeNonExpired(className: String, batchSize: Int, maxRetryCount: Int): List<Message> {
        return repo.values.sortedBy { it.occurredOn }
            .stream()
            .filter { inboxMessage -> inboxMessage::class.java.toString() == className }
            .filter { inboxMessage -> inboxMessage.retryCount < maxRetryCount }
            .limit(batchSize.toLong())
            .toList()
    }

    override fun saveMessage(message: Message) {
        repo[message.id] = message
    }

    override fun delete(id: UUID) {
        repo.remove(id)
    }


}