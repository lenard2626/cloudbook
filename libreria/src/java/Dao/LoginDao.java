/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.LoginDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class LoginDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public boolean validate(LoginDto inusu) {
        boolean status = false; 
        //boolean resul = false;
        try {
            stmt = con.prepareStatement("select * from usuarios where usuario=? and contrasena=?");
            stmt.setString(1, inusu.getUsuario());
            stmt.setString(2, inusu.getContasena());

//            String executedQuery = rs.getStatement().toString();
//            System.out.println(executedQuery);
            
            rs  = stmt.executeQuery();
            
            status = rs.next();
        }
        catch (SQLException e) 
            { 
                System.out.println(e);
            }
    return status;
    }
    
    public Integer rol(LoginDto inusu){
        int status=0; 
        //boolean resul = false;
        try {
            stmt = con.prepareStatement("select * from usuarios where usuario=? and contrasena=?");
            stmt.setString(1, inusu.getUsuario());
            stmt.setString(2, inusu.getContasena());

            rs  = stmt.executeQuery();
            
            if(rs.next()){
                status=rs.getInt("id_rol");
            }
        }
        catch (SQLException e) 
            { 
                System.out.println(e);
            }
    return status;
        
    }
    public String nombreUsuario (LoginDto inusu){
        String nombre="";
        try {
            stmt = con.prepareStatement("select * from usuarios where usuario=? and contrasena=?");
            stmt.setString(1, inusu.getUsuario());
            stmt.setString(2, inusu.getContasena());

            rs  = stmt.executeQuery();
            
            if(rs.next()){
                nombre=rs.getString("nombre")+" "+rs.getString("apellido");
            }
        }
        catch (SQLException e)
            { 
                System.out.println(e);
            }
    return nombre;
           
    }
    
    
}