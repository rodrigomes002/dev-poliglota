import java.util.*;

public record Message(String sender, String body, Boolean isRead) {

    Message(String sender, String body){
        this(sender, body, false);
    }

    public static Map<String, Integer> countMessageBySender(final List<Message> messages){
        final var senderCounts = new HashMap<String, Integer>();
        for(final var message: messages){
            final var updatedCount = senderCounts.getOrDefault(message.sender(), 0) + 1;
            senderCounts.put(message.sender(), updatedCount);
        }
        return Map.copyOf(senderCounts);
    }

    public static String getMostFrequentSender(Map<String, Integer> senderCounts){
        String topSender = null;
        var topCount = -1;
        for (final var entry: senderCounts.entrySet()){
            if(entry.getValue() > topCount){
                topSender = entry.getKey();
                topCount = entry.getValue();
            }
        }
        return topSender;
    }

    public static List<String> getSortedUniqueSenders(final List<Message> messages){
        final var senders = new TreeSet<String>();
        for (final var message: messages){
            if(message.body() != null && !message.body().trim().isEmpty() && !message.isRead()){
                senders.add(message.sender());
            }
        }
        return new ArrayList<>(senders);
    }
}