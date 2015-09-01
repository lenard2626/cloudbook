/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.ItemsDto;
import Mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class ItemDao {
    
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
      public String ingresarItems(ItemsDto ingresarItems) throws SQLException, ClassCastException, ClassNotFoundException {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("INSERT INTO items  VALUES(?,?,?,?,?,?,?,?,?,?,?);");
         
            stmt.setInt(1, ingresarItems.getIdItem());
            stmt.setString(2, ingresarItems.getTitulo());
            stmt.setString(3, ingresarItems.getAutor());
            stmt.setString(4, ingresarItems.getFechaAdicion());
            stmt.setString(5, ingresarItems.getFechaPublicacion());
            stmt.setString(6, ingresarItems.getUrl());
            stmt.setString(7, ingresarItems.getDescripcion());
            stmt.setInt(8, ingresarItems.getIdFormato());
            stmt.setInt(9,ingresarItems.getIdLicencia());
            stmt.setString(10, ingresarItems.getAnoCreacion());
            stmt.setString(11, ingresarItems.getPalabrasClaves());
         

            int resultado = stmt.executeUpdate();
            if (resultado == 0) {
                //resul=false;
                rta = "Usuario No Registrado";
            } else {
                rta = "Usuario Registrado";
            }

        } catch (SQLException sqle) {
            rta = "Error en registro :"+sqle.getMessage();
        } 
        return rta;
    }
    
}
