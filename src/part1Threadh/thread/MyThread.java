package part1Threadh.thread;

import part1Threadh.main.MainThread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    public MyThread(int a){
        amount = a;
    }

    private static int amount;
    private static Random random = new Random();
    private static Semaphore semaphore = new Semaphore(amount);
    private void sem() throws InterruptedException{
        final int readTime = random.nextInt(5) + 1;
        System.out.println("Жду у входа в библиотеку :" + Thread.currentThread().getName());
        semaphore.acquire();
        System.out.println("Вошел в библиотеку :" + Thread.currentThread().getName());
        System.out.println("Читаю книгу " + readTime + " сек: " + Thread.currentThread().getName());
        sleep(readTime*1000);
        semaphore.release();
        System.out.println("Вьшел из библиотеки" + Thread.currentThread().getName());
    }
    @Override
    public void run(){
        try {
            sem();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
