package org.example.task1;

import java.util.function.IntConsumer;


public class FizzBuzzProgram {
    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        FizzBuzz fb = new FizzBuzz(n);

        Runnable printFizz = () -> System.out.print("fizz, ");
        Runnable printBuzz = () -> System.out.print("buzz, ");
        Runnable printFizzBuzz = () -> System.out.print("fizzbuzz, ");
        IntConsumer printNumber = (x) -> System.out.print(x + ", ");

        Thread t1 = new Thread(() -> {
            try {
                fb.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fb.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                fb.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                fb.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
