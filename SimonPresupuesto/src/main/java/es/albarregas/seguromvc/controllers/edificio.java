/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.controllers;

import es.albarregas.seguromvc.beans.Edificio;
import es.albarregas.seguromvc.beans.Eleccion;
import es.albarregas.seguromvc.models.CalcularCuota;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Simon
 */
@WebServlet(name = "edificio", urlPatterns = {"/edificio"})
public class edificio extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet edificio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet edificio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        HttpSession sesion = request.getSession();
        Edificio edificio = new Edificio();
        Map parameters; 
        parameters = request.getParameterMap(); 
        CalcularCuota cuota = new CalcularCuota();
        String url = "";
        try {
            //processRequest(request, response);
            BeanUtils.populate(edificio, parameters);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(edificio.class.getName()).log(Level.SEVERE, null, ex);
        }
        edificio.setCuota(cuota.calcularEdificio(edificio));
        sesion.setAttribute("edificio", edificio);
        Eleccion eleccion = (Eleccion) sesion.getAttribute("eleccion");
        if (eleccion.getContenido() != null ){
            url = "/jsp/jspEstandar/contenido.jsp";
        }else{
            url = "/jsp/jspEstandar/visualizar.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
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
