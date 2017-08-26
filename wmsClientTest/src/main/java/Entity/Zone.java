package Entity;

public class Zone {
    private int idzone;
    private String name; 
    private int count;
    public Zone(String name, int count)
    {
        this.count = count;
        this.name = name;
    } 

    public int getIdzone() {
        return idzone;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setIdzone(int idzone) {
        this.idzone = idzone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
