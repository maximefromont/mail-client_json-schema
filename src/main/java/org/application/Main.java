package org.application;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        //It's important to init the MailManager
        //It will browse through the recieved and sent mails, validate them using the JsonSchemaManager
        //And convert the files in Mails objects still using the JsonSchemaManager
        InterfaceViewController.init();
        InterfaceViewController.showMainMenuView();

        /*
        String sample = "D:/Hanane/APP5/data-project_mail-client/test/test1.json";
        JsonSchemaManager test = new JsonSchemaManager();
        System.out.println(test.validateJson(sample));
        JsonNode node = test.readJson(sample);
        System.out.println(node);
        System.out.println(test.writeJson(node, sample));
         */

    }
}