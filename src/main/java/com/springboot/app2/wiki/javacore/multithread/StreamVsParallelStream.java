package com.springboot.app2.wiki.javacore.multithread;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 *
 */
public class StreamVsParallelStream {

    public static void main(String[] args) throws InterruptedException {
        int threads = 5;

        Callable<String> task = () -> {
            Thread.sleep(1000);
            String name = Thread.currentThread().getName();
            System.out.println(name + " finished");
            return name;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<Callable<String>> tasks = IntStream.rangeClosed(1, threads).mapToObj(i -> task).collect(Collectors.toList());

        /*
            sync (blocking)
         */
//        List<String> result = tasks.stream().map(taska -> {

        /*
            async
         */
        List<String> result = tasks.parallelStream().map(taska -> {

            try {
                return executorService.submit(taska).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        executorService.shutdown();
    }

}

