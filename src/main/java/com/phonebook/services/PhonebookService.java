package com.phonebook.services;
import java.util.*;
import java.io.*;
import com.phonebook.model.Contact;

public class PhonebookService {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact c) {
        contacts.put(c.getName(), c);
    }

    public Contact searchContact(String name) {
        return contacts.get(name);
    }

    public boolean removeContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            return true;
        }
        return false;
    }

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Phonebook is empty.");
            return;
        }
        for (Contact c : contacts.values()) {
            System.out.println(c);
        }
    }

    public void saveToCSV(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Contact c : contacts.values()) {
                writer.write(c.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void loadFromCSV(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Contact c = new Contact(parts[0], parts[1], parts[2]);
                    contacts.put(c.getName(), c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }
}