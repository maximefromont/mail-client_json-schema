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
import java.nio.file.Paths;

public class JsonSchemaManager {
    private static final String SCHEMA_FILE_PATH = "path/to/your/schema.json";

    /**
     * Validates a JSON file against the predefined JSON schema.
     * @param jsonFilePath path to the JSON file to be validated
     */
    public void validateJson(String jsonFilePath) throws IOException {
        File schemaFile = new File(SCHEMA_FILE_PATH);
        File jsonFile = new File(jsonFilePath);

        JSONObject jsonSchema = new JSONObject(new JSONTokener(Files.newInputStream(schemaFile.toPath())));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(Files.newInputStream(jsonFile.toPath())));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);  // throws a ValidationException if this object is invalid
    }

    /**
     * Reads a JSON file and returns it as a JsonNode.
     * @param jsonFilePath path to the JSON file
     * @return JsonNode representation of the JSON file
     */
    public JsonNode readJson(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(new File(jsonFilePath));
    }

    /**
     * Writes a JsonNode to a file.
     * @param jsonNode JsonNode to write
     * @param jsonFilePath path where to write the JSON file
     */
    public void writeJson(JsonNode jsonNode, String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new FileWriter(jsonFilePath), jsonNode);
    }
}
