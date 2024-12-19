package pl.shane3102.messaging.repository

import java.util.UUID

interface DeleteMessage {
    fun delete(id: UUID)
}