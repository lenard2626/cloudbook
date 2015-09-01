/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.LoginDao;
import Modelo.LoginDto;
import Modelo.EncriptacionDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando
 */
public class Login extends HttpServlet {

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
            LoginDto objDto = new LoginDto();
            LoginDao objDao = new LoginDao();
            /* TODO output your page here. You may use following sample code. */
            String clavemd5= EncriptacionDto.getStringMessageDigest(request.getParameter("clave"),EncriptacionDto.MD5);

            objDto.setUsuario(request.getParameter("usuario"));
            objDto.setContasena(clavemd5);

            HttpSession session = request.getSession(true);  
            
            if(session!=null){  
                session.setAttribute("name", request.getParameter("usuario")); 
                session.setAttribute("rol",objDao.rol(objDto));
                session.setAttribute("nombres", objDao.nombreUsuario(objDto));
            }
            if(objDao.validate(objDto)){
                response.sendRedirect("Account");
                
            }else{
                out.print("<p style=\"color:red\">Su usuario o password son incorrectos</p>");    
                response.sendRedirect("Acceso");
                
            }
           
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