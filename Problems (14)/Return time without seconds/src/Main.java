import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());
        int seconds = time.getSecond();
        if(seconds > 0) {
           time = time.minusSeconds(seconds);
        }
        System.out.println(time);
    }
}