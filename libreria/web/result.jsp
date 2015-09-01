
<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page import="Modelo.ItemsDto"%>
<%@page import="Dao.ItemDao"%>
<%@page import="jxl.Cell"%>
<%@page import="jxl.Sheet"%>
<%@page import="jxl.Workbook"%>
<%@page import="java.io.File"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("name") == null){
   response.sendRedirect("index.jsp");
}
%>
<!doctype html>
<html class="no-js" lang="en">
  <head>
      <%@include file="header.jsp" %>
  </head>
  <body>
   <nav class="top-bar" data-topbar>
        <ul class="title-area">
          <li class="name">
            <h1>
              <a href="#">
                MI REPOSITORIO
              </a>
            </h1>
          </li>
       </ul>
     
        <section class="top-bar-section">
            <%= session.getAttribute("rol")%>
            <% if(session.getAttribute("rol").equals(1)){ %>
                <%@include file="menuAdmin.jsp" %>
            <%}else if(session.getAttribute("rol").equals(2)){ %>
                <%@include file="menuSupervisor.jsp" %>
            <%}else {%>
                <%@include file="menuArchivador.jsp" %>
            <%}%>
        </section>
      </nav>
     
       
     
     
       
     
      <div class="row">
     
          <div class="large-12 columns">
            <ul class="breadcrumbs">
                <li class="current"><a href="Account">Cuenta</a></li>
            </ul>
          </div> 
        <div class="large-12 columns">
     
            <h4>${requestScope["libro"]}</h4>
        
    <%
        String Libro =  (String) request.getAttribute("libro");
        Workbook archivoExcel = Workbook.getWorkbook(new File(Libro)); 
        System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets()); 
        Sheet hoja1 = archivoExcel.getSheet(0);

                 //Para obtener la hoja de la primera posición del libro
                //??????????????????????????
                //Se crea la celda que se va a leer de la hoja posición (0, 0)

        %>
        
        <table border="1">
            <thead>
                <tr>
                <%
        
                ItemDao itemdao = new ItemDao();
                ItemsDto itemdto = new ItemsDto();
                
                
                
                for(int a1 = 0; a1<hoja1.getColumns() ;a1++){
                Cell actual = hoja1.getCell(a1,0);
                out.print("<th>"+actual.getContents()+"</th>");    
                }
                %>
                <th>Estado.</th>    
                </tr>
            </thead>
            <tbody>
               <%
                String[] celdas = new String[hoja1.getColumns()];
                
                for(int a1 = 1; a1 < hoja1.getRows() ;a1++){
                out.print("<tr>");
                            for(int a2 = 0; a2<hoja1.getColumns() ;a2++){
                              Cell actual = hoja1.getCell(a2,a1);
                              celdas[a2]= "" + actual.getContents() ;
                              out.print("<td>"+actual.getContents()+"</td>");  
                            }
                 itemdto.setIdItem(Integer.parseInt(celdas[0]));
                 itemdto.setTitulo(celdas[1]);
                 itemdto.setAutor(celdas[2]);
                 itemdto.setFechaAdicion(celdas[3]);
                 itemdto.setFechaPublicacion(celdas[4]);
                 itemdto.setUrl(celdas[5]);
                 itemdto.setDescripcion(celdas[6]);
                 itemdto.setIdFormato(Integer.parseInt(celdas[7]));
                 itemdto.setIdLicencia(Integer.parseInt(celdas[8]));
                 itemdto.setAnoCreacion(celdas[9]);
                 itemdto.setPalabrasClaves(celdas[10]);
                
                 String Salida =  itemdao.ingresarItems(itemdto);
                 
                 if(Salida.equals("Usuario Registrado")){
                 %>
                 
            <td> <img src="Imagenes/checkround.png" width="16" height="16" alt="checkround" title='<%= Salida %>' /> </td>
         
                 <%
                 }else{
                  %>
                 
                <td> <img src="Imagenes/cross-24.png" width="16" height="16" alt="checkround" title='<%= Salida %>'  /> </td>
         
                 <%
                 }
               
                            
                out.print("</tr>");
                }
                %>
                
               
              
                
            </tbody>
        </table>

       
     
         
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
