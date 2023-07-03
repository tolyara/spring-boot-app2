package com.springboot.app2.wiki;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

/**
 *
 * https://hackernoon.com/3-ways-to-deal-with-hibernate-n1-problem
 *
 * Hibernate N+1 problem occurs when you use FetchType.LAZY for your entity associations.
 * If you perform a query to select n-entities and if you try to call any access method of your entity's lazy association,
 * Hibernate will perform n-additional queries to load lazily fetched objects.
 *
 * For example, we have the following Author entity with one-to-many books collection:
 * Let’s try to load all authors and print each author’s name with his books collection size:
 *
 * entityManager.createQuery("select a from Author a", Author.class)
 *                 .getResultList()
 *                 .forEach(a -> System.out.printf("%s had written %d books\n",
 *                                                a.getFullName(), a.getBooks().size()));
 *
 * The first query Hibernate will generate is to select all authors:
 * SELECT author0_.id AS id1_0_,
 *        author0_.fullName AS fullname2_0_
 * FROM authors author0_;
 *
 * After that, when we call size() method on the books collection, this association needs to be initialized, so Hibernate will perform an additional query:
 * SELECT books0_.author_id AS author_i4_1_0_,
 *        books0_.id AS id1_1_0_,
 *        books0_.id AS id1_1_1_,
 *        books0_.author_id AS author_i4_1_1_,
 *        books0_.title AS title2_1_1_,
 * FROM books books0_
 * WHERE books0_.author_id=?;
 * This query will be called n-times for each author when we print the amount of books in addition to the first query. Thus the total number of queries will be equal to N+1.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Hibernate provides a couple of ways to eliminate this issue:
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * The first solution is to use join fetch:
 * entityManager.createQuery("select a from Author a left join fetch a.books", Author.class);
 *
 * This query works fine, but it has one issue: it doesn’t allow us to use pagination because the limit will not be applied to the authors.
 * If you specify query.setMaxResults(n), Hibernate will fetch all existing rows and do the pagination in the memory, significantly increasing memory consumption.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Another way is to use @BatchSize on the lazy association:
 * SELECT books0_.author_id AS author_i4_1_1_,
 *        books0_.id AS id1_1_1_,
 *        books0_.id AS id1_1_0_,
 *        books0_.author_id AS author_i4_1_0_,
 *        books0_.title AS title2_1_0_,
 * FROM books books0_
 * WHERE books0_.author_id in (?, ?, ?, ?, ?, ?, ?, ?, ?, ? *batch size*
 * In this case, we can easily perform the pagination on the authors.
 *
 * This query will be called N/M times, where N is the amount of authors and M is the specified batch size. Totally we will call (N/M) + 1 queries.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * The third way is to use a sub query returning a list of author identifiers
 * SELECT books0_.author_id AS author_i4_1_1_,
 *        books0_.id AS id1_1_1_,
 *        books0_.id AS id1_1_0_,
 *        books0_.author_id AS author_i4_1_0_,
 *        books0_.title AS title2_1_0_,
 *        books0_.year AS year3_1_0_
 * FROM books books0_
 * WHERE books0_.author_id in
 *     (SELECT author0_.id
 *      FROM authors author0_);
 *
 */
public class HibernateNplus1 {

    private class Author {
        private Integer id;
        private String fullName;

        @BatchSize(size = 10)

        @Fetch(FetchMode.SUBSELECT)

        @OneToMany(fetch = FetchType.LAZY)
        private Set<Book> books;
    }

    private class Book {
        private Integer id;
        private String title;

        @ManyToOne(fetch = FetchType.LAZY)
        private Author author;
    }

}
