package org.application;

import com.fasterxml.jackson.databind.JsonNode;
import org.application.objects.Mail;
import org.tools.PropertiesReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailManager {

    //PRIVATE ATTRIBUTES
    private static ArrayList<Mail> _recieved_mails;
    private static ArrayList<Mail> _sent_mails;

    //PUBLIC METHODS
    public static void init() throws IOException {
        _recieved_mails = new ArrayList<>();
        _sent_mails = new ArrayList<>();

        String _received_mails_path = PropertiesReader.getMessagesReceivedPath();
        String _sent_mails_path = PropertiesReader.getMessagesSentPath();

        System.out.println(_received_mails_path);
        System.out.println(_sent_mails_path);

        //Browse through the received mails folder
        File received_mails_folder = new File(_received_mails_path);
        File[] received_mails_files = received_mails_folder.listFiles();
        //TODO: Use JsonSchemaManager to validates the files, and convert them into Mail objects
        System.out.println(received_mails_files);
        if (received_mails_files != null) {
            for (File file : received_mails_files) {
                if(JsonSchemaManager.validateJson(file.getPath())) {
                    System.out.println(JsonSchemaManager.readJson(file.getPath()));
//                    for(int i = 0; i< 3; i++) {
//
//                    }
//                    ArrayList<String> listOfTypes = JsonSchemaManager.readTypeJson(file.getPath());
//                    System.out.println("listOfTypes: " + listOfTypes);
//
//                    ArrayList<String> listOfValues = JsonSchemaManager.readValueJson(file.getPath());
//                    System.out.println("listOfValues: " + listOfValues);

                }
            }
        }
        System.out.println(received_mails_files.length);

        //Browse through the sent mails folder
        File sent_mails_folder = new File(_sent_mails_path);
        File[] sent_mails_files = sent_mails_folder.listFiles();
        //TODO: Use JsonSchemaManager to validates the files, and convert them into Mail objects
        System.out.println(sent_mails_files.length);
    }

}
