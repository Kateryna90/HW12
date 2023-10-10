package org.example.task2;

public class TimeTask implements Runnable {
    private long startTime;
    public TimeTask(long startTime) {
        this.startTime = startTime;
    }

    @Override
    public void run() {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Час, що минув від початку програми: " + elapsedTime + " секунд");

    }
}
