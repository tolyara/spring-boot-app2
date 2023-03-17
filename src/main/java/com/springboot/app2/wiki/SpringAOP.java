package com.springboot.app2.wiki;

/**
 * Problems :
 * - weaving business logic with services functionality (code tangling), method becomes way cumbersome;
 * - diffused service functionality (code scattering), in case when we need to change service functionality we are forced to do it in all places
 *
 * AOP represents paradigm based on idea of distribution of main and support functions. Support methods are stored in ASPECTS (cross-cutting logic).
 * Examples of cross-cutting logic - logging, security check, transactions, exception handling, caching etc.
 * Spring by itself is riddled with AOP.
 *
 * pluses :
 * - easy to support service logic;
 * - business logic becomes more clear;
 * minuses :
 * - additional time for aspect's working;
 *
 *
 *
 * AOP proxy pattern
 * Main class -> AOP proxy -> target method (e.g. addBook())
 *
 *
 *
 * ASPECT - class responsible for end-to-end (cross) functionality
 *
 * ADVICE - method inside aspect class ( beforeAddBookAdvice() )
 * Advice types : before, after returning, after throwing, after, around
 *
 * POINTCUT - expression which describes where advice should be applied ( "execution(public void get*(..)" )
 *
 * JOINT POINT - place where main and service functionality are weaving, that is a moment in code where Advice should be used
 * If we put Joint Point to Advice's parameter, we gain access to signature and params of main method
 *
 */
public class SpringAOP {
}
