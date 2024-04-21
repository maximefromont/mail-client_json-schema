package org.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    //PUBLIC METHODS
    public static String getMessage(String language, String key) {
        return getValueFromKey(key, APPLICATION_LANGUAGE_PREFIX_PATH + language + ".properties");
    }

    public static String getMessagesReceivedPath() {
        return getValueFromKey("messages-received-path", APPLICATION_SETTINGS_PATH);
    }

    public static String getMessagesSentPath() {
        return getValueFromKey("messages-sent-path", APPLICATION_SETTINGS_PATH);
    }

    public static String getMessageSchemaPath() {
        return getValueFromKey("message-schema-path", APPLICATION_SETTINGS_PATH);
    }

    //PRIVATE METHODS
    private static String getValueFromKey(String key, String path) {
        Properties properties = new Properties();
        String value = null;

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }

    //PRIVATE CONSTANTS
    private static final String APPLICATION_SETTINGS_PATH = "src/main/Configs/application-settings.properties";
    private static final String APPLICATION_LANGUAGE_PREFIX_PATH = "src/main/Configs/application-language-";
}