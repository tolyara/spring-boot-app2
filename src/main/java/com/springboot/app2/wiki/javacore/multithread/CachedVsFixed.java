package com.springboot.app2.wiki.javacore.multithread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * https://www.baeldung.com/java-executors-cached-fixed-threadpool
 *
 * The cached thread pool configuration caches the threads (hence the name) for a short amount of time to reuse them for other tasks.
 * As a result, it works best when we're dealing with a REASONABLE number of short-lived tasks.
 *
 * The key here is “reasonable” and “short-lived”. To clarify this point, let's evaluate a scenario where cached pools aren't a good fit.
 * Here we're going to submit one million tasks each taking 100 micro-seconds to finish:
 *
 */
public class CachedVsFixed {

    public static void main(String[] args) throws InterruptedException {
        Callable<String> task = () -> {
            long oneHundredMicroSeconds = 100_000;
            long startedAt = System.nanoTime();
            while (System.nanoTime() - startedAt <= oneHundredMicroSeconds);

            return "Done";
        };

        ExecutorService cachedPool = Executors.newCachedThreadPool();
        List<Callable<String>> tasks = IntStream.rangeClosed(1, 1_000_000).mapToObj(i -> task).collect(Collectors.toList());
        List<Future<String>> result = cachedPool.invokeAll(tasks);
    }

}

/**
 *
 * This is going to create a lot of threads that translate to unreasonable memory usage, and even worse, lots of CPU context switches.
 * Both of these anomalies would hurt the overall performance significantly.
 *
 * Therefore, we should avoid this thread pool when the execution time is unpredictable, like IO-bound tasks.
 *
 */
