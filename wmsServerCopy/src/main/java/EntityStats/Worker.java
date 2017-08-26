package EntityStats;

public class Worker {

    private int idworker;
    private String firstname;
    private String date;
    private String position;
    private int count;

    public Worker() {
    }

    public Worker(String date, String firstname, int count) {
        this.count = count;
        this.firstname = firstname;
        this.date = date;
    }

    public Worker(String position, int count) {
        this.count = count;
        this.position = position;
    }

    public int getIdworker() {
        return idworker;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getDate() {
        return date;
    }

    public void setIdworker(int idworker) {
        this.idworker = idworker;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "{\"idworker\":\"" + this.idworker + "\",\"firstname\":\"" + this.firstname + "\",\"date\":\"" + this.date + "\",\"position\":\"" + this.position + "\",\"count\":\"" + this.count + "\"}";
    }
}
