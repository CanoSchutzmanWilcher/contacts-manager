import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        showMenu();

        Input input = new Input();
        int userOption;

        do {
            userOption = input.getInt(1,5);

            if (userOption == 1) {
                readAllContacts();
            } else if (userOption == 2) {
                addContact();
            } else if (userOption == 3) {
                searchContacts();
            } else if (userOption == 4) {
                deleteContact();
            }
            System.out.println();

        } while (!(userOption == 5));

        System.out.println("Goodbye!");

    }

    public static void showMenu() {
        System.out.println("1. View Contacts");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
    }

    public static void addContact() {
        System.out.println("Enter Full name and phone number:");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String directory = "src";
        String filename = "contact.txt";
        Path dataFile = Paths.get(directory, filename);

        ArrayList<String> contact = new ArrayList<>();
        contact.add(userInput);

        try {
            Files.write(dataFile, contact, StandardOpenOption.APPEND);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void readAllContacts() {
        List<String> contacts;
        String directory = "src";
        String filename = "contact.txt";
        Path dataFile = Paths.get(directory, filename);
        try {
            contacts = Files.readAllLines(dataFile);
            System.out.println("Name | Phone number\n -----------------\n");
            for (String contact : contacts) {
                System.out.println(contact);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void searchContacts(){
        System.out.println("Enter contact's name to search:");
        Input input = new Input();
        String userInput = input.getString();
        List<String> searchedContacts;
        String directory = "src";
        String filename = "contact.txt";
        Path dataFile = Paths.get(directory, filename);
        try {
            searchedContacts = Files.readAllLines(dataFile);
            for (String contact : searchedContacts) {
                if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                    System.out.println(contact);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void deleteContact() {
        System.out.println("Enter the contact you would like to delete:");
        Input input = new Input();
        String userInput = input.getString();
        List<String> searchedContacts;
        String directory = "src";
        String filename = "contact.txt";
        Path dataFile = Paths.get(directory, filename);

        String contactToBeRemoved = "";
        try {
            searchedContacts = Files.readAllLines(dataFile);
            for (String contact : searchedContacts) {
                if (contact.toLowerCase().contains(userInput.toLowerCase())) {
                    System.out.println(contact);
                    contactToBeRemoved = contact;
                }
            }
            if(contactToBeRemoved != "") {
                searchedContacts.remove(contactToBeRemoved);
            }
            Files.write(dataFile, searchedContacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}