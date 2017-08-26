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
@Table(name = "shippers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippers.findAll", query = "SELECT s FROM Shippers s"),
    @NamedQuery(name = "Shippers.findByIdShipper", query = "SELECT s FROM Shippers s WHERE s.idShipper = :idShipper"),
    @NamedQuery(name = "Shippers.findByOrganization", query = "SELECT s FROM Shippers s WHERE s.organization = :organization"),
    @NamedQuery(name = "Shippers.findByAddress", query = "SELECT s FROM Shippers s WHERE s.address = :address"),
    @NamedQuery(name = "Shippers.findByEmail", query = "SELECT s FROM Shippers s WHERE s.email = :email"),
    @NamedQuery(name = "Shippers.findByPhoneOfResponsible", query = "SELECT s FROM Shippers s WHERE s.phoneOfResponsible = :phoneOfResponsible")})
public class Shippers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idShipper")
    private Integer idShipper;
    @Size(max = 100)
    @Column(name = "Organization")
    private String organization;
    @Size(max = 100)
    @Column(name = "Address")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    @Size(max = 45)
    @Column(name = "phoneOfResponsible")
    private String phoneOfResponsible;

    public Shippers() {
    }

    public Shippers(Integer idShipper) {
        this.idShipper = idShipper;
    }

    public Integer getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(Integer idShipper) {
        this.idShipper = idShipper;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneOfResponsible() {
        return phoneOfResponsible;
    }

    public void setPhoneOfResponsible(String phoneOfResponsible) {
        this.phoneOfResponsible = phoneOfResponsible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShipper != null ? idShipper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippers)) {
            return false;
        }
        Shippers other = (Shippers) object;
        if ((this.idShipper == null && other.idShipper != null) || (this.idShipper != null && !this.idShipper.equals(other.idShipper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Shippers[ idShipper=" + idShipper + " ]";
    }
    
}
