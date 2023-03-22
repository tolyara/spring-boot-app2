package com.springboot.app2.wiki;

/**
 *
 * What is the synchronization process? Why use it?
 * Synchronization is basically a process in java that enables a simple strategy for avoiding thread interference and memory consistency errors.
 * This process makes sure that resource will be only used one thread at a time when one thread tries to access a shared resource.
 * It can be achieved in three different ways as given below:
 *
 * By the synchronized method
 * By synchronized block
 * By static synchronization
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * What is thread starvation?
 * Thread starvation is basically a situation or condition where a thread won’t be able to have regular access to shared resources
 * and therefore is unable to proceed or make progress. This is because other threads have high priority and occupy the resources for too long.
 * This usually happens with low-priority threads that do not get CPU for its execution to carry on.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * What is CyclicBarrier and CountDownLatch?
 * CyclicBarrier and CountDownLatch, both are required for managing multithreaded programming. But there is some difference between them as given below:
 *
 * CyclicBarrier: It is a tool to synchronize threads processing using some algorithm.
 * It enables a set of threads to wait for each other till they reach a common execution point or common barrier points, and then let them further continue execution.
 * One can reuse the same CyclicBarrier even if the barrier is broken by setting it.
 *
 * CountDownLatch: It is a tool that enables main threads to wait until mandatory operations are performed and completed by other threads.
 * In simple words, it makes sure that a thread waits until the execution in another thread completes before it starts its execution.
 * One cannot reuse the same CountDownLatch once the count reaches 0.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Where is the variable's value cached by the thread is stored (in memory)?
 *
 * In CPU cache if variable is not volatile. Otherwise, volatile variable's value will not be cached
 * (each thread works with value directly, it decreases performance but ensures sustainability).
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Executors. newCachedThreadPool() vs newFixedThreadPool()     https://www.baeldung.com/java-executors-cached-fixed-threadpool
 *
 * CACHED THREAD POOLS are using “synchronous handoff” to queue new tasks.
 * The basic idea of synchronous handoff is simple and yet counter-intuitive:
 * One can queue an item if and only if another thread takes that item at the same time.
 * In other words, the SynchronousQueue can not hold any tasks whatsoever.
 *
 * Suppose a new task comes in. If there is an idle thread waiting on the queue, then the task producer hands off the task to that thread.
 * Otherwise, since the queue is always full, the executor creates a new thread to handle that task.
 *
 * The cached pool starts with zero threads and can potentially grow to have Integer.MAX_VALUE threads.
 * Practically, the only limitation for a cached thread pool is the available system resources.
 *
 * To better manage system resources, cached thread pools will remove threads that remain idle for one minute.
 * We should avoid cached thread pool when the execution time is unpredictable, like IO-bound tasks.
 *
 *
 *  FIXED THREAD POOLS, ss opposed to the cached thread pool, this one is using an unbounded queue with a fixed number of never-expiring threads.
 *  Therefore, instead of an ever-increasing number of threads, the fixed thread pool tries to execute incoming tasks with a fixed amount of threads.
 *  When all threads are busy, then the executor will queue new tasks. This way, we have more control over our program's resource consumption.
 *
 * As a result, fixed thread pools are better suited for tasks with unpredictable execution times.
 *
 */
public class JavaMultithreading {
}
