void main() {
    List<Message> messages = List.of(
            new Message("Rodrigo", "Hey! Where are you?", false),
            new Message("Lara", "Hey! Where are you?", false),
            new Message("Rodrigo", "Hey! Where are you?", false)
    );

    final var senderCounts = Message.countMessageBySender(messages);
    final var topSender = Message.getMostFrequentSender(senderCounts);
    final var uniqueSenders = Message.getSortedUniqueSenders(messages);

    IO.println(senderCounts);
    IO.println(topSender);
    IO.println(uniqueSenders);
}
