package com.springboot.app2.wiki;

/**
 * There are many key differences between constructor injection and setter injection.
 *
 * Partial dependency: can be injected using setter injection but it is not possible by constructor.
 * Suppose there are 3 properties in a class, having 3 arg constructor and setters methods.
 * In such case, if you want to pass information for only one property, it is possible by setter method only.
 *
 * Overriding: Setter injection overrides the constructor injection.
 * If we use both constructor and setter injection, IOC container will use the setter injection.
 *
 * Changes: We can easily change the value by setter injection. It doesn't create a new bean instance always like constructor.
 * So setter injection is flexible than constructor injection.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Constructor Injection - Better for too many properties
 *
 * Setter Injection - Better for few properties
 *
 *
 *
 */
public class SpringConstructorVsSetterInjection {
}
