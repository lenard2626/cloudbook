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

public class ItemsCategoriaDto {
    private Integer id;
    private int idItem;
    private int idCategoria;

    public ItemsCategoriaDto() {
    }

    public ItemsCategoriaDto(Integer id) {
        this.id = id;
    }

    public ItemsCategoriaDto(Integer id, int idItem, int idCategoria) {
        this.id = id;
        this.idItem = idItem;
        this.idCategoria = idCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsCategoriaDto)) {
            return false;
        }
        ItemsCategoriaDto other = (ItemsCategoriaDto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ItemsCategoria[ id=" + id + " ]";
    }
    
}
