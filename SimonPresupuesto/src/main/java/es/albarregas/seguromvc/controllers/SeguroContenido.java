/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.controllers;

import es.albarregas.seguromvc.beans.Contenido;
import es.albarregas.seguromvc.models.CalcularCuota;
import java.io.IOException;
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
@WebServlet(name = "contenido", urlPatterns = {"/contenido"})
public class SeguroContenido extends HttpServlet {

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
        doPost(request, response);
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
        Contenido contenido = new Contenido();
        Map parameters;
        parameters = request.getParameterMap();
        CalcularCuota cuota = new CalcularCuota();
        String url = "";
        String ruta = "";
        ruta = (String) sesion.getAttribute("ruta");
        try {
            //processRequest(request, response);
            BeanUtils.populate(contenido, parameters);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(SeguroEdificio.class.getName()).log(Level.SEVERE, null, ex);
        }
        contenido.setCuota(cuota.calcularContenido(contenido));
        sesion.setAttribute("contenido", contenido);
          if (ruta.lastIndexOf("jspEstandar") != -1) {
                url = "/jsp/jspEstandar/visualizar.jsp";
            } else {
                url = "/jsp/jspLE/visualizar.jsp";
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
