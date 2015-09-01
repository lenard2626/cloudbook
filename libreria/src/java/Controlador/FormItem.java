/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ItemsDao;
import Modelo.ItemsDto;
import Dao.CategoriasDao;
import Modelo.ItemsCategoriaDto;
import Dao.ItemsCategoriaDao;
import Dao.LicenciasDao;
import Dao.FormatosDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando
 */
public class FormItem extends HttpServlet {

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
            ItemsDao objDao = new ItemsDao();
            ItemsDto objDto = new ItemsDto();
            ItemsCategoriaDao objICDao = new ItemsCategoriaDao();
            ItemsCategoriaDto objICDto = new ItemsCategoriaDto();
            LicenciasDao objLDao = new LicenciasDao();
            FormatosDao objFDao = new FormatosDao();
            Date date = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
       // display time and date using toString()

            CategoriasDao objRDao = new CategoriasDao();

            String id = request.getParameter("idformato");
            String contId = request.getParameter("contId");
            if(request.getParameter("enviar")!=null){
                if(id==null){
                    objDto.setTitulo(request.getParameter("titulo"));                
                    objDto.setAutor(request.getParameter("autor"));
                    objDto.setAnoCreacion(request.getParameter("ano"));
                    objDto.setFechaAdicion(formateador.format(date));
                    //objDto.setFechaPublicacion(request.getParameter("fecha_publicacion"));
                    objDto.setUrl(request.getParameter("url"));
                    objDto.setDescripcion(request.getParameter("descripcion"));
                    objDto.setIdFormato(Integer.parseInt(request.getParameter("formato")));
                    objDto.setIdLicencia(Integer.parseInt(request.getParameter("licencia")));
                    objDto.setAnoCreacion(request.getParameter("ano_creacion"));
                    objDto.setPalabrasClaves(request.getParameter("palabras_claves"));
                    
                    Integer iditem = objDao.IngresarItem(objDto);
                    
                    String[] categories=request.getParameterValues("selectedItems");
                    
                    for(String favorito: categories){
                        objICDto.setIdItem(iditem);
                        objICDto.setIdCategoria(Integer.parseInt(favorito));
                        objICDao.IngresarItem(objICDto);
                    }
                    
                   
                    //System.out.println("estado: " + Estado);
                    //out.print(Estado);
                    response.sendRedirect("Items");
                }else{
                    System.out.println("editar: " + id);
                    
                    
                    objDto.setTitulo(request.getParameter("titulo"));                
                    objDto.setAutor(request.getParameter("autor"));
                    objDto.setAnoCreacion(request.getParameter("ano"));
                    objDto.setUrl(request.getParameter("url"));
                    objDto.setDescripcion(request.getParameter("descripcion"));
                    objDto.setIdFormato(Integer.parseInt(request.getParameter("formato")));
                    objDto.setIdLicencia(Integer.parseInt(request.getParameter("licencia")));
                    objDto.setAnoCreacion(request.getParameter("ano_creacion"));
                    objDto.setPalabrasClaves(request.getParameter("palabras_claves"));
                    objDto.setIdItem(Integer.parseInt(id));
                    String Estado = objDao.ActualizarItem(objDto);

                    objICDao.EliminarItems(Integer.parseInt(id));
                    String[] categories=request.getParameterValues("selectedItems");
                    for(String favorito: categories){
                        objICDto.setIdItem(Integer.parseInt(id));
                        objICDto.setIdCategoria(Integer.parseInt(favorito));
                        objICDao.IngresarItem(objICDto);
                    }
                    request.setAttribute("mensaje", Estado);
                    response.sendRedirect("Items");
                }
            }else{
            
                if(contId!=null){
                    request.setAttribute("datau", objDao.ObtenerItem(contId));
                    request.setAttribute("datalc", objICDao.ObtenerItems(contId));
                    //System.out.println("aja");
                }

                request.setAttribute("roles_list", objRDao.listadoTotal() );
                request.setAttribute("licencias_list", objLDao.listadoTotal() );
                request.setAttribute("formatos_list", objFDao.listadoTotal() );
                RequestDispatcher Rd = request.getRequestDispatcher("formItems.jsp");
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
