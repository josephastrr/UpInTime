// CountdownTimer.java
package UpInTime;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    private int duration;
    private Timer timer;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter duration in seconds: ");
        duration = scanner.nextInt();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int seconds = duration;

            @Override
            public void run() {
                if (seconds > 0) {
                    System.out.println(seconds + " seconds remaining");
                    seconds--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }
        }, 0, 1000); // 1000 milliseconds = 1 second
    }
}
