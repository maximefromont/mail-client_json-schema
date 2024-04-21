package org.application;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.objects.Message;
import org.application.objects.Metadata;
import org.application.objects.StructuredContent;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.tools.PropertiesReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JsonSchemaManager {

    public static boolean validateJson(String jsonFilePath) throws IOException {
        File schemaFile = new File(PropertiesReader.getMessageSchemaPath());
        File jsonFile = new File(jsonFilePath);

        JSONObject jsonSchema = new JSONObject(new JSONTokener(Files.newInputStream(schemaFile.toPath())));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(Files.newInputStream(jsonFile.toPath())));

        Schema schema = SchemaLoader.load(jsonSchema);
        try {
            schema.validate(jsonSubject);
            System.out.println("Validation successful.");
            return true;
        } catch (ValidationException e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false;
        }
    }

    public static JsonNode readJson(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new File(jsonFilePath));
    }

    /**
     * Writes a JsonNode to a file.
     *
     * @param jsonNode     JsonNode to write
     * @param jsonFilePath path where to write the JSON file
     * @return
     */
    public static boolean writeJson(JsonNode jsonNode, String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(jsonFilePath), jsonNode);
        return true;
    }
}
