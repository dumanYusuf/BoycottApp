package com.example.boycottapp.domain.model

data class UsersNotification(
    val userNotificationId: String = "",
    val markaName: String = "",
    val userPosta: String = "",
    val userMessage: String = ""
)


fun UsersNotification.toMap(): Map<String, Any> {
    return mapOf(
        "userNotificationId" to userNotificationId,
        "markaName" to markaName,
        "userPosta" to userPosta,
        "userMessage" to userMessage
    )
}
