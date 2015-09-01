/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Mysql.Conexion;
import Modelo.UsuariosDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class UsuariosDao {
     
    Connection con = Conexion.getInstace();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ArrayList<UsuariosDto> listadoTotal() {

        ArrayList<UsuariosDto> listado = new ArrayList<UsuariosDto>();

        try {
            stmt = con.prepareStatement("SELECT usuarios.*, roles.nombre as perfil FROM usuarios INNER JOIN roles ON usuarios.id_rol=roles.id_rol");
            rs = stmt.executeQuery();

            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            while (rs.next()) {
                UsuariosDto unaliadonew = new UsuariosDto();
                unaliadonew.setNombre(rs.getString("nombre"));
                unaliadonew.setApellido(rs.getString("apellido"));
                unaliadonew.setEmail(rs.getString("email"));
                unaliadonew.setUsuario(rs.getString("usuario"));
                unaliadonew.setContrasena(rs.getString("contrasena"));
                unaliadonew.setIdRol(rs.getInt("id_rol"));
                unaliadonew.setIdUsuario(rs.getInt("id_usuario"));
                unaliadonew.setPerfil(rs.getString("perfil"));

                listado.add(unaliadonew);
            }
            
            

        } catch (SQLException sql) {

        }
        return listado;

    }
    public String IngresarItem(UsuariosDto inusu) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("INSERT INTO  usuarios  VALUES(?,?,?,?,?,?,?);");
            stmt.setString(1, null);
            stmt.setString(2, inusu.getNombre());
            stmt.setString(3, inusu.getApellido());
            stmt.setString(4, inusu.getEmail());
            stmt.setString(5, inusu.getUsuario());
            stmt.setString(6, inusu.getContrasena());
            stmt.setInt(7, inusu.getIdRol());
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
    public String ActualizarItem(UsuariosDto inusu) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET id_usuario=?, nombre =?, apellido=?, email=?, usuario=?,contrasena=?, id_rol=?  WHERE id_usuario=?;");
            stmt.setInt(1, inusu.getIdUsuario());
            stmt.setString(2, inusu.getNombre());
            stmt.setString(3, inusu.getApellido());
            stmt.setString(4, inusu.getEmail());
            stmt.setString(5, inusu.getUsuario());
            stmt.setString(6, inusu.getContrasena());
            stmt.setInt(7, inusu.getIdRol());
            stmt.setInt(8, inusu.getIdUsuario());
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
    public UsuariosDto ObtenerItem(String contId) {

        Integer id = Integer.parseInt(contId);
        UsuariosDto data = new UsuariosDto();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuarios where id_usuario =?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
                data.setNombre(rs.getString("nombre"));
                data.setApellido(rs.getString("apellido"));
                data.setEmail(rs.getString("email"));
                data.setUsuario(rs.getString("usuario"));
                data.setContrasena(rs.getString("contrasena"));
                data.setIdRol(rs.getInt("id_rol"));
                data.setIdUsuario(rs.getInt("id_usuario"));
            }

        } catch (SQLException sql) {

        }
        return data;

    }
    public String EliminarItem(Integer id) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("DELETE FROM  usuarios WHERE id_usuario= ?");
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
    public boolean verificarUsuario(String user) {
        boolean status = false; 
        //boolean resul = false;
        try {
            stmt = con.prepareStatement("select id_usuario from usuarios where usuario=? ");
            stmt.setString(1, user);

            rs  = stmt.executeQuery();
            
            String executedQuery = rs.getStatement().toString();
            System.out.println(executedQuery);
            
            status = rs.next();
        }
        catch (SQLException e) 
            { 
                System.out.println(e);
            }
    return status;
    }
    public String validateEmail (String correo){
        String nombre="";
        try {
            stmt = con.prepareStatement("select * from usuarios where email=?");
            stmt.setString(1, correo);

            rs  = stmt.executeQuery();
            
            if(rs.next()){
                nombre=rs.getString("id_usuario");
            }
        }
        catch (SQLException e)
            { 
                System.out.println(e);
            }
    return nombre;
           
    }
    public String ActualizarClave(Integer idusuario, String clave) {
        //boolean resul = false;
        String rta = "";
        try {
            stmt = con.prepareStatement("UPDATE usuarios SET contrasena=?  WHERE id_usuario=?;");
            stmt.setString(1, clave);
            stmt.setInt(2, idusuario);
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
    
}