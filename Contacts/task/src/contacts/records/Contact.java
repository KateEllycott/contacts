package contacts.records;

import contacts.records.managers.ContactManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contact {

    private static final String DATE_FORMATTER = "yyyy-MM-dd'T'HH:mm";
    protected static final String DEFAULT_PHONE_NUMBER = "[no number]";
    private String phoneNumber;
    private final String created;
    private String lastModified;
    private final ContactManager contactManager;

    protected Contact(String phoneNumber, ContactManager contactManager) {
        created = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
        lastModified = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
        this.phoneNumber = phoneNumber;
        this.contactManager = contactManager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        setLastModified();
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified() {
        this.lastModified = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    public String getCreated() {
        return created;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Number: %s\n", getPhoneNumber()));
        builder.append(String.format("Time created: %s\n", getCreated()));
        builder.append(String.format("Time last edit: %s\n", getLastModified()));
        return builder.toString();
    }

    public abstract String getContactName();

    public abstract String getFields();

    public void editField(String field) {
        contactManager.setFieldValue(this, field);
    }

    public abstract String getFieldValue(String fieldName);

    public  abstract String[] getFieldsNames();
}


