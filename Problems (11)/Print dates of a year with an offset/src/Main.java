import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.parse(scanner.nextLine());
        int offset = scanner.nextInt();
        int year = date.getYear();

        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}