package contacts.records;

import contacts.records.managers.ContactManager;

public abstract class  ContactFactory {
    public enum ContactType {
        PERSON,
        ORGANIZATION
    }
    public abstract ContactManager createContactManager(ContactType type);

    public  ContactManager orgerManager(String type) {
        for(ContactType value: ContactType.values()) {
           if (type.equalsIgnoreCase(value.name())) {
               return createContactManager(ContactType.valueOf(type.toUpperCase()));
           }
        }
        return null;
    }
}
