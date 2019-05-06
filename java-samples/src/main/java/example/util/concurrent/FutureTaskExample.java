package example.util.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by xuelu
 * 2019-04-28.
 */
@Slf4j
public class FutureTaskExample {
    public static void main(String[] args) throws InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            for (int i = 0; i < 10; i++) {
                log.info("{}", i);
                TimeUnit.SECONDS.sleep(1);
            }
            return "success";
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(futureTask);

        TimeUnit.SECONDS.sleep(3);
        //通过cancel方法可以取消操作
        futureTask.cancel(true);
        log.info("isCancelled: " + futureTask.isCancelled());
        log.info("isDone: " + futureTask.isDone());
        TimeUnit.SECONDS.sleep(2);
        executor.shutdown();
    }
}
