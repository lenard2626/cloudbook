%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@ page  import="java.io.*"%> 
<%@ page  import="java.sql.Connection"%> 
<%@ page  import="java.sql.DriverManager"%>
<%@ page  import="java.util.HashMap"%>
<%@ page  import="java.util.Map"%>
<%@page   import="net.sf.jasperreports.engine.*" %>
<%@page   import="net.sf.jasperreports.view.JasperViewer"%>
 
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <%
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria_dublin", "root", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
          InputStream inputStream = null;
        try {
            inputStream = new FileInputStream (application.getRealPath("reportUsuarios.jrxml"));
        } catch (FileNotFoundException ex) {
            System.out.print(ex);
        }
        Map parameters = new HashMap();
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,conn);
        JasperExportManager.exportReportToPdfFile(jasperPrint, application.getRealPath("reportUsuarios.pdf"));
        
        

        

        
        
            /*
            Connection conn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria_dublin", "root", "");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
                    
            File reportFile = new File(application.getRealPath("reportUsuarios.jasper"));//your report_name.jasper file
            Map parameters = new HashMap();
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, conn);
 
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();
                    */
        %>
        <a href="http://localhost:8080/libreria/reportUsuarios.pdf">Ver archivo generado</a>
    </body>
</html>