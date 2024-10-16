package cn.afuo.example.multithreading;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AsyncServiceTest {

    @Autowired
    private FutureServiceImpl futureService;
    @Autowired
    private CompletableFutureServiceImpl completableFutureService;
    @Autowired
    private CountDownLatchServiceImpl countDownLatchService;

    @Test
    public void testFuture() {
        futureService.doAsyncMethod(5);
    }

    @Test
    public void testCompletableFuture() {
        completableFutureService.doAsyncMethod(3);
    }

    @Test
    public void testCountDownLatch() {
        countDownLatchService.doAsyncMethod(5);
    }

    @Test
    public void testCompletableFutureAboutSupply() {
        completableFutureService.doAsyncMethodAboutSupply(3);
    }

}