package com.gzem2.JSPCalc;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gzem2.JSPCalc.CalcService.*;

/**
 * Create ServletContext event listener
 */
@WebListener
public class Application implements ServletContextListener {

    /**
     * Initialize servlet and create CalcService implementation instance and inject it into our servlet
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        context.addServlet("JSPCalcServlet", new JSPCalcServlet((new CalcServiceImpl()))).addMapping("/");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}