package contacts.records.managers;

import contacts.records.Contact;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ContactManager {

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
    public static Scanner scanner = new Scanner(System.in);

    public abstract void setFieldValue(Contact contact, String field);

    public abstract String getFieldValue(Contact contact, String field);

    public static void writeConsole(String message) {
        System.out.print(message);
    }

    public static String readConsole() {
        return scanner.nextLine();
    }

    public abstract Contact createContact();

    public boolean isValidPhone(String phoneNumber) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return (!phoneNumber.isEmpty() && matcher.matches());
    }
}
