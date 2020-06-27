import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
        int days = Integer.parseInt(scanner.next());
        int hours = Integer.parseInt(scanner.next());

        System.out.println(dateTime.plusDays(days).minusHours(hours));
    }
}