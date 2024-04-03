package com.springboot.app2.wiki.spring;

/**
 *
 * https://www.baeldung.com/spring-interview-questions#Q4
 *
 * Dependency injection, an aspect of Inversion of Control (IoC), is a general concept stating that we do not create our objects manually
 * but instead describe how they should be created. Then an IoC container will instantiate required classes if needed.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * https://docs.spring.io/spring-framework/reference/core/beans/dependencies/factory-collaborators.html
 *
 * Dependency injection (DI) is a process whereby objects define their dependencies (that is, the other objects with which they work)
 * only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method.
 * The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse (hence the name, Inversion of Control)
 * of the bean itself controlling the instantiation or location of its dependencies on its own by using direct construction of classes or the Service Locator pattern.
 *
 * Code is cleaner with the DI principle, and decoupling is more effective when objects are provided with their dependencies.
 * The object does not look up its dependencies and does not know the location or class of the dependencies.
 * As a result, your classes become easier to test, particularly when the dependencies are on interfaces or abstract base classes,
 * which allow for stub or mock implementations to be used in unit tests.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Constructor-based or setter-based DI?
 *
 * Since you can mix constructor-based and setter-based DI, it is a good rule of thumb to use constructors for mandatory dependencies
 * and setter methods or configuration methods for optional dependencies.
 * Note that use of the @Autowired annotation on a setter method can be used to make the property be a required dependency;
 * however, constructor injection with programmatic validation of arguments is preferable.
 *
 */
public class SpringDependencyInversion {
}
