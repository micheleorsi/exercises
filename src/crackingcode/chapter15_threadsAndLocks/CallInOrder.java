package crackingcode.chapter15_threadsAndLocks;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CallInOrder {

    void runner() {
        Foo f = new Foo();

        MyThread t1 = new MyThread(f,1);
        MyThread t2 = new MyThread(f,2);
        MyThread t3 = new MyThread(f,3);

        t3.start();
        t2.start();

        t1.start();
    }



    public static void  main(String args[]) {
        CallInOrder c = new CallInOrder();
        c.runner();
    }


    class Foo {
        Semaphore l1;
        Semaphore l2;

        public Foo() {
            l1 = new Semaphore(1);
            l2 = new Semaphore(1);

            try {
                l1.acquire();
                l2.acquire();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void first() {
            System.out.println("first");
            l1.release();
        }

        public void second() {
            try {
                l1.acquire();
                l1.release();
                System.out.println("second");
                l2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void third() {
            try {
                l2.acquire();
                l2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("third");
        }
    }

    class MyThread extends Thread {
        private Foo foo;
        private int n;



        public MyThread(Foo foo, int n) {
            super();
            this.foo = foo;
            this.n = n;
        }

        @Override
        public void run() {
            switch (n) {
                case 1: foo.first(); break;
                case 2: foo.second(); break;
                case 3: foo.third(); break;
                default: new RuntimeException();
            }

        }
    }
}
