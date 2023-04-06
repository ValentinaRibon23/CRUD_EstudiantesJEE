/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_servlet;

import co.edu.unipiloto.entity.MatriculaCursos;
import co.edu.unipiloto.session.MatriculaCursosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentina Contreras
 */
public class MatriculaServlet extends HttpServlet {

    @EJB
    private MatriculaCursosFacadeLocal matriculaCursosFacade;

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
            throws ServletException, IOException, ParseException {
        String action = request.getParameter("action");
        String codCursoStr = request.getParameter("codCurso");
        int CodCurso = 0;
        if (codCursoStr != null && !codCursoStr.equals(" ")) {
            CodCurso = Integer.parseInt(codCursoStr);
        } else {
            //--AQUI TERMINA EL PROCESO YA QUE EL VALOR ESTA LLEGANDO EN NULL
            return;
        }

        String studentIdStr = request.getParameter("studentid");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals(" ")) {
            studentId = Integer.parseInt(studentIdStr);
        } else {
            //--AQUI TERMINA EL PROCESO YA QUE EL VALOR ESTA LLEGANDO EN NULL
            return;
        }

        String fechaStr = request.getParameter("fecha");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaConvertida = null;

        Date parsed = dateFormat.parse(fechaStr);
        fechaConvertida = new java.sql.Date(parsed.getTime());

        String precioStr = request.getParameter("precio");
        int precio = 0;
        if (precioStr != null && !precioStr.equals(" ")) {
            precio = Integer.parseInt(precioStr);
        } else {
            //--AQUI TERMINA EL PROCESO YA QUE EL VALOR ESTA LLEGANDO EN NULL
            return;
        }

        MatriculaCursos matricula;
        matricula = new MatriculaCursos(CodCurso, studentId, fechaConvertida, precio);

        if ("Add".equalsIgnoreCase(action)) {
            //matriculaCursosFacade.insertarMatriculaCursos(CodCurso, studentId, fechaConvertida, precio);
            matriculaCursosFacade.create(matricula);
        } else if ("Edit".equalsIgnoreCase(action)) {
            //matriculaCursosFacade.modificarMatriculaCursos(CodCurso, studentId, fechaConvertida, precio);
            matriculaCursosFacade.edit(matricula);
        } else if ("Delete".equalsIgnoreCase(action)) {
            matriculaCursosFacade.remove(matricula);
            // matriculaCursosFacade.eliminarMatriculaCursos(CodCurso, studentId, fechaConvertida, precio);
        } else if ("Search".equalsIgnoreCase(action)) {
            matriculaCursosFacade.find(CodCurso);
        }

        request.setAttribute("matriculacursos", matricula);
        request.setAttribute("allMatriculaCursos", matriculaCursosFacade.findAll());
        request.getRequestDispatcher("matriculaInfo.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(MatriculaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
