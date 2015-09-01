/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author P C
 */
public class LoginDto {
    private String usuario;
    private String contasena;

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contasena
     */
    public String getContasena() {
        return contasena;
    }

    /**
     * @param contasena the contasena to set
     */
    public void setContasena(String contasena) {
        this.contasena = contasena;
    }

}
