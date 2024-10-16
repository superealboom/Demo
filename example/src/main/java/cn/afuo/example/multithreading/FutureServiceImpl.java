package cn.afuo.example.multithreading;


import cn.afuo.common.annotation.FunctionLog;
import cn.afuo.example.customer.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Service
@Validated
public class FutureServiceImpl {

    private final CustomerServiceImpl customerService;

    public FutureServiceImpl(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    /**
     * @description: 使用线程池+Future到达异步执行方法汇总到主线程
     * @author: tianci
     * @date: 2024/6/26 14:40
     */
    @FunctionLog(desc = "使用Future")
    public void doAsyncMethod(@Min(1) @Max(5) int quantity) {
        // 创建固定大小为quantity的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(quantity);
        log.info("创建线程池({})成功", quantity);
        try {
            // 存储每个异步方法的Future对象
            List<Future<Void>> futureList = new ArrayList<>();
            for (int i=0;i<quantity;i++) {
                final int index = i; // 为匿名内部类捕获索引值
                Future<Void> future = executorService.submit(() -> {
                    log.info("线程{}:{}开始", Thread.currentThread().getName(), index);
                    customerService.batchInsert();
                    log.info("线程{}:{}结束", Thread.currentThread().getName(), index);
                    return null;
                });
                futureList.add(future);
            }
            // 等待所有任务完成
            for (Future<Void> future : futureList) {
                future.get();
            }
        } catch (Exception e) {
            log.error("FutureService.doAsyncMethod异常", e);
        } finally {
            executorService.shutdown();
        }
    }

}
