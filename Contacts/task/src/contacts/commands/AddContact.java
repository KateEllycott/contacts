package contacts.commands;

import contacts.ContactBook;
import contacts.records.managers.ContactManagerFactory;
import contacts.records.Contact;
import contacts.records.managers.ContactManager;

public class AddContact extends Command {

    public AddContact(ContactBook contactBook) {
        super(contactBook);
    }

    public void execute() {
        System.out.print("Enter the type (person, organization): ");
        String type = Command.inputStringReader();
        ContactManagerFactory contactManagerFactory = new ContactManagerFactory();
        ContactManager contactManager = contactManagerFactory.orgerManager(type);
        if(contactManager == null) {
            System.out.printf("Invalid type!");
            return;
        }
        else {
            Contact contact = contactManager.createContact();
            contactBook.addContact(contact);
            System.out.println("Contact added");
        }
    }
}

