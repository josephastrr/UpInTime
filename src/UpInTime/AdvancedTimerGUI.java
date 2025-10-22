package UpInTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AdvancedTimerGUI {
    private JFrame frame;
    private JButton countdownTimerButton;
    private JButton stopwatchButton;
    private JButton stopwatchStopButton;
    private JButton alarmButton;
    private JButton viewAlarmHistoryButton;
    private JButton exitButton;
    private JLabel label;
    private Timer stopwatchTimer;
    private Timer alarmTimer;
    private int seconds;
    private boolean running;
    private List<String> alarmHistory;

    public AdvancedTimerGUI() {
        frame = new JFrame("Advanced Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        countdownTimerButton = new JButton("Countdown Timer");
        countdownTimerButton.addActionListener(new CountdownTimerListener());
        panel.add(countdownTimerButton);

        stopwatchButton = new JButton("Start Stopwatch");
        stopwatchButton.addActionListener(new StopwatchListener());
        panel.add(stopwatchButton);

        stopwatchStopButton = new JButton("Stop Stopwatch");
        stopwatchStopButton.addActionListener(new StopwatchStopListener());
        panel.add(stopwatchStopButton);

        alarmButton = new JButton("Alarm");
        alarmButton.addActionListener(new AlarmListener());
        panel.add(alarmButton);

        viewAlarmHistoryButton = new JButton("View Alarm History");
        viewAlarmHistoryButton.addActionListener(new ViewAlarmHistoryListener());
        panel.add(viewAlarmHistoryButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitListener());
        panel.add(exitButton);

        label = new JLabel("Select an option:", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(label, BorderLayout.NORTH);

        frame.add(panel, BorderLayout.CENTER);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        alarmHistory = new ArrayList<>();
        stopwatchTimer = new Timer();
        alarmTimer = new Timer();
    }

    private class CountdownTimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String duration = JOptionPane.showInputDialog(frame, "Enter duration in seconds:");
            if (duration != null) {
                try {
                    seconds = Integer.parseInt(duration);
                    if (seconds <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive integer.");
                    } else {
                        running = true;
                        Timer timer = new Timer();
                        timer.scheduleAtFixedRate(new TimerTask() {
                            @Override
                            public void run() {
                                if (running) {
                                    if (seconds > 0) {
                                        label.setText(String.format("%d seconds remaining", seconds));
                                        seconds--;
                                    } else {
                                        label.setText("Time's up!");
                                        timer.cancel();
                                        running = false;
                                    }
                                } else {
                                    timer.cancel();
                                }
                            }
                        }, 0, 1000);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.");
                }
            }
        }
    }

    private class StopwatchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds = 0;
            running = true;
            stopwatchTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (running) {
                        label.setText(String.format("Elapsed time: %d seconds", seconds));
                        seconds++;
                    } else {
                        stopwatchTimer.cancel();
                    }
                }
            }, 0, 1000);
        }
    }

    private class StopwatchStopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            running = false;
            stopwatchTimer.cancel();
            label.setText("Stopwatch stopped.");
        }
    }

    private class AlarmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String duration = JOptionPane.showInputDialog(frame, "Enter alarm time in seconds:");
            if (duration != null) {
                try {
                    seconds = Integer.parseInt(duration);
                    if (seconds <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive integer.");
                    } else {
                        String alarmName = JOptionPane.showInputDialog(frame, "Enter alarm name:");
                        if (alarmName != null && !alarmName.isEmpty()) {
                            alarmTimer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    label.setText("Alarm: " + alarmName);
                                    alarmHistory.add(alarmName);
                                    alarmTimer.cancel();
                                }
                            }, seconds * 1000);
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer.");
                }
            }
        }
    }

    private class ViewAlarmHistoryListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder history = new StringBuilder("Alarm History:\n");
            for (String alarm : alarmHistory) {
                history.append("- ").append(alarm).append("\n");
            }
            JOptionPane.showMessageDialog(frame, history.toString());
        }
    }

    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdvancedTimerGUI();
            }
        });
    }
}