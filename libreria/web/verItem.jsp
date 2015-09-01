<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.CategoriasDto"  %>
<%@ page import="Modelo.ItemsDto"  %>
<%@ page import="java.util.List" %>
<%
                    CategoriasDto item = (CategoriasDto)request.getAttribute("categoria");
                    ItemsDto data = (ItemsDto)request.getAttribute("datau");
%>
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
                <li><a href="VerItemsCategoria?id=<%= item.getIdCategoria()%>"> Categoria: <%= item.getNombre()%></a>  </li>
                <li class="current">Item : <%= data.getTitulo() %>  </li>
            </ul>
          </div> 
       </div>   
      <div class="row">
        <div class="large-12 columns">
          <div class="section-container tabs" data-section>
              
            <h3><%= data.getTitulo() %></h3>  
            <section class="section">
              <br />
              <div id="inf-item">
              <h4>Autor:</h4>
              <p><%= data.getAutor() %></p>
              <hr />
              <h4>Descripción:</h4>
              <p><%= data.getDescripcion() %></p>
              <hr />
              <h4>Palabras claves:</h4>
              <p><%= data.getPalabrasClaves() %></p>
              <hr />
              <h4>Año de creación:</h4>
              <p><%= data.getAnoCreacion() %></p>
              <hr />
              <h4>Fecha adición al catalogo:</h4>
              <p><%= data.getFechaAdicion() %></p>
              <hr />
              <h4>Fecha de publicación en el catalogo:</h4>
              <p><%= data.getFechaPublicacion() %></p>
              <hr />
              <h4>Licencia:</h4>
              <p><%= data.getLicencia() %></p>
              
              
              <hr />
              <h4>Fichero asociado al ítem</h4>
              <% if (data.getIdFormato().equals(1)){ %>
              <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" > <i class="step fi-music" style="font-size: 5em;" ></i></a> <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" class="ver-abrir"> Ver/Abrir</a>
              <% }else if(data.getIdFormato().equals(2)){ %>
              <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" > <i class="step fi-page-filled" style="font-size: 5em;"></i></a> <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" class="ver-abrir"> Ver/Abrir</a>
              <% }else if(data.getIdFormato().equals(3)){ %>
              <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" > <i class="step fi-photo" style="font-size: 5em;"></i></a> <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" class="ver-abrir"> Ver/Abrir</a>
              <% }else { %>
              <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" > <i class="step fi-video" style="font-size: 5em;"></i></a> <a href="<%= data.getUrl() %>" title="<%= data.getTitulo() %>" class="ver-abrir" > Ver/Abrir</a>
              <% } %>
              <hr />
              <h4>Este ítem se encuentra registrado en la categorias</h4>
              <ol>
                  <% for (CategoriasDto lista : (List<CategoriasDto>)request.getAttribute("categorias_list")) {%>
                  <li> <%= lista.getNombre() %> </li>
                  <% } %>
                  
              </ol>
              
              </div>
              
            </section>

          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
