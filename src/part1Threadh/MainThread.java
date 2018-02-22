package part1Threadh;

import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MainThread {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print("Enter count of people ");
        final int peopleCount = scanner.nextInt();
        System.out.print("Enter max of amount people ");
        final int maxAmount = scanner.nextInt();
        MyThread myThread;
        for (int i = 0; i < peopleCount; i++) {
            System.out.println();
                myThread = new MyThread(maxAmount);
                myThread.start();
        }
    }
}
