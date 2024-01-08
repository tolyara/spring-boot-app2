package com.springboot.app2.wiki.hibernate;

/**
 *
 * “Dirty checking” is a mechanism used by Hibernate to determine whether any value of an entity has changed since it was retrieved from the database.
 * This helps Hibernate optimize database queries so that only the fields that have changed are updated.
 *
 *
 * Here’s how it works:
 * - Entity retrieval: When an entity is fetched from the database, Hibernate stores the initial state of that entity in the first-level cache (session).
 * - Entity modification: After retrieval, the user can make changes to this entity.
 * - State synchronization: Before any operation (e.g., before committing a transaction or explicitly calling `flush()`),
 * Hibernate performs a “dirty checking” process, comparing the current state of the entity with its initial state stored in the cache.
 * - Database update: If Hibernate detects any changes, it generates and executes the corresponding SQL update query to update only those fields that have changed.
 *
 *
 * Advantages of “dirty checking”:
 * - Optimization: Only modified fields are updated in the database, which can improve performance as less data is transferred between the application and the database.
 * - Automation: Developers do not need to explicitly specify which fields have changed. Hibernate does this automatically.
 *
 * Disadvantages or limitations:
 * - Overhead: The “dirty checking” mechanism may add additional overhead, especially when dealing with a large number of entities.
 * In most cases, these costs are insignificant, but in some scenarios, they can become problematic.
 * - Transparency: Some developers may find this mechanism not entirely transparent, as Hibernate automatically determines which fields need to be updated.
 *
 */
public class HibernateDirtyChecking {
}
