package contacts.records;

import contacts.records.managers.ContactManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PersonContact extends Contact {

    public enum Gender {
        M,
        F,
    }
    private static final String DEFAULT_GENDER = "[no data]";
    private static  final String DEFAULT_BIRTH_DATE = "[no data]";
    private String firstName;
    private String lastName;
    private String birthDate ;
    private String gender;
    private final String[] fields = {"name", "surname", "birth", "gender", "number"};

    private PersonContact(ContactBuilder builder
    ) {
        super(builder.getPhoneNumber(), builder.getContactManager());
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setLastModified();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setLastModified();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        setLastModified();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        setLastModified();
    }

    public String getContactName() {
        return getFirstName() + " " + getLastName();
    }

    public static class ContactBuilder {

        private final String firstName;
        private final String lastName;
        private String  birthDate = PersonContact.DEFAULT_BIRTH_DATE;
        private String gender = PersonContact.DEFAULT_GENDER;
        private String phoneNumber = Contact.DEFAULT_PHONE_NUMBER;
        private ContactManager contactManager;

        public ContactBuilder(String firstName, String lastName, ContactManager contactManage) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.contactManager = contactManage;
        }

        public ContactBuilder setBirthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public ContactBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public ContactBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public ContactManager getContactManager() {
            return contactManager;
        }

        public PersonContact build() {
            return  new PersonContact(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Name: %s\n", getFirstName()));
        builder.append(String.format("Surname: %s\n", getLastName()));
        builder.append(String.format("Birth date: %s\n", getBirthDate()));
        builder.append(String.format("Gender: %s\n", getGender()));
        builder.append(super.toString());
        return builder.toString();
    }

    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    @Override
    public String getFields() {
        return "name, surname, birth, gender, number";
    }

    @Override
    public String getFieldValue(String fieldName) {
                switch (fieldName) {
                    case "name":
                        return getFirstName();
                    case "surname":
                return getLastName();
            case "birth":
                return getBirthDate();
            case "gender":
                return getGender();
            case "number":
                return getPhoneNumber();
            default: {
                return null;
            }
        }
    }

    @Override
    public String[] getFieldsNames() {
        return fields;
    }
}
