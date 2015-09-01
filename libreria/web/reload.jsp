<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

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
     
          <h3>Elija un archivo para subir en servidor</h3>
        <form action="UploadFile" method="post" enctype="multipart/form-data">
                <input type="file" name="file" /> 
                <input type="submit" value="upload" />
        </form>
     
         
        </div>
       
      </div>
      <footer class="row">
        <%@include file="footer.jsp" %>  
      </footer>
    
    
  </body>
</html>
