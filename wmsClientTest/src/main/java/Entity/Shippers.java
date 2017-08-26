package Entity;

public class Shippers {
    private int idshipper;
    private String organization;
    private String address;
    private String email;
    private String phone;    
    public Shippers(int idshipper, String organization, String address, String email, String phone)
    {
        this.idshipper = idshipper;
        this.organization = organization;
        this.address = address;
        this.email = email;
        this.phone = phone;
    } 
    public int getIdshipper() {
        return idshipper;
    }
    public String getOrganization() {
        return organization;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public void setIdshipper(int idshipper) {
        this.idshipper = idshipper;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }    
}
