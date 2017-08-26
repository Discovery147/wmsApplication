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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "arrival")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arrival.findAll", query = "SELECT a FROM Arrival a"),
    @NamedQuery(name = "Arrival.findByIdArrival", query = "SELECT a FROM Arrival a WHERE a.idArrival = :idArrival"),
    @NamedQuery(name = "Arrival.findByDateOfArrival", query = "SELECT a FROM Arrival a WHERE a.dateOfArrival = :dateOfArrival"),
    @NamedQuery(name = "Arrival.findByNumberOfInvoice", query = "SELECT a FROM Arrival a WHERE a.numberOfInvoice = :numberOfInvoice"),
    @NamedQuery(name = "Arrival.findByIdShipper", query = "SELECT a FROM Arrival a WHERE a.idShipper = :idShipper"),
    @NamedQuery(name = "Arrival.findByIdProduct", query = "SELECT a FROM Arrival a WHERE a.idProduct = :idProduct"),
    @NamedQuery(name = "Arrival.findByCountProduct", query = "SELECT a FROM Arrival a WHERE a.countProduct = :countProduct"),
    @NamedQuery(name = "Arrival.findByIdWorker", query = "SELECT a FROM Arrival a WHERE a.idWorker = :idWorker"),
    @NamedQuery(name = "Arrival.findByPlaceArrival", query = "SELECT a FROM Arrival a WHERE a.placeArrival = :placeArrival")})
public class Arrival implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArrival")
    private Integer idArrival;
    @Size(max = 45)
    @Column(name = "dateOfArrival")
    private String dateOfArrival;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfInvoice")
    private int numberOfInvoice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idShipper")
    private int idShipper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduct")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "countProduct")
    private int countProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWorker")
    private int idWorker;
    @Size(max = 45)
    @Column(name = "placeArrival")
    private String placeArrival;

    public Arrival() {
    }

    public Arrival(Integer idArrival) {
        this.idArrival = idArrival;
    }

    public Arrival(Integer idArrival, int numberOfInvoice, int idShipper, int idProduct, int countProduct, int idWorker) {
        this.idArrival = idArrival;
        this.numberOfInvoice = numberOfInvoice;
        this.idShipper = idShipper;
        this.idProduct = idProduct;
        this.countProduct = countProduct;
        this.idWorker = idWorker;
    }

    public Integer getIdArrival() {
        return idArrival;
    }

    public void setIdArrival(Integer idArrival) {
        this.idArrival = idArrival;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getNumberOfInvoice() {
        return numberOfInvoice;
    }

    public void setNumberOfInvoice(int numberOfInvoice) {
        this.numberOfInvoice = numberOfInvoice;
    }

    public int getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(int idShipper) {
        this.idShipper = idShipper;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getPlaceArrival() {
        return placeArrival;
    }

    public void setPlaceArrival(String placeArrival) {
        this.placeArrival = placeArrival;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArrival != null ? idArrival.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arrival)) {
            return false;
        }
        Arrival other = (Arrival) object;
        if ((this.idArrival == null && other.idArrival != null) || (this.idArrival != null && !this.idArrival.equals(other.idArrival))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Arrival[ idArrival=" + idArrival + " ]";
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
