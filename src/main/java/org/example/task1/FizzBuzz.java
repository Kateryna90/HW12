package org.example.task1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzz implements Runnable  {
    private int n;
    private int current;
    private Object lock;

    private BlockingQueue<String> queue;


    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new Object();
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (current <= n) {
            synchronized (lock) {
                if (current % 3 == 0 && current % 5 == 0) {
                    if (name.equals("C")) {
                        queue.add("fizzbuzz");
                        current++;
                    }
                }
                else if (current % 3 == 0) {
                    if (name.equals("A")) {
                        queue.add("fizz");
                        current++;
                    }
                }
                else if (current % 5 == 0) {
                    if (name.equals("B")) {
                        queue.add("buzz");
                        current++;
                    }
                }
                else {
                    queue.add(String.valueOf(current));
                    current++;
                }
            }
        }
    }

    public void number() throws InterruptedException {
        String s = queue.poll();
        if (s != null) {
            System.out.print(s + ", ");
        }
    }
}
