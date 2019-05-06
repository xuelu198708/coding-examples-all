package examples.util.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by xuelu
 * 2019-04-29.
 */
@Slf4j
public class TestExecutorService {

    ExecutorService single = Executors.newSingleThreadExecutor();

    /**
     * execute方法只能提交runnable，无返回值
     */
    @Test
    public void testExecuteRunnable() {
        single.execute(() -> log.info("Hello runnable"));
    }

    /**
     * submit方法，可以提交runnable或者callable，返回future
     * 如果提交的是runnable，则返回future为null
     */
    @Test
    public void testSubmitRunnable() throws ExecutionException, InterruptedException {
        Future<?> future = single.submit(() -> log.info("Hello runnable"));
        log.info("future is {}", future.get());
    }

    /**
     * submit方法，可以提交runnable或者callable，返回future
     * 如果提交的是callable，则返回callable返回的计算结果
     */
    @Test
    public void testSubmitCallable() throws ExecutionException, InterruptedException {
        Future<String> future = single.submit(() -> {
            log.info("Hello Callable");
            return "Hello Callable！";
        });
        log.info("future is {}", future.get());
        log.info("future isDone: {}", future.isDone());
        log.info("future isCancelled: {}", future.isCancelled());
    }

    /**
     * submit方法，可以提交runnable或者callable，返回future
     * 如果提交的是callable，则返回callable返回的计算结果
     */
    @Test
    public void testSubmitCallableThenCancel() throws ExecutionException, InterruptedException {
        Future<String> future = single.submit(() -> {
            for (int i = 0; i < 10; i++) {
                log.info("{}", i);
                TimeUnit.SECONDS.sleep(1);
            }
            return "Hello Callable！";
        });
        //等3秒，打印任务执行情况
        TimeUnit.SECONDS.sleep(3);
        //执行任务取消
        future.cancel(true);
        log.info("future isDone: {}", future.isDone());
        log.info("future isCancelled: {}", future.isCancelled());
        //如果任务被取消了，仍调用get方法，会抛出异常
        if (!future.isCancelled()) {
            log.info("future is {}", future.get());
        }
    }



    @After
    public void afterTest() throws InterruptedException {
        //等待任务结束，并关闭线程池
        single.awaitTermination(1, TimeUnit.SECONDS);
        single.shutdown();
    }
}
