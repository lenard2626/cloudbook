/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.ItemsCategoriaDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author fernando
 */
public class ItemsCategoriaDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    public String IngresarItem(ItemsCategoriaDto inusu) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("INSERT INTO  items_categoria  VALUES(?,?,?);");
            stmt.setString(1, null);
            stmt.setInt(2, inusu.getIdItem() );
            stmt.setInt(3, inusu.getIdCategoria());
            System.out.println(stmt);
           // String executedQuery = stmt.getStatement().toString();
           // System.out.println(executedQuery);
            

             int resultado = stmt.executeUpdate();
                    if(resultado==0)
                    {
                        //resul=false;
                        rta="Fallo el ingreso del registro";
                    }
                    else
                        {
                         rta="Registro ingresado exitosamente";
                        }   
        }
        catch (SQLException sqle) 
            { 
                rta=sqle.getMessage();
            }
    return rta;
    }
    public ArrayList<ItemsCategoriaDto> ObtenerItems(String contId) {

        Integer id = Integer.parseInt(contId);
        ArrayList<ItemsCategoriaDto> listado = new ArrayList<ItemsCategoriaDto>();

        try {
            stmt = con.prepareStatement("SELECT id_categoria FROM items_categoria where id_item =?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            //System.out.println(stmt);
            //String executedQuery = rs.getStatement().toString();
            //System.out.println(executedQuery);
            
           while (rs.next()) {
                ItemsCategoriaDto data = new ItemsCategoriaDto();
                data.setIdCategoria(rs.getInt("id_categoria"));
                listado.add(data);
            }
            
            

        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return listado;

    }
    public String EliminarItems(Integer id) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("DELETE FROM  items_categoria WHERE id_item= ?");
            stmt.setInt(1, id);

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