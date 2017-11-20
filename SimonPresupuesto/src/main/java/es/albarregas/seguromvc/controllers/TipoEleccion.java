/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.seguromvc.controllers;

import es.albarregas.seguromvc.beans.Eleccion;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
@WebServlet(name = "eleccion", urlPatterns = {"/eleccion"})
public class TipoEleccion extends HttpServlet {

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
        Eleccion eleccion = new Eleccion();
        String ruta = "";
        ruta = request.getHeader("Referer");
        sesion.setAttribute("ruta", ruta);
        try {
            BeanUtils.populate(eleccion, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(TipoEleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "";
        int ultimo = request.getHeader("referer").lastIndexOf("/");
        int anterior = request.getHeader("referer").lastIndexOf("/", ultimo - 1);
        String directorio = request.getHeader("referer").substring(anterior, ultimo);
        if (eleccion.getEdificio() == null && eleccion.getContenido() == null) {
            if (ruta.lastIndexOf("jspEstandar") != -1) {
                url = "/jsp/jspEstandar/index.jsp";
            } else {
                url = "/jsp/jspLE/index.jsp";
            }

        } else {          
            sesion.setAttribute("eleccion", eleccion);
            if (eleccion.getEdificio() != null) {
                if (ruta.lastIndexOf("jspEstandar") != -1) {
                    url = "/jsp/jspEstandar/edificio.jsp";
                } else {
                    url = "/jsp/jspLE/edificio.jsp";
                }

            } else {
                if (ruta.lastIndexOf("jspEstandar") != -1) {
                    url = "/jsp/jspEstandar/contenido.jsp";
                } else {
                    url = "/jsp/jspLE/contenido.jsp";
                }

            }
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
