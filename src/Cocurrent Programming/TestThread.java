import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        TestThread.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + TestThread.end() + " mills");
        ExecutorService poolExecutor = Executors.newFixedThreadPool(1);




    }

}
