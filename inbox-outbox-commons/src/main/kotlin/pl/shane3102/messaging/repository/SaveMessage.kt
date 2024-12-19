package pl.shane3102.messaging.repository

import pl.shane3102.messaging.model.Message

interface SaveMessage {
    fun saveMessage(message: Message)
}