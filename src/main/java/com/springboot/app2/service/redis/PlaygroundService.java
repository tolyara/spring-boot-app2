package com.springboot.app2.service.redis;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PlaygroundService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DistributedLocker locker;

    @Autowired
    public PlaygroundService(DistributedLocker locker) {
        this.locker = locker;
    }

    @PostConstruct
    private void setup() {
        CompletableFuture.runAsync(() -> runTask("1", 3000));
        CompletableFuture.runAsync(() -> runTask("2", 1000));
        CompletableFuture.runAsync(() -> runTask("3", 100));
    }

    private void runTask(final String taskNumber, final long sleep) {
        logger.info("Running task : '{}'", taskNumber);

        LockExecutionResult<String> result = locker.lock("some-key", 5, 6, () -> {
            logger.info("Sleeping for '{}' ms", sleep);
            Thread.sleep(sleep);
            logger.info("Executing task '{}'", taskNumber);
            return taskNumber;
        });

        logger.info("Task result : '{}' -> exception : '{}'", result.getResultIfLockAcquired(), result.hasException());
    }

}
