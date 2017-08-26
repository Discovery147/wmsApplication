/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByIdProduct", query = "SELECT a FROM Area a WHERE a.idProduct = :idProduct"),
    @NamedQuery(name = "Area.findByRow", query = "SELECT a FROM Area a WHERE a.row = :row"),
    @NamedQuery(name = "Area.findByPlace", query = "SELECT a FROM Area a WHERE a.place = :place"),
    @NamedQuery(name = "Area.findByLevel", query = "SELECT a FROM Area a WHERE a.level = :level")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduct")
    private Integer idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Row")
    private int row;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Place")
    private int place;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Level")
    private int level;
    @NotNull
    @Column(name = "Count")
    private int count;
    @NotNull
    @Column(name = "idTable")
    private int idTable;

    public Area() {
    }

    public Area(Integer idProduct) {
        this.idProduct = idProduct;
    }
    
    public Area(Integer idTable, Integer idProduct) {
        this.idTable = idTable;
        this.idProduct = idProduct;
    }

    public Area(Integer idProduct, int row, int place, int level) {
        this.idProduct = idProduct;
        this.row = row;
        this.place = place;
        this.level = level;
    }

    public int getIdTable() {
        return idTable;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Area[ idProduct=" + idProduct + " ]";
    }

}
