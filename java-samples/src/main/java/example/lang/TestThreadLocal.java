package example.lang;

/**
 * Created by xuelu
 * 2019/10/24.
 */
public class TestThreadLocal {

    private ThreadLocal<String> threadName = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                TestThreadLocal testThreadLocal = new TestThreadLocal();
                testThreadLocal.threadName.set(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(testThreadLocal.threadName.get());
            });
            thread.setName("thread-"+i);
            thread.start();
        }
        Thread.sleep(3000);
    }
}
