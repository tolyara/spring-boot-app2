package com.springboot.app2.wiki;

/**
 *
 *         NOT NULL - Restricts NULL value from being inserted into a column.
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         CHECK - Verifies that all values in a field satisfy a condition.
 *         create table test (
 * 	        id serial NOT NULL PRIMARY KEY,
 * 	        gender char(1) constraint gender_check check(gender in ('M', 'F'))
 *         );
 *         insert into test (gender) values ('F');
 *         insert into test (gender) values ('R'); -> ERROR: ОШИБКА:  новая строка в отношении "test" нарушает ограничение-проверку "gender_check"
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         DEFAULT - Automatically assigns a default value if no value has been specified for the field.
 *         alter table test add column if not exists deleted boolean default false;
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         UNIQUE - Ensures unique values to be inserted into the field.
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         INDEX - Indexes a field providing faster retrieval of records.
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         PRIMARY KEY - Uniquely identifies each record in a table.
 *
 *         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 *         FOREIGN KEY - Ensures referential integrity for a record in another table.
 *
 */
public class SqlConstraints {
}
