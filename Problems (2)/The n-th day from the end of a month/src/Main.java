import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate lastDate = LocalDate.of(year, month, date.lengthOfMonth());
        System.out.println(lastDate.plusDays(1).minusDays(day));
    }
}