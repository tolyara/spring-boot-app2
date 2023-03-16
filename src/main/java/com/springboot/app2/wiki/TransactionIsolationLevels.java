package com.springboot.app2.wiki;

/**
 *
 *
 * problem  : dirty read (t1 UPDATE some value in table1 but don't commit yet -> t2 SELECT this value and see updated value, but t1 might do rollback)
 * solution : READ COMMITTED
 *
 * problem  : non-repeatable read (t1 SELECT from table1 -> t2 UPDATE one of the values from t1's selection ->
 * t1 SELECT same query again from table1 and see updated value, but t2 might do rollback)
 * solution : REPEATABLE READ
 *
 * problem  : phantom read (t1 SELECT from table1 -> t2 INSERT new value which matches t1's selection ->
 * t1 SELECT same query again from table1 and see inserted value, but t2 might do rollback)
 * solution : SERIALIZABLE
 */
public enum TransactionIsolationLevels {
    READ_UNCOMMITTED, READ_COMMITTED, REPEATABLE_READ, SERIALIZABLE,
    NONE
}
