// AdvancedTimer.java
package UpInTime;

import java.util.Scanner;

public class AdvancedTimer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        AlarmHistory alarmHistory = new AlarmHistory();

        while (running) {
            System.out.println("Advanced Timer");
            System.out.println("1. Countdown Timer");
            System.out.println("2. Stopwatch");
            System.out.println("3. Alarm");
            System.out.println("4. View Alarm History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    CountdownTimer countdownTimer = new CountdownTimer();
                    countdownTimer.start();
                    break;
                case 2:
                    Stopwatch stopwatch = new Stopwatch();
                    stopwatch.start();
                    break;
                case 3:
                    Alarm alarm = new Alarm(alarmHistory);
                    alarm.start();
                    break;
                case 4:
                    alarmHistory.viewHistory();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }

            if (running) {;
                scanner.nextLine();
            }
        }
    }
}

