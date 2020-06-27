import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        System.out.println(localDateTime.minusHours(hour).plusMinutes(minute));
    }
}