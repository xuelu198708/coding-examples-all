package examples.util.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by xuelu
 * 2019-05-09.
 */
@Slf4j
public class TestCyclicBarrier {

    @Test
    public void test_await() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(barrier);
            Thread thread = new Thread(worker);
            thread.start();
        }
        Thread.currentThread().join();
    }

    @Test
    public void test_barrier_with_action() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> log.info(Thread.currentThread().getName()));
        for (int i = 0; i < 5; i++) {
            Worker worker = new Worker(barrier);
            Thread thread = new Thread(worker);
            thread.start();
        }
        Thread.currentThread().join();
    }

    static class Worker implements Runnable {

        private CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            log.info("start method run!");
            try {
                TimeUnit.SECONDS.sleep(1);
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                log.info("done method run!");
            }

            //do another cycle

            try {
                barrier.await();
                log.info("start method run again!");
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                log.info("done method run again!");
            }

        }
    }

}
