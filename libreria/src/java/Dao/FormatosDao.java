/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.FormatosDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class FormatosDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<FormatosDto> listadoTotal() {

        ArrayList<FormatosDto> listado = new ArrayList<FormatosDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM formatos");
            rs = stmt.executeQuery();

            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                FormatosDto unaliadonew = new FormatosDto();
                unaliadonew.setIdFormato(rs.getInt("id_formato"));
                unaliadonew.setNombre(rs.getString("nombre"));

                listado.add(unaliadonew);
            }
            
            

        } catch (SQLException sql) {

        }
        return listado;

    }
}