void main() {
    List<Message> messages = List.of(
            new Message("Rodrigo", "Hey! Where are you?"),
            new Message("Lara", "Hey! Where are you?"),
            new Message("Rodrigo", "Hey! Where are you?")
    );

    final var senderCounts = Message.countMessageBySender(messages);
    final var topSender = Message.getMostFrequentSender(senderCounts);
    final var uniqueSenders = Message.getSortedUniqueSenders(messages);

    IO.println(senderCounts);
    IO.println(topSender);
    IO.println(uniqueSenders);
}
