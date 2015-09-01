<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.CategoriasDto"  %>
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
      <div>    
          <center>
           <img src="Archivos/logo.png"  WIDTH=200 HEIGHT=240 BORDER=0>
      </center>
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
      </div>
       <div class="row">
          <div class="large-12 columns">
            <ul class="breadcrumbs">
                <li><a href="index.jsp">Inicio</a></li>
                <li class="current"><a href="Catalogo">Catalogo</a></li>
            </ul>
          </div> 
       </div>   
      <div class="row">
        <div class="large-6 columns">
            Buscar
            <form action="VerItemsBusqueda" name="frmg" id="frmg" method="post" >
                <div class="row collapse">
                    <div class="large-8 columns left">
                        <input type='text' name='palabras_claves' class="required " />
                    </div>  
                    <div class="small-2 columns left ">
                        <input type="submit" name="enviar" class=" tiny button" value="Ir" />   
                    </div>
                  </div>
            </form>  
          <div class="section-container tabs" data-section>
            <h3>Categorias disponibles</h3>  
            <section class="section">
              <br />
              <ol>
                  <% for (CategoriasDto lista : (List<CategoriasDto>)request.getAttribute("categorias_list")) {%>
                  <li><a href="VerItemsCategoria?id=<%= lista.getIdCategoria() %>"> <%= lista.getNombre() %></a> </li>
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
