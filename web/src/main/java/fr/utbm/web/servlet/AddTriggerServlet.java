/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.web.servlet;

import fr.utbm.core.entity.Alert;
import fr.utbm.core.entity.Sensor;
import fr.utbm.core.entity.Trigger;
import fr.utbm.core.service.AlertService;
import fr.utbm.core.service.SensorService;
import fr.utbm.core.service.TriggerService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author java
 */
@WebServlet(name = "AddTriggerServlet", urlPatterns = {"/AddTriggerServlet"})
public class AddTriggerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            float trigHigh = Float.parseFloat(request.getParameter("triggerHigh"));
            float trigLow= Float.parseFloat(request.getParameter("triggerLow"));
            byte trigEdge = Byte.parseByte(request.getParameter("triggerEdge"));
            String alertId = request.getParameter("selectedAlert");
            int sensorId = Integer.parseInt(request.getParameter("sensor"));
            
            AlertService as = new AlertService();
            Alert alert = as.getAlert(alertId);
            SensorService ss = new SensorService();
            Sensor s = ss.getSensorById(sensorId);
            Trigger t = new Trigger();
            t.setAlert(alert);
            t.setSensor(s);
            t.setTrigHigh(trigHigh);
            t.setTrigEdge(trigEdge);
            t.setTrigLow(trigLow);
            TriggerService ts = new TriggerService();
            ts.registerTrigger(t);
            RequestDispatcher dis=null;
            dis = request.getRequestDispatcher("/Confirmation.html");
            dis.forward(request,response); 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
