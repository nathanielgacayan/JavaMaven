package com.phonebook;

import com.phonebook.model.Contact;
import com.phonebook.services.PhonebookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhonebookService phonebook = new PhonebookService();

        phonebook.loadFromCSV("contacts.csv");

        int choice;
        do {
            System.out.println("\n Phonebook Menu ");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Remove Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Save to CSV");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    phonebook.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    Contact c = phonebook.searchContact(name);
                    if (c != null) System.out.println(c);
                    else System.out.println("Contact not found.");
                }
                case 3 -> {
                    System.out.print("Enter name to remove: ");
                    String name = scanner.nextLine();
                    if (phonebook.removeContact(name)) System.out.println("Contact removed successfully.");
                    else System.out.println("Contact not found.");
                }
                case 4 -> phonebook.displayAll();
                case 5 -> {
                    phonebook.saveToCSV("contacts.csv");
                    System.out.println("Contacts saved to contacts.csv");
                }
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 0);

        scanner.close();
    }
}