import java.util.*;

public class SimpleClock {
    public static void main(String[] args) {
        while (true) {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int min = cal.get(Calendar.MINUTE);
            int sec = cal.get(Calendar.SECOND);

            System.out.printf("Current Time: %02d:%02d:%02d\r", hour, min, sec);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted.");
            }
        }
    }
}
