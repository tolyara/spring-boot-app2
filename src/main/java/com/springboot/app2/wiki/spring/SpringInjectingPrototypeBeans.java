package com.springboot.app2.wiki.spring;

/**
 *
 * https://www.baeldung.com/spring-inject-prototype-bean-into-singleton
 *
 * The problem arises when we try to wire beans of different scopes. For example, a prototype bean into a singleton. This is known as the scoped bean injection problem.
 *
 * Solutions:
 *
 * - Injecting ApplicationContext
 * - Method Injection (@Lookup annotation)
 * - javax.inject API
 * - Scoped Proxy
 * - ObjectFactory Interface
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * https://asvignesh.medium.com/scoped-bean-prototype-bean-problem-springboot-a54d06d89cbc
 *
 * In Springboot when a bean is created, by default it is Singleton but if you annotate the bean with the scope as “prototype” still the bean are singleton in some cases.
 * Even if your bean is annotated as a scope prototype and if the bean is created from the singleton bean then the bean will be a singleton.
 * Singleton bean returns the same bean object no matter whatever it is being referred to, in fact, all the default bean scope is a singleton in the Spring/
 *
 */
public class SpringInjectingPrototypeBeans {
}
