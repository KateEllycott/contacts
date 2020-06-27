package contacts.records.managers;

import contacts.records.Contact;
import contacts.records.OrganizationContact;

public class OrganizationContactManager extends ContactManager {

    @Override
    public Contact createContact() {
        ContactManager.writeConsole("Enter the organization: ");
        String organization = ContactManager.readConsole();
        ContactManager.writeConsole("Enter the address: ");
        String address = ContactManager.readConsole();
        OrganizationContact._OrganizationContactBuilder builder =
                new OrganizationContact._OrganizationContactBuilder(organization, address,this);

        ContactManager.writeConsole("Enter the number:");
        String phoneNumber = ContactManager.readConsole();
        if(isValidPhone(phoneNumber)) {
            builder.setPhoneNumber(phoneNumber);
        }
        else {
            ContactManager.writeConsole("Wrong number format!");
        }
        return builder.build();
    }

    @Override
    public void setFieldValue(Contact contact, String field) {
        OrganizationContact organizationContact  = (OrganizationContact) contact;
        switch (field) {
            case "name":
                ContactManager.writeConsole("Enter the name: ");
                organizationContact.setOrganizationName(ContactManager.readConsole());
                break;
            case "address":
                ContactManager.writeConsole("Enter the address: ");
                organizationContact.setAddress(ContactManager.readConsole());
                break;
            case "number":
                System.out.println("Enter number:");
                String phoneNumber = ContactManager.readConsole();
                if(isValidPhone(phoneNumber)) {
                    contact.setPhoneNumber(phoneNumber);
                    break;
                }
                else {
                    ContactManager.writeConsole("invalid input!");
                    return;
                }
            default: {
                System.out.println("invalid input!");
                return;
            }
        }
        System.out.println("The record updated!");
    }

    @Override
    public String getFieldValue(Contact contact, String field) {
        OrganizationContact organizationContact  = (OrganizationContact) contact;
        switch (field) {
            case "name":
                return organizationContact.getContactName();
            case "address":
                return organizationContact.getAddress();
            case "number":
                return  organizationContact.getPhoneNumber();
            default: {
                System.out.println("invalid input!");
                return null;
            }
        }
    }
}
