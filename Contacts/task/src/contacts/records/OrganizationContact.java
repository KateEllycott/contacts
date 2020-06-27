package contacts.records;

import contacts.records.managers.ContactManager;

public class OrganizationContact extends Contact {

    private String organizationName;
    private String address;
    private final String[] fields = {"name", "address", "number"};

   private OrganizationContact(_OrganizationContactBuilder builder) {
        super(builder.getPhoneNumber(), builder.getContactManager() );
        this.organizationName = builder.getOrganizationName();
        this.address = builder.getAddress();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        setLastModified();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        setLastModified();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Organization name: %s\n", getOrganizationName()));
        builder.append(String.format("Address: %s\n", getAddress()));
        builder.append(super.toString());
        return builder.toString();
    }

    public String getContactName() {
       return organizationName;
    }

    public static class _OrganizationContactBuilder {
        private String organizationName;
        private String address;
        private String phoneNumber = Contact.DEFAULT_PHONE_NUMBER;
        private ContactManager contactManager;

        public String getOrganizationName() {
            return organizationName;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public ContactManager getContactManager() {
            return contactManager;
        }

        public _OrganizationContactBuilder(String organizationName, String address, ContactManager contactManager) {
            this.organizationName = organizationName;
            this.address = address;
            this.contactManager = contactManager;
        }

        public _OrganizationContactBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public OrganizationContact build() {
            return new OrganizationContact(this);
        }
    }

    @Override
    public String getFields() {
        return "name, address, number";
    }

    @Override
    public String getFieldValue(String fieldName) {
        switch (fieldName) {
            case "name":
                return getOrganizationName();
            case "address":
                return getAddress();
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
