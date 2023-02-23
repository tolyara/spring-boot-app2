package com.springboot.app2.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("request.getRequestId() : " + request.getRequestId());
        logger.info("request.getLocalAddr() : " + request.getLocalAddr());
        chain.doFilter(request, response);
    }

}
