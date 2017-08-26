package Entity;

public class Country {
    private int idcountry;
    private String name;  
    private int count;
    public Country(String name, int count)
    {
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
    
}
