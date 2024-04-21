package org.application;

import org.application.objects.Mail;
import org.tools.PropertiesReader;

import java.io.File;
import java.util.ArrayList;

public class MailManager {

    //PRIVATE ATTRIBUTES
    private static ArrayList<Mail> _recieved_mails;
    private static ArrayList<Mail> _sent_mails;

    //PUBLIC METHODS
    public static void init() {
        _recieved_mails = new ArrayList<>();
        _sent_mails = new ArrayList<>();

        String _recieved_mails_path = PropertiesReader.getMessagesReceivedPath();
        String _sent_mails_path = PropertiesReader.getMessagesSentPath();

        System.out.println(_recieved_mails_path);
        System.out.println(_sent_mails_path);

        //Browse through the received mails folder
        File recieved_mails_folder = new File(_recieved_mails_path);
        File[] recieved_mails_files = recieved_mails_folder.listFiles();
        //TODO: Use JsonSchemaManager to validates the files, and convert them into Mail objects
        System.out.println(recieved_mails_files.length);

        //Browse through the sent mails folder
        File sent_mails_folder = new File(_sent_mails_path);
        File[] sent_mails_files = sent_mails_folder.listFiles();
        //TODO: Use JsonSchemaManager to validates the files, and convert them into Mail objects
        System.out.println(sent_mails_files.length);
    }

    public static ArrayList<Mail> getRecievedMails() {
        return _recieved_mails;
    }

    public static ArrayList<Mail> getSentMails() {
        return _sent_mails;
    }

    public static void writeMail(String titre, ArrayList<String> participants, ArrayList<String> categories, String texte) {
        //TODO : Use JsonSchemaManager to write the mail in the sent mails folder

        MailManager.init(); //Refresh the MailManager once the email is sent.
    }

}
