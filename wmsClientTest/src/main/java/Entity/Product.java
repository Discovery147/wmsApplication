package Entity;
public class Product {
    private int idproduct;
    private String name;
    private String type;
    private String measure;
    private String code;  
    private int count;
    public Product(int idproduct, String name, String type, String measure, String code)
    {
        this.idproduct = idproduct;
        this.name = name;
        this.type = type;
        this.measure = measure;
        this.code = code;
    }    
    public Product(String type, int count)
    {
        this.type = type;
        this.count = count;
    }
    public int getIdproduct() {
        return idproduct;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMeasure() {
        return measure;
    }

    public String getCode() {
        return code;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
