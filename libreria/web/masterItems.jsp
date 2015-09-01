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
<%@ page import="Modelo.ItemsDto"  %>
<%@ page import="Dao.ItemsDao" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html class="no-js" lang="en">
  <head>
      <%@include file="header.jsp" %>
      <script type="text/javascript">
      function fn_eliminar(idCont){
	var respuesta = confirm("Desea eliminar este item?");
            if (respuesta){
                     document.location.href='ItemEliminar?id='+idCont;

            }
        }
        function fn_aprobar(idCont){
	var respuesta = confirm("Desea aprobar este item para su publicación en el repositorio?");
            if (respuesta){
                     document.location.href='ItemPublicar?id='+idCont;

            }
        }
        function fn_ver(idLinea){

            $.fancybox({
                    'autoSize': false,
                    'opacity' : true,
                    'padding' : 5,
                    'margin' : 1,
                    'maxWidth' : 850,
                    'maxHeight' : 450,
                    'width' : '70%',
                    'height' : '70%',
                    'transitionIn': 'elastic',
                    'transitionOut': 'elastic',
                    'type' : 'iframe',
                    'href': 'ItemCategorias?contId='+idLinea,
                    'scrolling' : 'yes' /*,
                    'onClosed': function() {
                         parent.location.reload(true);
                    }
                    */
           });
         }
        $(function() {
            $("#tabledata").simplePagination({
                previousButtonClass: "btn btn-danger",
		nextButtonClass: "btn btn-danger"
            });
        });
        </script>
  </head>
  <body>
   <nav class="top-bar" data-topbar>
        <ul class="title-area">
          <li class="name">
            <h1>
              <a href="#">
                Libreria
              </a>
            </h1>
          </li>
       </ul>
     
        <section class="top-bar-section">
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
                <li><a href="Account">Cuenta</a></li>
                <li class="current"><a href="Items">Items repositorio</a></li>
            </ul>
          </div>      
         
        <div class="large-12 columns">
     
            <h3 class="title" >Lista de documentos</h3>
    
          <div class="section-container tabs" data-section>
            <section class="section">
                <%
                    if (request.getAttribute("mensaje") != null) {
                %>
                    <h4><%=request.getAttribute("mensaje") %></h4>
                <% } %>
                <p class="crear-item"><a href="FormItem">Crear nuevo item </a></p>
                <table style="width: 100%" id="tabledata" >
                    <tr>
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>Descripción</th>
                        <th>Año de creación</th>
                        <th>Fecha de adición</th>
                        <th>Fecha de publicación</th>
                        <th>Fichero adjunto</th>
                        <th>ver categorias asociadas</th>
                        <th>Editar </th>
                        <th>Eliminar</th>

                    </tr>
                    <% for (ItemsDto lista : (List<ItemsDto>)request.getAttribute("lineas_list")) {%>
                    <tr>
                        <td><%= lista.getTitulo() %></td>
                        <td><%= lista.getAutor() %></td>
                        <td><%= lista.getDescripcion() %></td>
                        <td><%= lista.getAnoCreacion() %></td>
                        <td><%= lista.getFechaAdicion() %></td>
                        <% if(lista.getFechaPublicacion()!=null) { %>
                        <td><%= lista.getFechaPublicacion() %></td>
                        <% }else{%>
                        <td><a href="javascript:void(0);" onclick="fn_aprobar(<%= lista.getIdItem() %>);" ><i class=" fi-check"></i></a></td>
                        <% }%>
                        <td><a href="javascript:void(0);" onclick="fn_ver(<%= lista.getIdItem() %>);" ><i class=" fi-page-search" title="Ver categorias asociadas a este item" ></i></a></td>
                        <td><a href="FormItem?contId=<%= lista.getIdItem() %>"><i class=" fi-page-edit  "></i></a></td>
                        <td><a href="javascript:void(0);" onclick="fn_eliminar(<%= lista.getIdItem() %>);" ><i class=" fi-trash"></i></a></td>

                    </tr>
                    <% } %>

                </table>
            </section>
          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
<script>

	</script>
      </footer>
    
    
  </body>
</html>
