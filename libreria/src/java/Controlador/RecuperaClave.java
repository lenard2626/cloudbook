/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.UsuariosDao;
import Modelo.UsuariosDto;
import Modelo.EncriptacionDto;
import Modelo.Mailer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando
 */
public class RecuperaClave extends HttpServlet {

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
            
            UsuariosDao objDao = new UsuariosDao();
            EncriptacionDto objDto = new EncriptacionDto();

            String email=request.getParameter("email");
            String resultMessage;
            
            if(email!=null){
                System.out.print("toca verificar");
                String id=objDao.validateEmail(email);
                if(id!=null){
                    UsuariosDto item= objDao.ObtenerItem(id);
                    System.out.print(item.getNombre());
                    String cadena =    objDto.getCadenaAlfanumAleatoria(8);
                    String nuevaclave= EncriptacionDto.getStringMessageDigest(cadena,EncriptacionDto.MD5);
                    
                    objDao.ActualizarClave(Integer.parseInt(id), nuevaclave);
                    
                    try {
                        Mailer.sendEmailClave(item.getNombre(), item.getApellido(), "nueva contraseña", email, item.getUsuario(),cadena);
                        resultMessage = "The e-mail was sent successfully";
                    } catch (Exception ex) {
                        resultMessage = "There were an error: " + ex.getMessage();
                    } 
                    
                    out.print("<p style=\"color:red\">Su nuevo password ha sido enviado de nuevo al correo</p>");
                }else{
                    out.print("<p style=\"color:red\">No existe un usuario relacionado con el correo</p>"); 
                }
            }
                    
            RequestDispatcher rd=request.getRequestDispatcher("recuperarclave.jsp");    
            rd.include(request,response); 
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
