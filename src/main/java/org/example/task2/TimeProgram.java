package org.example.task2;

import java.util.Timer;
import java.util.TimerTask;

public class TimeProgram {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Timer timer = new Timer();
        TimeTask task = new TimeTask(startTime);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        }, 0, 1000);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Минуло 5 секунд");
            }
        }, 5000, 5000);
    }
}
