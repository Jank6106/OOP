import java.lang.management.PlatformLoggingMXBean;
import java.util.Random;

public class MonteHall {
    public static void main(String[] args) {
        Random ran = new Random();
        int n = Integer.parseInt("10");
        int straNoChange = 0;
        int straChange = 0;

        for (int i = 0; i < n; i++) {
            // Random Prize Door
            int prizeDoor = ran.nextInt(3);

            // Player's choices
            int playerChoise = ran.nextInt(3);

            // Host open
            int hostChoise;

            do {
                hostChoise = ran.nextInt(3);
            } while (hostChoise == prizeDoor || hostChoise == playerChoise);

            if (playerChoise == prizeDoor) {
                straNoChange++;
            }

            int remainChoice = 0 + 1 + 2 - hostChoise - playerChoise;
            if (remainChoice == prizeDoor) {
                straChange++;
            }
        }

        System.out.println("Số lần mô phỏng: " + n);
        System.out.println("Chiến lược giữ nguyên: số lần thắng = " + straNoChange);
        System.out.printf("Chiến lược thay đổi: số lần thắng = " + straChange);
    }
}
