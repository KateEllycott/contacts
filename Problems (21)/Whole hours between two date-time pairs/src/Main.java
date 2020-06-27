import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       LocalDateTime date1 = LocalDateTime.parse(scanner.nextLine());
       LocalDateTime date2 = LocalDateTime.parse(scanner.nextLine());

       if(date1.getDayOfMonth() > date2.getDayOfMonth()) {
           System.out.println(date2.until(date1, ChronoUnit.HOURS));
       }
       else {
           System.out.println(date1.until(date2, ChronoUnit.HOURS));
       }
    }
}