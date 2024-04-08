package concurrency.tests;

public class LockCounter {
    private int counter;

    public LockCounter() {
        this.counter = 0;
    }

    public synchronized void addOneSleep() throws InterruptedException {
        this.counter += 1;
        System.out.printf("%s: The Counter Before Sleep is %d %n", Thread.currentThread().getName(), this.counter);
        Thread.sleep(600);
        System.out.printf("%s: The Counter After 600 ms Sleep is %d %n", Thread.currentThread().getName(),
                this.counter);
    }

    public synchronized void addHundredSleep() throws InterruptedException {
        this.counter += 100;
        System.out.printf("%s: The Counter Before Sleep is %d %n", Thread.currentThread().getName(), this.counter);
        Thread.sleep(2000);
        System.out.printf("%s: The Counter After 2000 ms Sleep is %d %n", Thread.currentThread().getName(),
                this.counter);
    }

    public synchronized void justPrintingSomethingSync() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Synchronized Counting - %d %n", Thread.currentThread().getName(), i);
        }

    }

    public void justPrintingSomething() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Unsync Counting - %d %n", Thread.currentThread().getName(), i);
        }

    }

    public void addNoSync() {
        for (int i = 0; i < 10; i++) {
            this.counter += 20;
            System.out.printf("%s: Unsync Adding 20 - %d %n", Thread.currentThread().getName(), this.counter);
        }
    }

    public void addInterLock() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                this.counter += 30;
                System.out.printf("%s: Local lock Adding 30 - %d %n", Thread.currentThread().getName(), this.counter);
            }
        }
    }

}
