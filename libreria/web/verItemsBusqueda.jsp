<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.ItemsDto"  %>
<%@ page import="java.util.List" %>

<!doctype html>
<html class="no-js" lang="en">
  <head>
      <%@include file="header.jsp" %>
      <script type="text/javascript" >
            $(function(){
               $("#frmg").validate({
                    event: "submit",
                    rules: {

                    },
                    messages: {

                    },
                    debug: false
                    //*errorElement: 'div',*/
                    //errorContainer: $('#errores'),
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
            <ul class="right">
                <li class="divider"></li>
                <li><a href="index.jsp">Inicio</a></li>
                <li class="divider"></li>
                <li><a href="Catalogo"  >Catalogo</a></li>
                <li class="divider"></li>
                <li><a href="Acceso">Login</a></li>
                <li class="divider"></li>
            </ul>
        </section>
      </nav>
       <div class="row">
          <div class="large-12 columns">
            <ul class="breadcrumbs">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="Catalogo">Catalogo</a></li>
                <li class="current">Resultado busqueda: <%= request.getAttribute("busqueda") %> </li>
            </ul>
          </div> 
       </div>   
      <div class="row">
        <div class="large-12 columns">
          <div class="section-container tabs" data-section>
              
            <h3>Lista de items asociados</h3>  
            <section class="section">
              <br />
              <ol>
                  <% for (ItemsDto lista : (List<ItemsDto>)request.getAttribute("lineas_list")) {%>
                  <li><a href="VerItem?idItem=<%= lista.getIdItem() %>"> Autor: <%= lista.getAutor() %>, Titulo: <%= lista.getTitulo() %> </a> </li>
                  <% } %>
                  
              </ol>
            </section>

          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
