package com.springboot.app2.wiki.javacore;

/**
 * HashMap	                                                                        TreeMap
 * The Java HashMap implementation of the Map interface is based on hash tables.	Java TreeMap is a Map interface implementation based on a Tree structure.
 *
 * The Map, Cloneable, and Serializable interfaces are implemented by HashMap.   	NavigableMap, Cloneable, and Serializable interfaces are implemented by TreeMap.
 *
 * Because HashMap does not order on keys, it allows for heterogeneous elements.	Because of the sorting, TreeMap allows homogenous values to be used as a key.
 *
 * HashMap is quicker than TreeMap because it offers O(1)                           TreeMap is slower than HashMap because it performs most operations with O(log(n)) performance,
 * constant-time performance for basic operations such as to get() and put().	     such as add(), remove(), and contains().
 *
 * A single null key and numerous null values are allowed in HashMap.	            TreeMap does not allow null keys, however multiple null values are allowed.
 *
 * To compare keys, it uses the Object class's equals() method.                     It compares keys using the compareTo() method.
 * It is overridden by the Map class's equals() function.
 *
 * HashMap does not keep track of any sort of order.	                            The elements are arranged in chronological sequence (ascending).
 *
 * When we don't need a sorted key-value pair, we should use the HashMap. 	        When we need a key-value pair in sorted (ascending) order, we should use the TreeMap.
 *
 */
public class HashMapVsTreeMap {
}
