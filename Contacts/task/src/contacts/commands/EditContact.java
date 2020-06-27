package contacts.commands;

import contacts.ContactBook;
import contacts.records.Contact;

public class EditContact extends Command {

    private final int index;

    public EditContact(ContactBook contactBook, int index) {
        super(contactBook);
        this.index = index;
    }

    @Override
    void execute() {
        Contact contact = contactBook.getContact(index );

        System.out.printf("Select a field (%s)", contact.getFields());
        String field = Command.inputStringReader();
        System.out.printf("Enter %s: ", field);
        contact.editField(field);
    }
}
