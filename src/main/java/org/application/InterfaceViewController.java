package org.application;

import org.application.objects.Mail;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceViewController {

    //PUBLIC INTERFACE
    public static void init() {

        MailManager.init();

    }

    public static void showMainMenuView()
    {
        System.out.println("Ce client mail utilise Json Schema 2020-12.\n");
        System.out.println("[MENU PRINCIPAL]");
        System.out.println("1. Lire les mails reçus.");
        System.out.println("2. Lire les mails envoyés.");
        System.out.println("3. Ecrire un mail.");
        System.out.println("4. Quitter.\n");

        switch (getUserInput(1, 4))
        {
            case 1:
                System.out.println("Lecture des mails reçus...\n");
                showMailMenu(RECIEVED_MAIL_FOLDER);
                break;
            case 2:
                System.out.println("Lecture des mails envoyés...\n");
                showMailMenu(SENT_MAIL_FOLDER);
                break;
            case 3:
                System.out.println("Ecriture d'un mail...\n");
                showWriteMailMenu();
                break;
            case 4:
                System.out.println("Fermeture du client mail...\n");
                System.exit(0); //No need to break
        }
    }

    public static void showMailMenu(int mail_folder_type)
    {
        ArrayList<Mail> mail_list = new ArrayList<>();

        switch (mail_folder_type)
        {
            case RECIEVED_MAIL_FOLDER:
                System.out.println("[MAILS REÇUS]");
                mail_list = MailManager.getRecievedMails();
                break;
            case SENT_MAIL_FOLDER:
                System.out.println("[MAILS ENVOYÉS]");
                mail_list = MailManager.getSentMails();
                break;
        }

        for(int i = 0; i < mail_list.size(); i++)
        {
            Mail mail = mail_list.get(i);
            System.out.println(i + ". " + mail.get_thread().get_date() + " - " + mail.get_thread().get_titre());
        }
        System.out.println(mail_list.size() + ". " + "Retourner au menu principal.");

        int user_choice = getUserInput(0, mail_list.size());

        if(user_choice == mail_list.size())
            showMainMenuView();
        else
        {
            System.out.println("Lecture du mail...\n");
            showMail(mail_list.get(user_choice));
        }
    }

    public static void showMail(Mail mail)
    {
        System.out.println("[MAIL]");
        System.out.println("Date : " + mail.get_thread().get_date());
        System.out.println("Participants : " + convertArrayListToString(mail.get_thread().get_participants()));
        System.out.println("Titre : " + mail.get_thread().get_titre());
        System.out.println("Catégories : " + convertArrayListToString(mail.get_thread().get_categories()));
        System.out.println("Dernier message : " + mail.get_messages().get(mail.get_messages().size()-1).get_text());
        System.out.println("Appuyer sur entrée pour retourner au menu précédent.\n");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        showMailMenu(RECIEVED_MAIL_FOLDER);
    }

    public static void showWriteMailMenu()
    {
        Scanner scanner = new Scanner(System.in);
        String titre;
        String texte;
        ArrayList<String> participants = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();

        System.out.println("[ECRITURE D'UN MAIL]");
        System.out.println("Participants (séparés par des points virgules) : ");
        participants = getArrayListFromParsedString(";", scanner.nextLine());
        System.out.println("Catégories (séparées par des points virgules) : ");
        categories = getArrayListFromParsedString(";", scanner.nextLine());
        System.out.println("Titre : ");
        titre = scanner.nextLine();
        System.out.println("Texte : ");
        texte = scanner.nextLine();

        MailManager.writeMail(titre, participants, categories, texte);
        System.out.println("Mail envoyé !\n");

        showMainMenuView();
    }

    //PRIVATE INTERFACE
    private static int getUserInput(int minimum_input, int maximum_input)
    {
        Scanner scanner = new Scanner(System.in);
        int answer = minimum_input-1;

        while(answer < minimum_input || answer > maximum_input)
        {
            System.out.print("Votre choix : ");
            answer = scanner.nextInt();

            if(answer < minimum_input || answer > maximum_input)
            {
                System.out.println("Veuillez entrer un nombre entre " + minimum_input + " et " + maximum_input + ".");
            }
        }

        return answer;
    }

    private static String convertArrayListToString(ArrayList<String> list)
    {
        String result = "";

        for(int i = 0; i < list.size(); i++)
        {
            result += list.get(i);

            if(i < list.size()-1)
                result += ", ";
        }

        return result;
    }

    private static ArrayList<String> getArrayListFromParsedString(String parser, String text) {
        ArrayList<String> result = new ArrayList<>();
        String[] parsed_text = text.split(parser);

        for (int i = 0; i < parsed_text.length; i++) {
            result.add(parsed_text[i]);
        }

        return result;
    }

    //PRIVATE CONSTANTS
    private static final int RECIEVED_MAIL_FOLDER = 1;
    private static final int SENT_MAIL_FOLDER = 2;

}
