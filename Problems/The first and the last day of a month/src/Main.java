import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        String month = scanner.nextLine();
        LocalDate date = LocalDate.parse(year + "-" + month + "-" + "1")
        System.out.println(date.);
    }
}