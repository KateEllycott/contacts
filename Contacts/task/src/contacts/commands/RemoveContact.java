package contacts.commands;

import contacts.ContactBook;
import contacts.commands.Command;

public class RemoveContact extends Command {

    private final int index;

    public RemoveContact(ContactBook contactBook, int index) {
        super(contactBook);
        this.index = index;
    }

    @Override
    void execute() {
        contactBook.removeContact(index );

        System.out.println("The record removed!");
        System.out.println();
    }
}
