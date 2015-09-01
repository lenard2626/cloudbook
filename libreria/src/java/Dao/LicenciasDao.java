/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.LicenciasDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class LicenciasDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<LicenciasDto> listadoTotal() {

        ArrayList<LicenciasDto> listado = new ArrayList<LicenciasDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM licencias");
            rs = stmt.executeQuery();

            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                LicenciasDto unaliadonew = new LicenciasDto();
                unaliadonew.setIdLicencia(rs.getInt("id_licencia"));
                unaliadonew.setNombre(rs.getString("nombre"));

                listado.add(unaliadonew);
            }
            
            

        } catch (SQLException sql) {

        }
        return listado;

    }
}