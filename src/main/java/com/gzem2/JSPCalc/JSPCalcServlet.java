package com.gzem2.JSPCalc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gzem2.JSPCalc.CalcService.CalcService;

import java.text.DecimalFormat;
import java.io.IOException;

/**
 * Servlet class for WebApp
 */
public class JSPCalcServlet extends HttpServlet {
    /**
     * Service that performs calculator functions
     */
    private CalcService service;

    /**
     * Calculator input display
     */
    private String display;

    /**
     * Get display value
     */
    public String getDisplay() {
        return this.display;
    }

    /**
     * Set display value
     */
    public void setDisplay(String display) {
        this.display = display;
    }

    /**
     * Get display value ready for printing
     */
    public String getPrintDisplay() {
        String ppd = this.display;
        ppd = ppd.replaceAll("[/]", "\u00F7");
        ppd = ppd.replaceAll("[*]", "\u00D7");
        return ppd;
    }

    /**
     * Inject CalcService while initializing servlet
     */
    public JSPCalcServlet(CalcService service) {
        this.service = service;
        this.display = "0";
    }

    /**
     * Set display attribute and show page on GET request
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("result", this.getPrintDisplay());
        req.getRequestDispatcher("JSPCalc.jsp").forward(req, resp);
    }

    /**
     * Get input and calculate result on POST request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String button = req.getParameter("button");

        if ("=".equals(button)) {
            this.display = new DecimalFormat("0.####").format(this.service.calculateInput(this.display));
        } else if ("C".equals(button)) {
            this.display = "0";
        } else {
            if ("0".equals(this.display)) {
                this.display = button;
            } else {
                this.display += button;
            }
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}