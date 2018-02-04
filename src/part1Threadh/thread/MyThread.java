package part1Threadh.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    public MyThread(int a){
        if(semaphore == null) semaphore = new Semaphore(a);
    }
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m"; //червоний колір входу в двері
                            // (коли зайшов один - інший не зайде доки не буде виходу(зелений колір)
    private static final String ANSI_GREEN = "\u001B[32m";//зелений  колір виходу з дверей
    private static final String ANSI_BLUE = "\u001B[34m";//blue - доки thread проходить двері

    private static Random random = new Random();
    private static Semaphore semaphore;// = new Semaphore(amount);
    private static Semaphore door = new Semaphore(1);
    private void sem() throws InterruptedException{
        final int readTime = random.nextInt(5) + 1;
        System.out.println("Жду у входа в библиотеку :" + Thread.currentThread().getName());
        semaphore.acquire();

        System.out.println(ANSI_BLUE + "Подошел к двери с улицьі"+ ANSI_RESET + Thread.currentThread().getName());
        door();
        System.out.println(ANSI_GREEN + "Прошел через дверь наружу" + ANSI_RESET + Thread.currentThread().getName());

        System.out.println("Вошел в библиотеку :" + Thread.currentThread().getName());
        System.out.println("Читаю книгу " + readTime + " сек: " + Thread.currentThread().getName());
        sleep(readTime*1000);
        semaphore.release();
        System.out.println("Вьшел из библиотеки" + Thread.currentThread().getName());
    }
    private void door() throws InterruptedException {
        door.acquire();
        System.out.println(ANSI_RED + "Прохожу через дверь внутрь" + ANSI_RESET + Thread.currentThread().getName());
        System.out.println(ANSI_BLUE + "Прошел внутрь двери" + ANSI_RESET + Thread.currentThread().getName());
        sleep(500);
        System.out.println(ANSI_BLUE + "Подошел к двери изнутри" + ANSI_RESET + Thread.currentThread().getName());
        System.out.println(ANSI_BLUE + "Прохожу через дверь наружу" + ANSI_RESET+ Thread.currentThread().getName());
        door.release();
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
