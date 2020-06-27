import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int firstDay = scanner.nextInt();
        int secondDay = scanner.nextInt();
        int thirdDay = scanner.nextInt();

        LocalDate date = LocalDate.of(year, 1, 1);

        Stream.of(firstDay, secondDay, thirdDay).forEach(day -> {
            if(day <= 365) {
                System.out.println(LocalDate.ofYearDay(year, day));
            }
            else if (date.isLeapYear() && day <= 366) {
                System.out.println(LocalDate.ofYearDay(year, day));
            }
        });
    }
}