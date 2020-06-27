package contacts.commands;

import contacts.ContactBook;
import contacts.commands.Command;
import contacts.records.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchContact extends Command {

    private List<Integer> results = new ArrayList<>();

    public SearchContact(ContactBook contactBook) {
        super(contactBook);
    }

    @Override
    void execute() {
        String input;
            System.out.printf("Enter search query: ");
            String query = Command.inputStringReader();
            List<Integer> indexes = searchQuery(query);
            results.addAll(indexes);
    }

    private List<Integer> searchQuery(String query) {
            List<Integer> indexes = new ArrayList<>();
            Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);

            for(int i = 0; i < contactBook.size(); i++) {
                Contact contact = contactBook.getContact(i);
                String[] fieldsNames = contact.getFieldsNames();
                StringBuilder stringBuilder = new StringBuilder();
                for(int j = 0; j < fieldsNames.length; j++) {
                    stringBuilder.append(contact.getFieldValue(fieldsNames[j]));
                }
                Matcher matcher = pattern.matcher(stringBuilder.toString());
                if(matcher.find()) {
                    indexes.add(i);
                }
            }
            return indexes;
        }

    public List<Integer> getResults() {
        return results;
    }
}
