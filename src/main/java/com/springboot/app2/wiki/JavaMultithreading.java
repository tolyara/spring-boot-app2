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
 */
public class JavaMultithreading {
}
