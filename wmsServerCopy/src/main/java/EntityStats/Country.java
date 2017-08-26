package EntityStats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country  implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idCountry") 
    private int idcountry;
    @Column(name = "name") 
    private String name;
    @Column(name = "deleted") 
    private boolean deleted;
    private int count;

    public Country() {
    }

    public Country(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public int getIdcountry() {
        return idcountry;
    }

    public String getName() {
        return name;
    }

    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "{\"idcountry\":\"" + this.idcountry + "\",\"name\":\"" + this.name + "\",\"count\":\"" + this.count + "\"}";
    }
}
