package contacts;

import contacts.records.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactBook {

    private static final ContactBook INSTANCE = new ContactBook();
    private List<Contact> contacts = new ArrayList<>();
    private ContactBook(){}

    public static ContactBook getInstance() {
        return INSTANCE;
    }

    public int countContacts() {
        return contacts.size();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    public int size() {
        return contacts.size();
    }

    public Contact getContact(int index) {
        return contacts.get(index);

    }

    public void removeContact(int index) {
        contacts.remove(index);
    }

    public Iterator<Contact> contactIterator() {
        return contacts.iterator();
    }

    @Override
    public String toString() {
        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact contact: contacts) {
            stringBuilder.append(String.format("%d. %s\n", index++, contact.getContactName()));
        }
        return stringBuilder.toString();
    }
}
