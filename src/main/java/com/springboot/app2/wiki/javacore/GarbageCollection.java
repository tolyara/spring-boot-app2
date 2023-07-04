package com.springboot.app2.wiki.javacore;

/**
 *
 * Garbage collection is a process of reclaiming the unused runtime objects. It is performed for memory management.
 * In other words, we can say that It is the process of removing unused objects from the memory to free up space and make this space available for Java Virtual Machine.
 *
 */
public class GarbageCollection {

    @Override
    public void finalize() {
        System.out.println("object is garbage collected");
    }

    public static void main(String[] args) {
        GarbageCollection s1 = new GarbageCollection();
        GarbageCollection s2 = new GarbageCollection();
        s1 = null;
        s2 = null;
        System.gc();
    }

}
