/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.controllers;

import es.albarregas.seguromvc.beans.Eleccion;
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
// LOS SERVLETS SON CLASES Y COMO TALES SU NOMBRE TIENE QUE COMENZAR POR MAYÚSCULAS
/**
 *
 * @author Simon
 */
@WebServlet(name = "eleccion", urlPatterns = {"/eleccion"})
public class eleccion extends HttpServlet {
// ESTE MÉTODO NO HACE NADA POR LO TANTO ELIMINALO
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
            out.println("<title>Servlet eleccion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet eleccion at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        Eleccion eleccion = new Eleccion();
        try {
            BeanUtils.populate(eleccion, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(eleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "";
        if(eleccion.getEdificio() == null && eleccion.getContenido() == null){
            url = "/jsp/jspEstandar/index.jsp";
        }else{     
        HttpSession sesion = request.getSession();
        sesion.setAttribute("eleccion", eleccion);
        if( eleccion.getEdificio() != null){
            url = "/jsp/jspEstandar/edificio.jsp";
        }else
            url = "/jsp/jspEstandar/contenido.jsp";
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
