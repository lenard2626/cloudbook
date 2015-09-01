/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.UsuariosDto;
import Dao.UsuariosDao;
import Dao.RolesDao;
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
public class FormUsuario extends HttpServlet {

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
            UsuariosDto objDto = new UsuariosDto();
            RolesDao objRDao = new RolesDao();
            String resultMessage;
            String id = request.getParameter("idformato");
            String contId = request.getParameter("contId");
            if(request.getParameter("enviar")!=null){
                if(id==null){
                    String clavemd5= EncriptacionDto.getStringMessageDigest(request.getParameter("clave"),EncriptacionDto.MD5);
                    objDto.setNombre(request.getParameter("nombre"));
                    objDto.setApellido(request.getParameter("apellido"));
                    objDto.setEmail(request.getParameter("email"));
                    objDto.setUsuario(request.getParameter("usuario"));
                    objDto.setContrasena("clave");
                    objDto.setIdRol(Integer.parseInt(request.getParameter("perfil")));
               
                    String nombres= request.getParameter("nombre")+" "+request.getParameter("apellido");
                    String asunto= "Datos de acceso aplicativo libreria";
                    try {
                        Mailer.sendEmail(nombres,asunto, request.getParameter("email"), request.getParameter("usuario"), request.getParameter("clave"));
                        resultMessage = "The e-mail was sent successfully";
                    } catch (Exception ex) {
                            resultMessage = "There were an error: " + ex.getMessage();
                    } 
                    String Estado = objDao.IngresarItem(objDto);
                    //System.out.println("estado: " + Estado);
                    //out.print(Estado);


                    request.setAttribute("mensaje", Estado);
                    response.sendRedirect("Usuarios");
                }else{
                    String clavemd5= EncriptacionDto.getStringMessageDigest(request.getParameter("clave"),EncriptacionDto.MD5);
                    System.out.println("editar: " + id);
                    objDto.setNombre(request.getParameter("nombre"));
                    objDto.setApellido(request.getParameter("apellido"));
                    objDto.setEmail(request.getParameter("email"));
                    objDto.setUsuario(request.getParameter("usuario"));
                    objDto.setContrasena(clavemd5);
                    objDto.setIdRol(Integer.parseInt(request.getParameter("perfil")));
                    objDto.setIdUsuario(Integer.parseInt(id));
                    String Estado = objDao.ActualizarItem(objDto);
                    //System.out.println("estado: " + Estado);
                    //out.print(Estado);
                    String nombres= request.getParameter("nombre")+" "+request.getParameter("apellido");
                    String asunto= "Cambio datos de acceso aplicativo libreria";
                    try {
                        Mailer.sendEmail(nombres,asunto, request.getParameter("email"), request.getParameter("usuario"), request.getParameter("clave"));
                        resultMessage = "The e-mail was sent successfully";
                    } catch (Exception ex) {
                            resultMessage = "There were an error: " + ex.getMessage();
                    }     

                    request.setAttribute("mensaje", Estado);
                    response.sendRedirect("Usuarios");
                }
            }else{
            
                if(contId!=null){
                    request.setAttribute("datau", objDao.ObtenerItem(contId));
                    //System.out.println("aja");
                }

                request.setAttribute("roles_list", objRDao.listadoTotal() );
                RequestDispatcher Rd = request.getRequestDispatcher("formUsuarioActualizar.jsp");
                Rd.forward(request, response);
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
