package contacts.records.managers;

import contacts.records.Contact;
import contacts.records.PersonContact;
import contacts.records.managers.ContactManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonContactManager extends ContactManager {

    public Contact createContact() {
        ContactManager.writeConsole("Enter the firstName: ");
        String firstName = ContactManager.readConsole();
        ContactManager.writeConsole("Enter the lastName: ");
        String lastName = ContactManager.readConsole();

        PersonContact.ContactBuilder builder;
        builder = new PersonContact.ContactBuilder(firstName, lastName, this);

        ContactManager.writeConsole("Enter the birth date: ");
        String birthDate = ContactManager.readConsole();
        if(PersonContact.isValidDate(birthDate)) {
            builder.setBirthDate(birthDate);
        }
        else {
            writeConsole(String.format("Bad birth date!\n"));
        }

        writeConsole("Enter the gender (M, F): ");
        String gender = ContactManager.readConsole();
        if(isValidGender(gender)) {
            builder = builder.setGender(gender);
        }
        else {
            writeConsole(String.format("Bad gender!\n"));
        }
        writeConsole( "Enter the number: ");
        String phoneNumber = ContactManager.readConsole();
        if(isValidPhone(phoneNumber)) {
            builder = builder.setPhoneNumber(phoneNumber);
        }
        else {
            writeConsole(String.format("Wrong number format!\n"));
        }

        PersonContact contact = builder.build();
        return contact;
    }

    public void setFieldValue(Contact contact, String field) {
        PersonContact personContact  = (PersonContact) contact;
        switch (field) {
            case "name":
                writeConsole("Enter the name: ");
                personContact.setFirstName(readConsole());
                break;
            case "surname":
                writeConsole("Enter the surname: ");
                personContact.setLastName(readConsole());
                break;
            case "birth":
                writeConsole("Enter birth date in format YYYY-MM-DD: ");
                String birthDate = readConsole();
                if(PersonContact.isValidDate(birthDate)) {
                    personContact.setBirthDate(birthDate);
                }
                else {
                    writeConsole(String.format("Bad birth date!\n"));
                    return;
                }
                break;
            case "number":
                System.out.println("Enter number:");
                String phoneNumber = readConsole();
                if(isValidPhone(phoneNumber)) {
                    contact.setPhoneNumber(phoneNumber);
                    break;
                }
                else {
                    writeConsole("invalid input!");
                    return;
                }
            case "gender":
                writeConsole("Enter the gender: ");
                String gender = ContactManager.readConsole();
                if (isValidGender(gender)) {
                    personContact.setGender(gender);
                }
                break;
            default: {
                writeConsole("invalid input!");
                return;
            }
        }
        System.out.println("The record updated!");
    }

    public String getFieldValue(Contact contact, String field) {
        PersonContact personContact  = (PersonContact) contact;
        switch (field) {
            case "name":
                return personContact.getFirstName();
            case "surname":
                return personContact.getLastName();
            case "birth":
                return personContact.getBirthDate();
            case "number":
                return personContact.getPhoneNumber();
            case "gender":
                return personContact.getGender();
            default: {
                return null;
            }
        }
    }

    public boolean isValidGender(String gender) {
        for(PersonContact.Gender value: PersonContact.Gender.values()) {
            if(value.name().equals(gender)) return true;
        }
        return false;
    }

    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
