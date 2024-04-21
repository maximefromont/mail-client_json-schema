package org.application.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class MessageSchema {
    private Thread thread;
    private List<Message> messages;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "MessageSchema{" +
                "thread=" + thread +
                ", messages=" + messages +
                '}';
    }
}