package org.application;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.application.objects.MessageSchema;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static MessageSchema readJsonFromFile(String filePath) throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.readValue(new File(filePath), MessageSchema.class);
    }

    public static void main(String[] args) throws IOException {
        try {
            // It's important to init the MailManager
            // It will browse through the recieved and sent mails, validate them using the JsonSchemaManager
            // And convert the files in Mails objects still using the JsonSchemaManager
            MailManager.init();

            MessageSchema messageSchema = readJsonFromFile("D:\\Hanane\\APP5\\mail-client_json-schema\\src\\main\\Mails\\Sent\\test3.json");
            System.out.println(messageSchema);
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}