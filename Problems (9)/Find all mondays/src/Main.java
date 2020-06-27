import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int months = scanner.nextInt();
        LocalDate date = LocalDate.of(year, 1, 1);

        if(date.getDayOfWeek().getValue() == DayOfWeek.FRIDAY.getValue()) {
            System.out.println("Equals");
            System.out.println(date);
        }
        else if (date.getDayOfWeek().getValue() > DayOfWeek.FRIDAY.getValue()){
            System.out.println("Greater");
            date = date.plusDays(DayOfWeek.FRIDAY.getValue() - (date.getDayOfWeek().getValue() - DayOfWeek.FRIDAY.getValue()));
            System.out.println(date);
        }
        else {
            System.out.println(DayOfWeek.FRIDAY.getValue() - date.getDayOfWeek().getValue());
            date = date.plusDays(DayOfWeek.FRIDAY.getValue() - date.getDayOfWeek().getValue());
            System.out.println(date);
        }

        while((date = date.plusDays(7)).getMonthValue() <= months) {

            System.out.println(date);
        }
    }
}