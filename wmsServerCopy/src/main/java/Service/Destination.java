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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sizon
 */
@Entity
@Table(name = "destination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destination.findAll", query = "SELECT d FROM Destination d"),
    @NamedQuery(name = "Destination.findByIdOfDestination", query = "SELECT d FROM Destination d WHERE d.idOfDestination = :idOfDestination"),
    @NamedQuery(name = "Destination.findByOrganization", query = "SELECT d FROM Destination d WHERE d.organization = :organization"),
    @NamedQuery(name = "Destination.findByAddress", query = "SELECT d FROM Destination d WHERE d.address = :address"),
    @NamedQuery(name = "Destination.findByContactPhone", query = "SELECT d FROM Destination d WHERE d.contactPhone = :contactPhone")})
public class Destination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOfDestination")
    private Integer idOfDestination;
    @Size(max = 45)
    @Column(name = "Organization")
    private String organization;
    @Size(max = 45)
    @Column(name = "Address")
    private String address;
    @Size(max = 45)
    @Column(name = "ContactPhone")
    private String contactPhone;

    public Destination() {
    }

    public Destination(Integer idOfDestination) {
        this.idOfDestination = idOfDestination;
    }

    public Integer getIdOfDestination() {
        return idOfDestination;
    }

    public void setIdOfDestination(Integer idOfDestination) {
        this.idOfDestination = idOfDestination;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfDestination != null ? idOfDestination.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destination)) {
            return false;
        }
        Destination other = (Destination) object;
        if ((this.idOfDestination == null && other.idOfDestination != null) || (this.idOfDestination != null && !this.idOfDestination.equals(other.idOfDestination))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service.Destination[ idOfDestination=" + idOfDestination + " ]";
    }
    
}
