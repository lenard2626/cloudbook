<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>
<% if(session.getAttribute("name") == null){
   response.sendRedirect("index.jsp");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.CategoriasDto"  %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html class="no-js" lang="en">
  <head>
      <%@include file="header.jsp" %>
      <script type="text/javascript">
      function fn_eliminar(idCont,idItem){
	var respuesta = confirm("Desea eliminar este item?");
            if (respuesta){
                     document.location.href='ItemCategoriaEliminar?id='+idCont+"&iditem="+idItem;

            }
        }
        </script>
  </head>
  <body>
        <div class="large-12 columns">
     
            <h3 class="title" >Lista de categorias asociadas al item</h3>
    
          <div class="section-container tabs" data-section>
            <section class="section">
                <%
                    if (request.getAttribute("mensaje") != null) {
                %>
                    <h4><%=request.getAttribute("mensaje") %></h4>
                <% } %>
                <table style="width: 100%"  >
                    <tr>
                        <th>Id</th>
                        <th>Nombre categoria</th>
                        <th>Eliminar</th>

                    </tr>
                    <% for (CategoriasDto lista : (List<CategoriasDto>)request.getAttribute("equipos_list")) {%>
                    <tr>
                        <td><%= lista.getIdCategoria() %></td>
                        <td><%= lista.getNombre() %></td>
                        <td><a href="javascript:void(0);" onclick="fn_eliminar(<%= lista.getIdCategoria() %>,<%= request.getAttribute("contid") %>);" ><i class=" fi-trash"></i></a></td>

                    </tr> 
                    <% } %>

                </table>
            </section>
          </div>
        </div>
  </body>
</html>
