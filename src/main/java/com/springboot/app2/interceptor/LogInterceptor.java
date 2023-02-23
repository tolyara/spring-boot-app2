package com.springboot.app2.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*

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

@Component
public class LogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        logger.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
//        logger.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
//        logger.info("afterCompletion");
    }

}
