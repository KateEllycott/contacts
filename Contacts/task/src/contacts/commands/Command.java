package contacts.commands;

import contacts.ContactBook;
import contacts.records.PersonContact;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {
    private static String noOpenParenthesesAfter = "(?!.*\\(.*)";
    private static String  wrappedFirstGroup = "(\\(([A-Za-z0-9])+\\)" + noOpenParenthesesAfter + ")";
    private static String  unwrappedFirstGroup = "(([A-Za-z0-9])+)";
    private static String firstGroupPattern = "(" + wrappedFirstGroup + "|" + unwrappedFirstGroup + ")?";
    private static String  wrappedSecondGroup = "(\\(([A-Za-z0-9]){2,}\\))";
    private static String  unwrappedSecondGroup = "(([A-Za-z0-9]){2,})";
    private static String secondGroupPattern = "((\\s|-)(" + unwrappedSecondGroup +"|" + wrappedSecondGroup +"))?";
    private static String remainingGroupsPattern = "((\\s|-)(" + unwrappedSecondGroup +"))*";
    private static final String PHONE_REGEX = "^\\+?" + firstGroupPattern + secondGroupPattern + remainingGroupsPattern;
    private static final Pattern pattern = Pattern.compile(PHONE_REGEX);
    private static Scanner scanner = new Scanner(System.in);

   public  boolean isValidPhone(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return (!phoneNumber.isEmpty() && matcher.matches());
    }

    public static String inputStringReader() {
        return scanner.nextLine();
    }

    public ContactBook contactBook;

    public Command(ContactBook contactBook) {
        this.contactBook = contactBook;
    }
    abstract void execute();

    public static boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    public boolean _isValidGender(String gender) {
        for(PersonContact.Gender value: PersonContact.Gender.values()) {
            if(value.name().equals(gender)) return true;
        }
        return false;
    }
}
