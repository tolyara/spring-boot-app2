package com.springboot.app2.wiki.spring;

/**
 *
 * https://stackoverflow.com/questions/35807056/how-many-ways-are-there-to-configure-the-spring-framework-what-are-the-differen
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * XML - based configuration, when you describe configuration in xml file;
 *
 * This was there from the the beginning - version 1
 * This uses XML for everything, including specifying autowiring, or what dependencies go where directly
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Annotation based configuration
 *
 * in Spring 2.5 - this came as a reaction to Java EE 5, new annotations like @Autowired were introduced, there was still some context configuration in XML files -
 * usually you would define which packages were to be scanned and rest of it was done automatically based on annotations - hence the name.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * Java Based Configuration, when configuration is in Java class, marked with specific annotations like @Configuration for config class, @Bean for methods for bean creation;
 *
 */
public class SpringConfigurationTypes {
}
