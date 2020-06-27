import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int yearDay = scanner.nextInt();
        LocalDate date = LocalDate.ofYearDay(year, yearDay);

        System.out.println(date.lengthOfMonth() == date.getDayOfMonth());

    }
}