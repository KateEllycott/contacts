package contacts.commands;

import contacts.ContactBook;
import contacts.commands.Command;

public class ShowContact extends Command {
    private int index = -1;
    public ShowContact(ContactBook contactBook) {
        super(contactBook);
    }

    @Override
    void execute() {
        if(contactBook.isEmpty()) {
            System.out.println("Nothing to show. The Contact Book is empty.");
            System.out.println();
            return;
        }
        System.out.print(contactBook.toString());
        listMenu();
    }

    private void listMenu() {
        System.out.println("\n[list] Enter action ([number], back): ");
        String input = Command.inputStringReader();
        if(input.equals("back")) {
            return;
        }
        if(!isInteger(input) || Integer.parseInt(input) > contactBook.countContacts()) {
            System.out.println("Wrong input.");
            return;
        }
        int index = Integer.parseInt(input) - 1;
        this.index = index;
        System.out.print(contactBook.getContact(index));

    }

    public int getIndex() {
        return index;
    }

}
