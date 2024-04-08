package concurrency.tests;

/**
 * InnerApp
 */
class T1 implements Runnable {
    private LockCounter counter;

    public T1(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.addOneSleep();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class T2 implements Runnable {
    private LockCounter counter;

    public T2(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            counter.addHundredSleep();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class T3 implements Runnable {
    private LockCounter counter;

    public T3(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.justPrintingSomethingSync();
    }

}

class T4 implements Runnable {
    private LockCounter counter;

    public T4(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.justPrintingSomething();
    }

}

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        LockCounter lockCounter = new LockCounter();
        Thread t1Thread = new Thread(new T1(lockCounter));
        Thread t2Thread = new Thread(new T2(lockCounter));
        Thread t3Thread = new Thread(new T3(lockCounter));
        Thread t4Thread = new Thread(new T4(lockCounter));
        t1Thread.start();
        t2Thread.start();
        t3Thread.start();
        t4Thread.start();
    }
}
