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

class T5 implements Runnable {
    private LockCounter counter;

    public T5(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.addNoSync();
    }

}

class T6 implements Runnable {
    private LockCounter counter;

    public T6(LockCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.addInterLock();
    }

}

class T7 implements Runnable {
    private LockParameters parameters;
    private Integer internalInt;

    public T7(LockParameters parameters, Integer internalInt) {
        this.parameters = parameters;
        this.internalInt = internalInt;
    }

    @Override
    public void run() {
        try {
            parameters.lockSharedParameter1(internalInt);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class T8 implements Runnable {
    private LockParameters parameters;
    private Integer internalInt;

    public T8(LockParameters parameters, Integer internalInt) {
        this.parameters = parameters;
        this.internalInt = internalInt;
    }

    @Override
    public void run() {
        try {
            parameters.lockSharedParameter2(internalInt);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        LockCounter lockCounter = new LockCounter();
        Integer internalInt = Integer.valueOf(1);
        LockParameters parameters = new LockParameters();
        Thread t1Thread = new Thread(new T1(lockCounter));
        Thread t2Thread = new Thread(new T2(lockCounter));
        Thread t3Thread = new Thread(new T3(lockCounter));
        Thread t4Thread = new Thread(new T4(lockCounter));
        Thread t5Thread = new Thread(new T5(lockCounter));
        Thread t6Thread = new Thread(new T6(lockCounter));
        Thread t7Thread = new Thread(new T7(parameters, internalInt));
        Thread t8Thread = new Thread(new T8(parameters, internalInt));
        t1Thread.start();
        t2Thread.start();
        t3Thread.start();
        t4Thread.start();
        t5Thread.start();
        t6Thread.start();
        Thread.sleep(2000);
        System.out.println("\n\n\nTesting Parameters Locks");
        t7Thread.start();
        t8Thread.start();
    }
}
