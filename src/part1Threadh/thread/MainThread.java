package part1Threadh.thread;

import part1Threadh.thread.MyThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class MainThread {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Enter count of people");
        final int peopleCount = scanner.nextInt();
        System.out.println("Enter max of amount people");
        final int maxAmount = scanner.nextInt();
//        MyThread.amount = maxAmount;
        MyThread myThread;
        for (int i = 0; i < peopleCount; i++) {
            System.out.println();
                myThread = new MyThread(maxAmount);
                myThread.start();
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}
