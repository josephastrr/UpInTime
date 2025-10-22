// Alarm.java
package UpInTime;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    private int duration;
    private Timer timer;
    private AlarmHistory alarmHistory;

    public Alarm(AlarmHistory alarmHistory) {
        this.alarmHistory = alarmHistory;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter alarm name: ");
        String name = scanner.nextLine();
        System.out.print("Enter alarm time in seconds: ");
        duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Alarm: " + name);
                alarmHistory.addAlarm(name, duration);
                timer.cancel();
            }
        }, duration * 1000); // duration in milliseconds
    }
}
