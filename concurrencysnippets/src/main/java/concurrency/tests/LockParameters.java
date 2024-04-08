package concurrency.tests;

public class LockParameters {
    public synchronized void lockSharedParameter1(Integer inteTest) throws InterruptedException {
        System.out.printf("%s: The Integer Before Sleep is %d %n", Thread.currentThread().getName(),
                inteTest.intValue());
        Thread.sleep(600);
        inteTest = Integer.valueOf(inteTest.intValue() + 10);
        System.out.printf("%s: The Integer After 600 ms Sleep is %d %n", Thread.currentThread().getName(),
                inteTest.intValue());
    }

    public synchronized void lockSharedParameter2(Integer inteTest) throws InterruptedException {
        System.out.printf("%s: The Integer Before Sleep is %d %n", Thread.currentThread().getName(),
                inteTest.intValue());
        Thread.sleep(1000);
        inteTest = Integer.valueOf(inteTest.intValue() + 100);
        System.out.printf("%s: The Integer After 1000 ms Sleep is %d %n", Thread.currentThread().getName(),
                inteTest.intValue());
    }
}
