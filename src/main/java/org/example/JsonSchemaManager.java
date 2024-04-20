package org.example;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class JsonSchemaManager {
    private static final String SCHEMA_FILE_PATH = "D:/Hanane/APP5/mail-client_json-schema/src/main/Schematics/Message_Schema.json";
    public boolean validateJson(String jsonFilePath) throws IOException {
        File schemaFile = new File(SCHEMA_FILE_PATH);
        File jsonFile = new File(jsonFilePath);

        JSONObject jsonSchema = new JSONObject(new JSONTokener(Files.newInputStream(schemaFile.toPath())));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(Files.newInputStream(jsonFile.toPath())));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
        return true;
    }

    public JsonNode readJson(String jsonFilePath) throws IOException {
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
    public boolean writeJson(JsonNode jsonNode, String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(jsonFilePath), jsonNode);
        return true;
    }
}
