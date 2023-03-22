package com.springboot.app2.wiki;

/**
 *
 * https://github.com/astappiev/jdbc-performance-benchmark
 *
 * Slow SELECT performance : when we fetch 1_000_000_000 User records, Hibernate will allocate memory, deserialize all records via reflection.
 * Better solution is using JDBC / JDBC TEMPLATE and then use JsonGenerator or whatsoever.
 *
 */
public class HibernatePerformance {
}
