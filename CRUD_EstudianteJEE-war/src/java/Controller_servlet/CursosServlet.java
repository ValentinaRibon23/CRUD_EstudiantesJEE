/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller_servlet;

import co.edu.unipiloto.entity.Cursos;
import co.edu.unipiloto.session.CursosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentina Contreras
 */
public class CursosServlet extends HttpServlet {

    @EJB
    private CursosFacadeLocal cursosFacade;

    
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
        String action = request.getParameter("action");
        String codCursoStr = request.getParameter("codCurso");
        int CodCurso=0;
        if(codCursoStr!=null && !codCursoStr.equals(" "))
            CodCurso=Integer.parseInt(codCursoStr);
        
        String nombre= request.getParameter("nombre");
        
        String numCreditosStr = request.getParameter("numCreditos");
        int numCreditos=0;
        if(numCreditosStr!=null && !numCreditosStr.equals(" "))
            numCreditos=Integer.parseInt(numCreditosStr);
        
        String semestreStr = request.getParameter("semestre");
        int semestre =0;
        if(semestreStr!=null && !semestreStr.equals(" "))
            semestre=Integer.parseInt(semestreStr);
       
        String numEstudiantesAdmitidosStr = request.getParameter("numEstudiantesAdmintidos");
        int numEstudiantesAdmitidos =0;
        if(numEstudiantesAdmitidosStr!=null && !numEstudiantesAdmitidosStr.equals(" "))
            numEstudiantesAdmitidos=Integer.parseInt(numEstudiantesAdmitidosStr);
        
        Cursos cursos;
        cursos = new Cursos(CodCurso,nombre,numCreditos,semestre,numEstudiantesAdmitidos);
        
        if("Add".equalsIgnoreCase(action)){
            cursosFacade.create(cursos);
        }else if("Edit".equalsIgnoreCase(action)){
            cursosFacade.edit(cursos);
        }else if("Delete".equalsIgnoreCase(action)){
            cursosFacade.remove(cursos);
        }else if("Search".equalsIgnoreCase(action)){
            cursosFacade.find(CodCurso);
        }
       
        request.setAttribute("cursos", cursos);
        request.setAttribute("allCursos", cursosFacade.findAll());
        request.getRequestDispatcher("cursosInfo.jsp").forward (request,response);
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
