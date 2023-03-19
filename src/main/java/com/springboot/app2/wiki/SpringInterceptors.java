package com.springboot.app2.wiki;

/**

HandlerInterceptors vs. Filters in Spring MVC

Filters intercept requests before they reach the DispatcherServlet, making them ideal for coarse-grained tasks such as:

Authentication
Logging and auditing
Image and data compression
Any functionality we want to be decoupled from Spring MVC

HandlerIntercepors, on the other hand, intercepts requests between the DispatcherServlet and our Controllers.
This is done within the Spring MVC framework, providing access to the Handler and ModelAndView objects.
This reduces duplication and allows for more fine-grained functionality such as:

Handling cross-cutting concerns such as application logging
Detailed authorization checks
Manipulating the Spring context or model

Let's look at a diagram showing where Filters and HandlerInterceptors fit in the request/response flow:

request -> Filters -> Dispatcher Servlet -> Handler Interceptors -> Controller
                                                                         V
        <- Filters <- Dispatcher Servlet <- Handler Interceptors <- response

 */
public class SpringInterceptors {
}
