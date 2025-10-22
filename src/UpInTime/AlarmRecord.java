// AlarmRecord.java
package UpInTime;

public class AlarmRecord {
    private String name;
    private int duration;

    public AlarmRecord(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
