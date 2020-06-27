package contacts.records.managers;

import contacts.records.ContactFactory;
import contacts.records.managers.ContactManager;
import contacts.records.managers.OrganizationContactManager;
import contacts.records.managers.PersonContactManager;

public class ContactManagerFactory extends ContactFactory {
    @Override
    public ContactManager createContactManager(ContactFactory.ContactType type){
        switch (type) {
            case PERSON:
                return new PersonContactManager();
            case ORGANIZATION:
                return new OrganizationContactManager();
            default: {
                return null;
            }
        }
    }
}
