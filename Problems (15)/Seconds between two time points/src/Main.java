import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time1 = LocalTime.parse(scanner.nextLine());
        LocalTime time2 = LocalTime.parse(scanner.nextLine());

        System.out.println(Math.abs(time1.toSecondOfDay() - time2.toSecondOfDay()));
    }
}