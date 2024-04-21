package org.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.objects.MessageSchema;

import java.io.File;
import java.io.IOException;

public class JsonToJava {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static MessageSchema readJsonFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), MessageSchema.class);
    }
}
