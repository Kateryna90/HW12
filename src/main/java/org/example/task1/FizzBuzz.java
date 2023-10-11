package org.example.task1;

import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int curr = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }


    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 == 0 && curr % 5 != 0) {
                printFizz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 != 0 && curr % 5 == 0) {
                printBuzz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curr <= n) {
            if (curr % 15 == 0) {
                printFizzBuzz.run();
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }


    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            if (curr % 3 != 0 && curr % 5 != 0) {
                printNumber.accept(curr);
                curr++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

