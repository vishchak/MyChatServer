package ua.kiev.prog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {
    private static final MessageList msgList = new MessageList();

    private final Gson gson;
    private final List<Message> list = new LinkedList<>();

    public static MessageList getInstance() {
        return msgList;
    }

    private MessageList() {
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public synchronized void add(Message m) {
        list.add(m);
    }

    public synchronized String toJSON(int n, String to) {
        List<Message> messageList = new ArrayList<>();
        for (Message message :
                list) {
            if (message.getTo().equalsIgnoreCase("")) {
                message.setTo("everyone");
            }
            if (message.getTo().equalsIgnoreCase("everyone")) {
                messageList.add(message);
            } else if (message.getTo().equalsIgnoreCase(to)) {
                messageList.add(message);
            }
        }
        if (n >= list.size()) return null;
        return gson.toJson(new JsonMessages(messageList, n));
    }
}
