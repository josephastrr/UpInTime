// TimerSettings.java
package UpInTime;

import java.util.Scanner;

public class TimerSettings {
    private int duration;
    private int interval;

    public void setDuration() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter duration in seconds: ");
        duration = scanner.nextInt();
    }

    public void setInterval() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter interval in seconds: ");
        interval = scanner.nextInt();
    }

    public int getDuration() {
        return duration;
    }

    public int getInterval() {
        return interval;
    }
}
