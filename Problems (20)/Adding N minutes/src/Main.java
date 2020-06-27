import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine());
       long minutes = scanner.nextLong();
       localDateTime = localDateTime.plusMinutes(minutes);
        System.out.println(localDateTime.getYear() + " " + localDateTime.getDayOfYear() +
                " " + localDateTime.toLocalTime());
    }
}