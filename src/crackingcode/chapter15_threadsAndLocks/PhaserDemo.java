package crackingcode.chapter15_threadsAndLocks;

import java.util.concurrent.*;

class PhaserDemo {
    public static void main(String args[]) {

        final int step = 3;
        Integer val = 0;

        Phaser phsr = new Phaser(1);
        int curPhase;
        System.out.println("Starting");
        new MyThread(phsr, "thread0",step, 3,val);
        new MyThread(phsr, "thread1",step, 5,val);

        for(int i=0; i<step; i++) {
            // Wait for all threads to complete phase one.
            curPhase = phsr.getPhase();
            phsr.arriveAndAwaitAdvance();
            System.out.println("Phase " + curPhase + " Complete");
        }

        // Deregister the main thread.
        curPhase =  phsr.getPhase();
        phsr.arriveAndDeregister();
        if(phsr.isTerminated())
            System.out.println("The Phaser is terminated");
    } }
// A thread of execution that uses a Phaser.
class MyThread implements Runnable {
    Phaser phsr;
    String name;
    int steps;
    int div;
    Integer val;

    MyThread(Phaser p, String n, int steps, int div, Integer val) {
        phsr = p;
        name = n;
        this.steps = steps;
        this.div = div;
        this.val = val;
        phsr.register();
        new Thread(this).start();
    }
    public void run() {
        for(int i=0; i<steps; i++) {
            System.out.println("Thread " + name + " Beginning Phase "+i);
            if(i==steps-1) {
                phsr.arriveAndDeregister(); // Signal arrival and deregister.
            } else {
                phsr.arriveAndAwaitAdvance(); // Signal arrival.
            }
            // Pause a bit to prevent jumbled output. This is for illustration
            // only. It is not required for the proper operation of the phaser.
            try {
                Thread.sleep(10);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}