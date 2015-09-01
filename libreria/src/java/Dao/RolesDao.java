/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.RolesDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class RolesDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<RolesDto> listadoTotal() {

        ArrayList<RolesDto> listado = new ArrayList<RolesDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM roles");
            rs = stmt.executeQuery();

            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                RolesDto unaliadonew = new RolesDto();
                unaliadonew.setIdRol(rs.getInt("id_rol"));
                unaliadonew.setNombre(rs.getString("nombre"));

                listado.add(unaliadonew);
            }
            
            

        } catch (SQLException sql) {

        }
        return listado;

    }
}