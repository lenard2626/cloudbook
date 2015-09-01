/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author fernando
 */
public class Mailer {
    
    public static void sendEmail(String nombres, String asunto, String toAddress, String usuario, String clave) throws AddressException,
            MessagingException {
        
        final String userName="senaautoevaluacion@gmail.com";//change accordingly  
        final String password="123qaz12";  
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        
        String message = "<p><i>Señor:"+ nombres +"</i></p>";
        message += "<p>Se le ha generado un usuario para el aplicativo libreria los datos de acceso son:</p>";
        message += "<p>Usuario: <b>"+ usuario +"</b></p>";
        message += "<p>Clave: <b>"+ clave +"</b></p>";
        message += "<font color=red>Gracias</font>";
        
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
    public static void sendEmailClave(String nombre,String apellidos,String asunto, String toAddress, String usuario, String clave) throws AddressException,
            MessagingException {
        
        final String userName="senaautoevaluacion@gmail.com";//change accordingly  
        final String password="123qaz12";  
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
        
        String message = "<p><i>Señor:"+ nombre +" "+apellidos+"</i></p>";
        message += "<p>Se le ha generado una nueva contraseña:</p>";
        message += "<p>Usuario: <b>"+ usuario +"</b></p>";
        message += "<p>Clave: <b>"+ clave +"</b></p>";
        message += "<font color=red>Gracias</font>";
        
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
 
    }
    
}
