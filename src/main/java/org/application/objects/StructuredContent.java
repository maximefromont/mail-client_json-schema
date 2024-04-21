package org.application.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class StructuredContent {
    private String type;
    private Object value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StructuredContent{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
