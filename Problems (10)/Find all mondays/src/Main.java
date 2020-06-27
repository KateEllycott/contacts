import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int year = scanner.nextInt();
       int month = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, 1);

        int dayOfWeek = date.getDayOfWeek().getValue();
        int friday = DayOfWeek.MONDAY.getValue();

        //near Friday
        if(dayOfWeek > friday) {
            date = date.plusDays(7 - (dayOfWeek - friday));

        }
        else if (dayOfWeek < friday) {
            date = date.plusDays(friday - dayOfWeek);
        }
        //plus 7 days
        while (date.getMonth().getValue() == month) {
            System.out.println(date);
            date = date.plusDays(7);
        }
    }
}