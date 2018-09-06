package com.kedacom.consumer;

import kafka.utils.ShutdownableThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: YinPeng
 * @Date: 2018/8/31 0031 14:34
 * @Description:
 */
@Component
@Slf4j
public class KafkaConsumerPool {

    /**
     *  线程池
     */
    private ExecutorService executor;

    /**
     * 初始化10个线程
     */
    @PostConstruct
    void init(){
        executor = Executors.newFixedThreadPool(10);
    }

    /**
     * 提交新的消费者
     *
     * @param shutdownableThread
     */
    public void SubmitConsumerPool(ShutdownableThread shutdownableThread) {
        executor.execute(shutdownableThread);
    }

    /**
     * 程序关闭,关闭线程池
     *
     */
    @PreDestroy
    void fin(){
        shutdown();
    }

    public void shutdown() {
        if (executor != null) executor.shutdown();
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                log.info("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            log.info("Interrupted during shutdown, exiting uncleanly");
        }
    }
}
