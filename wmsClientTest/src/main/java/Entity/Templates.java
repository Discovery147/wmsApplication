package Entity;

import java.util.ArrayList;
import java.util.List;

public class Templates {

    public List<Product> list = new ArrayList();
    public List<Product> list2 = new ArrayList();
    public List<Country> list3 = new ArrayList();
    public List<Zone> list4 = new ArrayList();
    public List<Worker> list5 = new ArrayList();
    public List<Worker> list6 = new ArrayList();

    public List<Product> getList() {
        return list;
    }

    public List<Product> getList2() {
        return list2;
    }

    public List<Country> getList3() {
        return list3;
    }

    public List<Zone> getList4() {
        return list4;
    }

    public List<Worker> getList5() {
        return list5;
    }

    public List<Worker> getList6() {
        return list6;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public void setList2(List<Product> list2) {
        this.list2 = list2;
    }

    public void setList3(List<Country> list3) {
        this.list3 = list3;
    }

    public void setList4(List<Zone> list4) {
        this.list4 = list4;
    }

    public void setList5(List<Worker> list5) {
        this.list5 = list5;
    }

    public void setList6(List<Worker> list6) {
        this.list6 = list6;
    }
    
}
