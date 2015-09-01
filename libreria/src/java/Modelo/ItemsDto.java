/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fernando
 */
public class ItemsDto {
    private Integer idItem;
    private Integer idLicencia;
    private Integer idFormato;
    private String titulo;
    private String autor;
    private String fechaAdicion;
    private String fechaPublicacion;
    private String url;
    private String descripcion;
    private String anoCreacion;
    private String palabrasClaves;
    private String licencia;
    private String formato;

    public ItemsDto() {
    }

    public ItemsDto(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaAdicion() {
        return fechaAdicion;
    }

    public void setFechaAdicion(String fechaAdicion) {
        this.fechaAdicion = fechaAdicion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  public String getAnoCreacion() {
        return anoCreacion;
    }

    public void setAnoCreacion(String anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public String getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItem != null ? idItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsDto)) {
            return false;
        }
        ItemsDto other = (ItemsDto) object;
        if ((this.idItem == null && other.idItem != null) || (this.idItem != null && !this.idItem.equals(other.idItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Items[ idItem=" + idItem + " ]";
    }

    /**
     * @return the idLicencia
     */
    public Integer getIdLicencia() {
        return idLicencia;
    }

    /**
     * @param idLicencia the idLicencia to set
     */
    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    /**
     * @return the idFormato
     */
    public Integer getIdFormato() {
        return idFormato;
    }

    /**
     * @param idFormato the idFormato to set
     */
    public void setIdFormato(Integer idFormato) {
        this.idFormato = idFormato;
    }

    /**
     * @return the licencia
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * @param licencia the licencia to set
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * @return the formato
     */
    public String getFormato() {
        return formato;
    }

    /**
     * @param formato the formato to set
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
}
