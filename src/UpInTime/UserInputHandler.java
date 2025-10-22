// UserInputHandler.java
package UpInTime;

import java.util.Scanner;

public class UserInputHandler {
    private Scanner scanner;

    public UserInputHandler() {
        scanner = new Scanner(System.in);
    }

    public int getOption() {
        System.out.println("Advanced Timer");
        System.out.println("1. Countdown Timer");
        System.out.println("2. Stopwatch");
        System.out.println("3. Alarm");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }

    public int getDuration() {
        System.out.print("Enter duration in seconds: ");
        return scanner.nextInt();
    }

    public int getInterval() {
        System.out.print("Enter interval in seconds: ");
        return scanner.nextInt();
    }
}
