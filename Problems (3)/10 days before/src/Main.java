import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       System.out.println(LocalDate.parse(input).minusDays(10));
    }
}