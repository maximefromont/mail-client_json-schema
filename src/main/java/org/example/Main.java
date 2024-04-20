package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import javax.sound.midi.Soundbank;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String sample = "D:/Hanane/APP5/data-project_mail-client/test/test.json";
        JsonSchemaManager test = new JsonSchemaManager();
        System.out.println(test.validateJson(sample));
        JsonNode node = test.readJson(sample);
        System.out.println(node);
        System.out.println(test.writeJson(node, sample));

    }
}