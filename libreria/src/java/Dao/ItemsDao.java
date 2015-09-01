/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.ItemsDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class ItemsDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<ItemsDto> listadoTotal() {

        ArrayList<ItemsDto> listado = new ArrayList<ItemsDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM items");
            rs = stmt.executeQuery();
            System.out.println(stmt);
            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                
                ItemsDto item = new ItemsDto();
                item.setIdItem(rs.getInt("id_item"));
                item.setTitulo(rs.getString("titulo"));                
                item.setAutor(rs.getString("autor"));
                item.setFechaAdicion(rs.getString("fecha_adicion"));
                item.setFechaPublicacion(rs.getString("fecha_publicacion"));
                item.setUrl(rs.getString("url"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setIdFormato(rs.getInt("id_formato"));
                item.setIdLicencia(rs.getInt("id_licencia"));
                item.setAnoCreacion(rs.getString("ano_creacion"));
                item.setPalabrasClaves(rs.getString("palabras_claves"));
                listado.add(item);
            }
            
            

        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return listado;

    }
    public Integer IngresarItem(ItemsDto inusu) {
        //boolean resul = false;
        Integer rta = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO items (`id_item`, `titulo`, `autor`, `fecha_adicion`, `url`, `descripcion`, `id_formato`, `id_licencia`, `ano_creacion`, `palabras_claves`)  VALUES (?,?,?,?,?,?,?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, null);
            stmt.setString(2, inusu.getTitulo());
            stmt.setString(3, inusu.getAutor());
            stmt.setString(4, inusu.getFechaAdicion());
            //stmt.setString(5, inusu.getFechaPublicacion());
            stmt.setString(5, inusu.getUrl());
            stmt.setString(6, inusu.getDescripcion());
            stmt.setInt(7, inusu.getIdFormato());
            stmt.setInt(8, inusu.getIdLicencia());
            stmt.setString(9, inusu.getAnoCreacion());
            stmt.setString(10, inusu.getPalabrasClaves());
            System.out.println(stmt);
           // String executedQuery = stmt.getStatement().toString();
           // System.out.println(executedQuery);
            

             int resultado = stmt.executeUpdate();
             rs = stmt.getGeneratedKeys();
                    if(rs.next())
                    {
                        //resul=false;
                        rta=rs.getInt(1);
                    }
                       
        }
        catch (SQLException sqle) 
            { 
                sqle.getMessage();
            }
    return rta;
    }
    public String ActualizarItem(ItemsDto inusu) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("UPDATE items SET id_item=?, titulo=?, autor=?, url=?, descripcion=?, id_formato=?,  id_licencia=?, ano_creacion=?, palabras_claves=? WHERE id_item=?;");
            stmt.setInt(1, inusu.getIdItem());
            stmt.setString(2, inusu.getTitulo());
            stmt.setString(3, inusu.getAutor());
            stmt.setString(4, inusu.getUrl());
            stmt.setString(5, inusu.getDescripcion());
            stmt.setInt(6, inusu.getIdFormato());
            stmt.setInt(7, inusu.getIdLicencia());;
            stmt.setString(8, inusu.getAnoCreacion());
            stmt.setString(9, inusu.getPalabrasClaves());
            stmt.setInt(10, inusu.getIdItem());
            //System.out.println(stmt);
            int resultado = stmt.executeUpdate();
            if (resultado == 0) {

                rta = "Fallo al actualizar";
            } else {
                rta = "Registro actualizado Exitosamente";
            }
        } catch (SQLException sqle) {
            rta = sqle.getMessage();
        }
        return rta;
    }
    public ItemsDto ObtenerItem(String contId) {

        Integer id = Integer.parseInt(contId);
        ItemsDto data = new ItemsDto();

        try {
            stmt = con.prepareStatement("SELECT * FROM items where id_item =?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                data.setIdItem(rs.getInt("id_item"));
                data.setTitulo(rs.getString("titulo"));                
                data.setAutor(rs.getString("autor"));
                data.setFechaAdicion(rs.getString("fecha_adicion"));
                data.setFechaPublicacion(rs.getString("fecha_publicacion"));
                data.setUrl(rs.getString("url"));
                data.setDescripcion(rs.getString("descripcion"));
                data.setIdFormato(rs.getInt("id_formato"));
                data.setIdLicencia(rs.getInt("id_licencia"));
                data.setAnoCreacion(rs.getString("ano_creacion"));
                data.setPalabrasClaves(rs.getString("palabras_claves"));
            }

        } catch (SQLException sql) {

        }
        return data;

    }
    public ItemsDto VerItem(String contId) {

        Integer id = Integer.parseInt(contId);
        ItemsDto data = new ItemsDto();

        try {
            stmt = con.prepareStatement("SELECT items.*, licencias.nombre as licencia, formatos.nombre as formato FROM items INNER JOIN licencias"
                                        + " ON items.id_licencia=licencias.id_licencia"
                                        + " INNER JOIN formatos ON items.id_formato=formatos.id_formato where items.id_item =?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                data.setIdItem(rs.getInt("id_item"));
                data.setTitulo(rs.getString("titulo"));                
                data.setAutor(rs.getString("autor"));
                data.setFechaAdicion(rs.getString("fecha_adicion"));
                data.setFechaPublicacion(rs.getString("fecha_publicacion"));
                data.setUrl(rs.getString("url"));
                data.setDescripcion(rs.getString("descripcion"));
                data.setFormato(rs.getString("formato"));
                data.setIdFormato(rs.getInt("id_formato"));
                data.setLicencia(rs.getString("licencia"));
                data.setIdLicencia(rs.getInt("id_licencia"));
                data.setAnoCreacion(rs.getString("ano_creacion"));
                data.setPalabrasClaves(rs.getString("palabras_claves"));
            }

        } catch (SQLException sql) {

        }
        return data;

    }
    public String EliminarItem(Integer id) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("DELETE FROM  items WHERE id_item= ?");
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
    public String PublicarItem(String fecha,Integer id) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("UPDATE items SET  fecha_publicacion=?  WHERE id_item= ?");
            stmt.setString(1, fecha);
            stmt.setInt(2, id);

            int resultado = stmt.executeUpdate();
            if (resultado == 0) {
                //resul=false;
                rta = "Fallo al actualizar";
            } else {
                rta = "Registro actualizado Exitosamente";
            }
        } catch (SQLException sqle) {
            rta = sqle.getMessage();
        }
        return rta;
    }
    public ArrayList<ItemsDto> listadoItemsCategoria(String contId) {

        Integer id = Integer.parseInt(contId);
        ArrayList<ItemsDto> listado = new ArrayList<ItemsDto>();

        try {
            stmt = con.prepareStatement("SELECT itm.* FROM items as itm "
                                        + "INNER JOIN items_categoria as itmc ON itm.id_item=itmc.id_item where itmc.id_categoria=? AND itm.fecha_publicacion IS NOT NULL");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            System.out.println(stmt);
            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                
                ItemsDto item = new ItemsDto();
                item.setIdItem(rs.getInt("id_item"));
                item.setTitulo(rs.getString("titulo"));                
                item.setAutor(rs.getString("autor"));
                item.setFechaAdicion(rs.getString("fecha_adicion"));
                item.setFechaPublicacion(rs.getString("fecha_publicacion"));
                item.setUrl(rs.getString("url"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setIdFormato(rs.getInt("id_formato"));
                item.setIdLicencia(rs.getInt("id_licencia"));
                item.setAnoCreacion(rs.getString("ano_creacion"));
                item.setPalabrasClaves(rs.getString("palabras_claves"));
                listado.add(item);
            }
            
            

        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return listado;

    }
    public ArrayList<ItemsDto> listadoItemsCategoriaBuscar(String contId) {


        ArrayList<ItemsDto> listado = new ArrayList<ItemsDto>();

        try {
            stmt = con.prepareStatement("SELECT * FROM items  where (titulo like ? OR autor like ? OR descripcion like ? OR  palabras_claves like ?) AND fecha_publicacion IS NOT NULL");
            stmt.setString(1, "%" + contId + "%");
            stmt.setString(2, "%" + contId + "%");
            stmt.setString(3, "%" + contId + "%");
            stmt.setString(4, "%" + contId + "%");
            rs = stmt.executeQuery();
            System.out.println(stmt);
            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                
                ItemsDto item = new ItemsDto();
                item.setIdItem(rs.getInt("id_item"));
                item.setTitulo(rs.getString("titulo"));                
                item.setAutor(rs.getString("autor"));
                item.setFechaAdicion(rs.getString("fecha_adicion"));
                item.setFechaPublicacion(rs.getString("fecha_publicacion"));
                item.setUrl(rs.getString("url"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setIdFormato(rs.getInt("id_formato"));
                item.setIdLicencia(rs.getInt("id_licencia"));
                item.setAnoCreacion(rs.getString("ano_creacion"));
                item.setPalabrasClaves(rs.getString("palabras_claves"));
                listado.add(item);
            }
            
            

        } catch (SQLException sqle) {
            sqle.getMessage();
        }
        return listado;

    }

}