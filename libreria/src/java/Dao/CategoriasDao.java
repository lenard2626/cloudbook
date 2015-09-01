/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.CategoriasDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class CategoriasDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<CategoriasDto> listadoTotal() {

        ArrayList<CategoriasDto> listado = new ArrayList<CategoriasDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM categorias");
            rs = stmt.executeQuery();

            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                CategoriasDto unaliadonew = new CategoriasDto();
                unaliadonew.setIdCategoria(rs.getInt("id_categoria"));
                unaliadonew.setNombre(rs.getString("nombre"));

                listado.add(unaliadonew);
            }
            
            

        } catch (SQLException sql) {

        }
        return listado;

    }
    public ArrayList<CategoriasDto> ObtenerCategoriasItem(String contId) {

        Integer id = Integer.parseInt(contId);
        ArrayList<CategoriasDto> listado = new ArrayList<CategoriasDto>();

        try {
            stmt = con.prepareStatement("SELECT cat.id_categoria, cat.nombre FROM items_categoria as ic INNER JOIN categorias as cat ON  ic.id_categoria=cat.id_categoria where ic.id_item =?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            System.out.println(stmt);
            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
           while (rs.next()) {
                CategoriasDto data = new CategoriasDto();
                data.setIdCategoria(rs.getInt("id_categoria"));
                data.setNombre(rs.getString("nombre"));
                listado.add(data);
            }
            
            

        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return listado;

    }
    public CategoriasDto ObtenerItem(String contId) {

        Integer id = Integer.parseInt(contId);
        CategoriasDto data = new CategoriasDto();

        try {
            stmt = con.prepareStatement("SELECT * FROM categorias where id_categoria =?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                data.setIdCategoria(rs.getInt("id_categoria"));
                data.setNombre(rs.getString("nombre"));
                
            }

        } catch (SQLException sql) {

        }
        return data;

    }
    public String EliminarItemCategoria(Integer id, Integer iditem) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("DELETE FROM  items_categoria WHERE id_categoria=? AND id_item=?");
            stmt.setInt(1, id);
            stmt.setInt(2, iditem);

            int resultado = stmt.executeUpdate();
            if (resultado == 0) {
                //resul=false;
                rta = "Fallo al eliminar";
            } else {
                rta = "Registro eliminado Exitosamente";
            }
        } catch (SQLException sqle) {
            rta = sqle.getMessage();
        }
        return rta;
    }
}