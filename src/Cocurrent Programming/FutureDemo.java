import java.util.concurrent.*;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("In MyCallable 做一些耗时的任务...");
        Thread.sleep(5000);
        return "OK";
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("In MyCallable 做一些耗时的任务...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("MyCallable()");
        System.out.println("得到异步任务返回结果：" + future.get());
        System.out.println("Completed!");

        Future future1 = executorService.submit(new MyRunnable());
        System.out.println("MyRunnable()");
        System.out.println("future1.get()" + future1.get());
        System.out.println("Completed!");


    }
}


