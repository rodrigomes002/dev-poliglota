data class Message(
    val sender: String,
    val body: String,
    val isRead: Boolean = false
)

val messages = listOf(
    Message(sender = "Rodrigo", body = "Hello World!"),
    Message(sender = "Lara", body = "Hello World!"),
    Message(sender = "Rodrigo", body = "Hello World!")
)

fun main() {
    val fequentSender = messages
        .groupBy { it.sender }
        .maxByOrNull { (_, messages) -> messages.size }
        ?.key ?: "Sender not found"

    println("-> $fequentSender")

    val senders = messages
        .filter { it.body.isNotBlank() && !it.isRead }
        .map { it.sender }
        .distinct()
        .sorted()

    println("-> $senders")
}