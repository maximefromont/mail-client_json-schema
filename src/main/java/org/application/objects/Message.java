package org.application.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Message {
    private String text;
    private Metadata metadata;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
