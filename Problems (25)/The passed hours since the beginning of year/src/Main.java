import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime firstDayOfTheYear = (localDateTime.with(TemporalAdjusters.firstDayOfYear()).with(LocalTime.MIDNIGHT));
        System.out.println(firstDayOfTheYear.until(localDateTime, ChronoUnit.HOURS));
    }
}