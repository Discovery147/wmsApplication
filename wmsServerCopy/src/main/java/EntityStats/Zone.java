package EntityStats;

public class Zone {

    private int idzone;
    private String name;
    private int count;

    public Zone() {
    }

    public Zone(String name, int count) {
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

    @Override
    public String toString() {
        return "{\"idzone\":\"" + this.idzone + "\",\"name\":\"" + this.name + "\",\"count\":\"" + this.count + "\"}";
    }
}
