// AlarmHistory.java
package UpInTime;

import java.util.ArrayList;

public class AlarmHistory {
    private ArrayList<AlarmRecord> alarmRecords;

    public AlarmHistory() {
        alarmRecords = new ArrayList<>();
    }

    public void addAlarm(String name, int duration) {
        alarmRecords.add(new AlarmRecord(name, duration));
    }

    public void viewHistory() {
        System.out.println("Alarm History:");
        for (AlarmRecord record : alarmRecords) {
            System.out.println(record.getName() + ": " + record.getDuration() + " seconds");
        }
    }
}

