import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println("我要等一个新信号" + this);
                    condition.await(); //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("拿到一个信号！！" + this);
                reentrantLock.unlock();
            }
        }, "waitThread1");

        thread.start();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        reentrantLock.lock();
                        try {
                            System.out.println("我拿到锁了");
                            System.out.println("Signal Thread begin to sleep");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        condition.signalAll();
                        System.out.println("我发了一个信号！！");
                        reentrantLock.unlock();
                    }
                }, "signalThread");

        thread1.start();
    }
}
