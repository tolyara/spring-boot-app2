package com.springboot.app2.wiki.javacore.multithread;

/**
 *
 *  https://javarevisited.blogspot.com/2018/07/java-multi-threading-interview-questions-answers-from-investment-banks.html
 *
 *  You have thread T1, T2, and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
 *
 *  The answer to this multithreading question is simple it can be achieved by using the join method of Thread class.
 *
 */
public class Joins {

    public static void main(String[] args) throws InterruptedException {
        Task1 t1 = new Task1("111");
        Task1 t2 = new Task1("222");
        Task1 t3 = new Task1("333");

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }

}

class Task1 extends Thread {

    private final String name;

    public Task1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("I am a " + name);
    }

}
