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
<%@ page import="Modelo.CategoriasDto"  %>
<%@ page import="Dao.CategoriasDao" %>
<%@ page import="Modelo.LicenciasDto" %>
<%@ page import="Modelo.FormatosDto" %>
<%@ page import="Modelo.ItemsCategoriaDto"  %>
<%@ page import="java.text.DecimalFormat" %>
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
                        usuario:{
                            remote:"VerificarUsuario"
                        }
                    },
                    messages: {
                        usuario:{
                            remote:"el usuario ya se encuentra en el sistema, debe generar uno diferente"
                        }
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
                <li><a href="Items">Items repositorio</a></li>
                <li class="current">Formulario items</li>
                
            </ul>
          </div>        
         
        <div class="large-12 columns">
     
            <h3 class="title" >Crear o editar item</h3>
    
          <div class="section-container tabs" data-section>
            <section class="section">
                
              <form action="FormItem" name="frmg" id="frmg" method="post" >
                <%
                     if (request.getAttribute("datau") != null) {
                        ItemsDto item = (ItemsDto)request.getAttribute("datau");
                %>
                    <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Titulo del recurso</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='titulo' class="required" value="<%= item.getTitulo() %>"  />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Autor</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='autor' class="required" value="<%= item.getAutor() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Año de creación</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='ano_creacion' class="required number" maxlength="4" value="<%= item.getAnoCreacion() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Palabras claves:</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='palabras_claves' class="required " value="<%= item.getPalabrasClaves() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Tipo de licencia del item :</label>
                    </div>
                    <div class="large-10 columns">
                        <select name="licencia" class="required" >
                          <option value="">------</option>
                          <% for (LicenciasDto lista : (List<LicenciasDto>)request.getAttribute("licencias_list")) {%>
                          <option value="<%= lista.getIdLicencia() %>" <% if (lista.getIdLicencia().equals(item.getIdLicencia())) { %> selected <% }%> ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Url acceso recurso</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='url' class="required" value="<%= item.getUrl() %>" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Categorias</label>
                    </div>
                    <div class="large-10 columns">
                    <% for (CategoriasDto lista : (List<CategoriasDto>)request.getAttribute("roles_list")) {%>
                        <input type="checkbox" name="selectedItems" class="required" value="<%= lista.getIdCategoria() %>"  checked  /> <%= lista.getNombre() %> <br />
                    <% } %>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Descripción</label>
                    </div>
                    <div class="large-10 columns">
                        <textarea name="descripcion" rows="6" class="required" ><%= item.getDescripcion() %></textarea>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Formato</label>
                    </div>
                    <div class="large-10 columns">
                        <select name="formato" class="required" >
                            <option value="">------</option>
                          <% for (FormatosDto lista : (List<FormatosDto>)request.getAttribute("formatos_list")) {%>
                          <option value="<%= lista.getIdFormato() %>" <% if (lista.getIdFormato().equals(item.getIdFormato())) { %> selected <% }%>  ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                  <input type="hidden" name="idformato" value="<%= item.getIdItem() %>" />   
                <%}else{%>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Titulo del recurso</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='titulo' class="required"  />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Autor</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='autor' class="required" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Año de creación</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='ano_creacion' class="required number" maxlength="4" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Palabras claves:</label>
                    </div>
                    <div class="large-10 columns">
                        <input type='text' name='palabras_claves' class="required " />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Tipo de licencia del item :</label>
                    </div>
                    <div class="large-10 columns">
                        <select name="licencia" class="required" >
                          <% for (LicenciasDto lista : (List<LicenciasDto>)request.getAttribute("licencias_list")) {%>
                          <option value="<%= lista.getIdLicencia() %>" ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Url acceso recurso</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='url' class="required" />
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Categorias</label>
                    </div>
                    <div class="large-10 columns">
                    <% for (CategoriasDto lista : (List<CategoriasDto>)request.getAttribute("roles_list")) {%>
                    <input type="checkbox" name="selectedItems" class="required" value="<%= lista.getIdCategoria() %>"/> <%= lista.getNombre() %> <br />
                    <% } %>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Descripción</label>
                    </div>
                    <div class="large-10 columns">
                        <textarea name="descripcion" rows="6" class="required" ></textarea>
                    </div>
                  </div>
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Formato</label>
                    </div>
                    <div class="large-10 columns">
                        <select name="formato" class="required" >
                          <% for (FormatosDto lista : (List<FormatosDto>)request.getAttribute("formatos_list")) {%>
                          <option value="<%= lista.getIdFormato() %>" ><%= lista.getNombre() %></option>
                          <% } %>
                      </select>
                    </div>
                  </div>
                <%}%> 
                      
                  <input type="submit" name="enviar" class="button" value="Enviar" />
                </form>
            </section>
          </div>
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
