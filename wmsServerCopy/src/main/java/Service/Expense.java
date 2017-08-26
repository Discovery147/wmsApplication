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
@Table(name = "expense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expense.findAll", query = "SELECT e FROM Expense e"),
    @NamedQuery(name = "Expense.findByIdExpense", query = "SELECT e FROM Expense e WHERE e.idExpense = :idExpense"),
    @NamedQuery(name = "Expense.findByDateOfExpense", query = "SELECT e FROM Expense e WHERE e.dateOfExpense = :dateOfExpense"),
    @NamedQuery(name = "Expense.findByNumberOfInvoice", query = "SELECT e FROM Expense e WHERE e.numberOfInvoice = :numberOfInvoice"),
    @NamedQuery(name = "Expense.findByIdShipper", query = "SELECT e FROM Expense e WHERE e.idShipper = :idShipper"),
    @NamedQuery(name = "Expense.findByIdProduct", query = "SELECT e FROM Expense e WHERE e.idProduct = :idProduct"),
    @NamedQuery(name = "Expense.findByIdOfDestination", query = "SELECT e FROM Expense e WHERE e.idOfDestination = :idOfDestination"),
    @NamedQuery(name = "Expense.findByCountProduct", query = "SELECT e FROM Expense e WHERE e.countProduct = :countProduct"),
    @NamedQuery(name = "Expense.findByIdWorker", query = "SELECT e FROM Expense e WHERE e.idWorker = :idWorker")})
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idExpense")
    private Integer idExpense;
    @Size(max = 45)
    @Column(name = "dateOfExpense")
    private String dateOfExpense;
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
    @Column(name = "idOfDestination")
    private int idOfDestination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "countProduct")
    private int countProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWorker")
    private int idWorker;

    public Expense() {
    }

    public Expense(Integer idExpense) {
        this.idExpense = idExpense;
    }

    public Expense(Integer idExpense, int numberOfInvoice, int idShipper, int idProduct, int idOfDestination, int countProduct, int idWorker) {
        this.idExpense = idExpense;
        this.numberOfInvoice = numberOfInvoice;
        this.idShipper = idShipper;
        this.idProduct = idProduct;
        this.idOfDestination = idOfDestination;
        this.countProduct = countProduct;
        this.idWorker = idWorker;
    }

    public Integer getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(Integer idExpense) {
        this.idExpense = idExpense;
    }

    public String getDateOfExpense() {
        return dateOfExpense;
    }

    public void setDateOfExpense(String dateOfExpense) {
        this.dateOfExpense = dateOfExpense;
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

    public int getIdOfDestination() {
        return idOfDestination;
    }

    public void setIdOfDestination(int idOfDestination) {
        this.idOfDestination = idOfDestination;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpense != null ? idExpense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expense)) {
            return false;
        }
        Expense other = (Expense) object;
        if ((this.idExpense == null && other.idExpense != null) || (this.idExpense != null && !this.idExpense.equals(other.idExpense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Expense[ idExpense=" + idExpense + " ]";
    }
    
}
