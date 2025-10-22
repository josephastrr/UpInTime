// Stopwatch.java
package UpInTime;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
    private int seconds;
    private Timer timer;
    private boolean running;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stopwatch started. Press Enter to stop.");
        running = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                    System.out.println("Elapsed time: " + seconds + " seconds");
                } else {
                    timer.cancel();
                }
            }
        }, 0, 1000); // 1000 milliseconds = 1 second
        scanner.nextLine();
        running = false;
        System.out.println("Stopwatch stopped.");
    }
}
