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
            $(function () {
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
                        <li><a href="Catalogo">Catalogo</a></li>
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
                    <li class="current"><a href="#">Login</a></li>
                </ul>
            </div> 
        </div>  
        <div class="row">
            <div class="large-12 columns">
                <div class="section-container tabs" data-section>
                    <section class="section">
                        <br />
                        
                        <h5 style="margin: auto 180px;" class="title"><a href="#panel1">Iniciar sesión</a></h5>
                        </br>
                        <div class="content" data-slug="panel1">
                            <form action="Login" name="frmg" id="frmg" method="post" >
                                <div class="row collapse">
                                    <div aling="ride">
                                    <div class="large-2 columns">
                                        <label class="col-sm-3 control-label" class="inline">Usuario</label>
                                    </div >
                                    </div>
                                    <div  class="large-4 columns">
                                        <input type='text' name='usuario' class="required" />
                                    </div>
                                    
                                </div>
                                <div class="row collapse">
                                     <div aling="ride">
                                    <div class="large-2 columns">
                                        <label class="inline">Contraseña</label>
                                    </div>
                                     </div>     
                                    <div class="large-4 columns">
                                        <input type='password' name='clave' class="required" />
                                    </div>
                                </div>
                                <p><a style="margin: auto 180px;" href="RecuperaClave">¿Olvido su contraseña?</a></p></p>
                                <input  type="submit" name="enviar" class="button" value="Enviar"  />
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
