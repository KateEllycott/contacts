package contacts;

import contacts.commands.*;

import java.util.List;
import java.util.Scanner;


public class Main {
    private final ContactBook contactBook = ContactBook.getInstance();
    private final CommandManager commandManager = new CommandManager();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        new Main().mainMenu();
    }

    private void mainMenu() {
        String input = "";

        do {
            System.out.println();
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            input = inputStringReader();

            switch (input) {
                case "add":
                    AddContact addContact = new AddContact(contactBook);
                    commandManager.setCommand(addContact);
                    commandManager.executeCommand();
                    break;
                case "count":
                    outputStringWriter(String.format("The Phone Book has %d records", contactBook.countContacts()));
                    break;
                case "list":
                    ShowContact showContact = new ShowContact(contactBook);
                    commandManager.setCommand(showContact);
                    commandManager.executeCommand();
                    if(showContact.getIndex() >= 0) {
                        recordMenu(showContact.getIndex());
                    }
                    break;
                case "exit":
                    input = "exit";
                    break;
                case "search":
                    SearchContact searchContact = new SearchContact(contactBook);
                    commandManager.setCommand(searchContact);
                    commandManager.executeCommand();
                    searchMenu(searchContact.getResults());
                    break;
                default: {
                    outputStringWriter("no such action!");
                    break;
                }
            }
        } while (!input.equals("exit"));
    }

    public static String inputStringReader() {
        return scanner.nextLine();
    }

    public static void outputStringWriter(String output) {
        System.out.printf(output);
    }

    private void searchMenu(List<Integer> indexes) {

        System.out.printf("Found %d results\n", indexes.size());
        if(indexes.size() == 0) return;

        for (int i = 0; i < indexes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, contactBook.getContact(indexes.get(i)).getContactName());
        }

        String input;
        do {
            outputStringWriter("[search] Enter action ([number], back, again): ");
            input = inputStringReader();
            switch (input) {
                case "back":
                    return;
                case "again":
                    SearchContact searchContact = new SearchContact(contactBook);
                    commandManager.setCommand(searchContact);
                    commandManager.executeCommand();
                    searchMenu(searchContact.getResults());
                    break;
                default: {
                    if (Command.isInteger(input) && Integer.parseInt(input) <= indexes.size()) {
                        contactBook.getContact(Integer.parseInt(input) - 1).toString();
                        recordMenu(Integer.parseInt(input) - 1);
                    }
                }
            }

        } while (input.equals("back"));
    }

    private void recordMenu(int index) {
        String input;
        String status = "";

        do {
            System.out.println();
            outputStringWriter("[record] Enter action (edit, delete, menu): ");
            input = inputStringReader();
            switch (input) {
                case "edit":
                    Command editContact = new EditContact(contactBook, index);
                    commandManager.setCommand(editContact);
                    commandManager.executeCommand();
                    break;
                case "delete":
                    Command removeContact = new RemoveContact(contactBook, index);
                    commandManager.setCommand(removeContact);
                    commandManager.executeCommand();
                    status = "exit";
                    break;
                case "menu":
                    return;
                default: {
                    outputStringWriter("Invalid input!");
                }
            }
        } while (!status.equals("exit"));
    }
}
