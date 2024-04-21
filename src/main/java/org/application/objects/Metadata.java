package org.application.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties
public class Metadata {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private LocalDateTime timestamp;
    private List<StructuredContent> structuredContent;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<StructuredContent> getStructuredContent() {
        return structuredContent;
    }

    public void setStructuredContent(List<StructuredContent> structuredContent) {
        this.structuredContent = structuredContent;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "timestamp=" + timestamp +
                ", structuredContent=" + structuredContent +
                '}';
    }
}
