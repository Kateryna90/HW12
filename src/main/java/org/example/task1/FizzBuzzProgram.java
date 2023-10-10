package org.example.task1;

public class FizzBuzzProgram {
    public static void main(String[] args) throws InterruptedException {

        int n = 15;


        FizzBuzz fizzBuzz = new FizzBuzz(n);


        Thread A = new Thread(fizzBuzz, "A");
        Thread B = new Thread(fizzBuzz, "B");
        Thread C = new Thread(fizzBuzz, "C");
        Thread D = new Thread(fizzBuzz, "D");


        A.start();
        B.start();
        C.start();
        D.start();


        A.join();
        B.join();
        C.join();
        D.join();


        System.out.println("\nРезультат: ");
        for (int i = 1; i <= n; i++) {
            fizzBuzz.number();
        }
    }
}
