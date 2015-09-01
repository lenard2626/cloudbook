/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class FormatosDto{
    private Integer idFormato;
    private String nombre;

    public FormatosDto() {
    }

    public FormatosDto(Integer idFormato) {
        this.idFormato = idFormato;
    }

    public Integer getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Integer idFormato) {
        this.idFormato = idFormato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormato != null ? idFormato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormatosDto)) {
            return false;
        }
        FormatosDto other = (FormatosDto) object;
        if ((this.idFormato == null && other.idFormato != null) || (this.idFormato != null && !this.idFormato.equals(other.idFormato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.FormatosDto[ idFormato=" + idFormato + " ]";
    }
    
}
