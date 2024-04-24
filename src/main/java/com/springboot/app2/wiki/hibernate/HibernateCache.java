package com.springboot.app2.wiki.hibernate;

/**
 *
 * Hibernate comes with different types of Cache:
 *
 * - First Level Cache: Hibernate first level cache is associated with the Session object. Hibernate first level cache is enabled by default and there is no way to disable it.
 * However, hibernate provides methods through which we can delete selected objects from the cache or clear the cache completely.
 * Any object cached in a session will not be visible to other sessions and when the session is closed, all the cached objects will also be lost.
 *
 * - Second Level Cache: Hibernate Second Level cache is disabled by default but we can enable it through configuration.
 * Currently, EHCache and Infinispan provides implementation for Hibernate Second level cache and we can use them.
 *
 * - Query Cache: Hibernate can also cache result set of a query. Hibernate Query Cache doesn’t cache the state of the actual entities in the cache;
 * it caches only identifier values and results of value type. So it should always be used in conjunction with the second-level cache.
 *
 */
public class HibernateCache {
}
