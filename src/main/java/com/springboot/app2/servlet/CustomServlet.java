package com.springboot.app2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/servlet")
public class CustomServlet extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(CustomServlet.class);

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doGet() method is invoked");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException {
        logger.info("CustomServlet doPost() method is invoked");
        super.doPost(req, resp);
    }

}
