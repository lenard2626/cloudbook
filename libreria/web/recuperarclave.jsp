<%-- 
    Document   : index
    Created on : 15-may-2015, 8:19:26
    Author     : fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <li><a href="Catalogo">Catalogo</a></li>
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
                <li class="current"><a href="#">Recuperar clave</a></li>
            </ul>
          </div> 
       </div>  
      <div class="row">
        <div class="large-12 columns">
          <div class="section-container tabs" data-section>
            <section class="section">
              <br />
              <h5 class="title">Digite su correo registrado</h5>
              <div class="content" data-slug="panel1">
                <form action="RecuperaClave" name="frmg" id="frmg" method="post" >
                  <div class="row collapse">
                    <div class="large-2 columns">
                      <label class="inline">Email</label>
                    </div>
                    <div class="large-10 columns">
                      <input type='text' name='email' class="required email" />
                    </div>
                  </div>
                  <input type="submit" name="enviar" class="button" value="Enviar" />
                </form>
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
