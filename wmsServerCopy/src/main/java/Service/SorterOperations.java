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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "sorter_operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SorterOperations.findAll", query = "SELECT s FROM SorterOperations s"),
    @NamedQuery(name = "SorterOperations.findByIdOperation", query = "SELECT s FROM SorterOperations s WHERE s.idOperation = :idOperation"),
    @NamedQuery(name = "SorterOperations.findByIdWorker", query = "SELECT s FROM SorterOperations s WHERE s.idWorker = :idWorker"),
    @NamedQuery(name = "SorterOperations.findByTypeOfOperation", query = "SELECT s FROM SorterOperations s WHERE s.typeOfOperation = :typeOfOperation"),
    @NamedQuery(name = "SorterOperations.findByDateOfOperation", query = "SELECT s FROM SorterOperations s WHERE s.dateOfOperation = :dateOfOperation"),
    @NamedQuery(name = "SorterOperations.findByIdProduct", query = "SELECT s FROM SorterOperations s WHERE s.idProduct = :idProduct"),
    @NamedQuery(name = "SorterOperations.findByCountOfProduct", query = "SELECT s FROM SorterOperations s WHERE s.countOfProduct = :countOfProduct")})
public class SorterOperations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOperation")
    private Integer idOperation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWorker")
    private int idWorker;
    @Size(max = 45)
    @Column(name = "typeOfOperation")
    private String typeOfOperation;
    @Size(max = 45)
    @Column(name = "dateOfOperation")
    private String dateOfOperation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProduct")
    private int idProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "countOfProduct")
    private int countOfProduct;

    public SorterOperations() {
    }

    public SorterOperations(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public SorterOperations(Integer idOperation, int idWorker, int idProduct, int countOfProduct) {
        this.idOperation = idOperation;
        this.idWorker = idWorker;
        this.idProduct = idProduct;
        this.countOfProduct = countOfProduct;
    }

    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(String dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCountOfProduct() {
        return countOfProduct;
    }

    public void setCountOfProduct(int countOfProduct) {
        this.countOfProduct = countOfProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SorterOperations)) {
            return false;
        }
        SorterOperations other = (SorterOperations) object;
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.SorterOperations[ idOperation=" + idOperation + " ]";
    }
    
}
