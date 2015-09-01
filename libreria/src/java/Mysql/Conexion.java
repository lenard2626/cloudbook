/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class Conexion {

    static Connection con = null;
 
 
 
public static Connection Conexion() {
  try {
   
   String driver = "com.mysql.jdbc.Driver";
   String url = "jdbc:mysql://localhost:3306/";
   String basededatos ="libreria_dublin";
   String usuario = "root";
   String clave = "654321";
    
   Class.forName(driver).newInstance();
   con = DriverManager.getConnection(url+basededatos, usuario,clave);
    } catch (InstantiationException | IllegalAccessException
     | ClassNotFoundException | SQLException e) {
    e.printStackTrace();
    }
        return con;
 }
 
 
public static Connection getInstace() {
        if (con == null) {
            Conexion();
        }
        return con;
    } 


 public void cerrarConexion(){
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }
    
}
