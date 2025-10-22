import java.util.Scanner;

public class TimerExample {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah detik: ");
        int totalSeconds = scanner.nextInt();

        while (totalSeconds >= 0) {
            int minutes = totalSeconds / 60;
            int seconds = totalSeconds % 60;

            System.out.printf("\rTimer: %02d:%02d", minutes, seconds);

            Thread.sleep(1000); // jeda 1 detik
            totalSeconds--;
        }

        System.out.println("\nWaktu Habis!");
        scanner.close();
    }
}
