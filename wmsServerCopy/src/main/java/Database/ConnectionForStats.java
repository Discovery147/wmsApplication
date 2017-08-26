package Database;

import EntityStats.*;
import java.sql.SQLException;
import java.util.*;

public class ConnectionForStats extends Сommunication {

    Templates temp;
    public ConnectionForStats(String base) throws ClassNotFoundException, SQLException {
        super(base);
        temp = new Templates();
    }

    private void showProducts() throws SQLException {
        List<Product> listProducts = new ArrayList<>();
        statement = con.prepareStatement("SELECT * FROM products WHERE deleted = false");
        result = statement.executeQuery();
        
        Product product;
        while (result.next()) {
            product = new Product();
            product.setIdproduct(result.getInt("idProduct"));
            product.setName(result.getString("name"));
            product.setType(result.getString("type"));
            product.setMeasure(result.getString("measure"));
            product.setCode(result.getString("code"));
            
            listProducts.add(product);
        }
        temp.setList(listProducts);
    }

    private void showArea() throws SQLException {
        List<Product> listProducts = new ArrayList<>();
        statement = con.prepareStatement("SELECT products.type AS type, COUNT(*) AS count FROM area "
                + "JOIN products ON area.idProduct = products.idProduct "
                + "GROUP BY products.type");
        result = statement.executeQuery();
        Product product;
        while (result.next()) {
            product = new Product();
            product.setType(result.getString("type"));
            product.setCount(result.getInt("count"));
            listProducts.add(product);
        }
        temp.setList2(listProducts);
    }

    private void showCountries() throws SQLException {
        List<Country> listConuntries = new ArrayList<>();
        statement = con.prepareStatement("SELECT country.name AS name, COUNT(*) AS count "
                + "FROM shipperscountry JOIN country ON shipperscountry.idCountry = country.idCountry GROUP BY shipperscountry.idCountry");
        result = statement.executeQuery();
        Country country;
        while (result.next()) {
            country = new Country();
            country.setName(result.getString("name"));
            country.setCount(result.getInt("count"));
            listConuntries.add(country);
        }
        temp.setList3(listConuntries);
    }

    private void showZones() throws SQLException {
        List<Zone> listZones = new ArrayList<>();
        statement = con.prepareStatement("SELECT zones.name AS name, COUNT(*) AS count "
                + "FROM arrival JOIN zones ON arrival.idZone = zones.idZone GROUP BY arrival.idZone");
        result = statement.executeQuery();
        Zone zone;
        while (result.next()) {
            zone = new Zone();
            zone.setName(result.getString("name"));
            zone.setCount(result.getInt("count"));
            listZones.add(zone);
        }
        temp.setList4(listZones);
    }

    private void showPositions() throws SQLException {
        List<Worker> listPositions = new ArrayList<>();
        statement = con.prepareStatement("SELECT positions.name AS name, COUNT(*) as count "
                + "FROM worker JOIN positions ON worker.idPosition = positions.idPosition GROUP BY worker.idPosition");
        result = statement.executeQuery();
        Worker worker;
        while (result.next()) {
            worker = new Worker();
            worker.setPosition(result.getString("name"));
            worker.setCount(result.getInt("count"));
            listPositions.add(worker);
        }
        temp.setList5(listPositions);
    }

    private void showWorkers() throws SQLException {
        List<Worker> listWorkers = new ArrayList<>();
        statement = con.prepareStatement("SELECT arrival.dateOfArrival AS date, worker.lastName AS firstname, COUNT(*) AS count "
                + "FROM arrival JOIN worker ON arrival.idWorker = worker.idWorker GROUP BY worker.idWorker,arrival.dateOfArrival");
        result = statement.executeQuery();
        Worker worker;
        while (result.next()) {
            worker = new Worker();
            worker.setDate(result.getString("date"));
            worker.setFirstname(result.getString("firstname"));
            worker.setCount(result.getInt("count"));
            listWorkers.add(worker);
        }
        statement = con.prepareStatement("SELECT expense.dateOfExpense AS date, worker.lastName AS firstname, COUNT(*) AS count "
                + "FROM expense JOIN worker ON expense.idSorter = worker.idWorker GROUP BY expense.idSorter,expense.dateOfExpense");
        result = statement.executeQuery();
        while (result.next()) {
            worker = new Worker();
            worker.setDate(result.getString("date"));
            worker.setFirstname(result.getString("firstname"));
            worker.setCount(result.getInt("count"));
            listWorkers.add(worker);
        }
        statement = con.prepareStatement("SELECT expense.dateOfExpense AS date, worker.lastName AS firstname, COUNT(*) AS count "
                + "FROM expense JOIN worker ON expense.idStockman = worker.idWorker GROUP BY expense.idStockman,expense.dateOfExpense");
        result = statement.executeQuery();
        while (result.next()) {
            worker = new Worker();
            worker.setDate(result.getString("date"));
            worker.setFirstname(result.getString("firstname"));
            worker.setCount(result.getInt("count"));
            listWorkers.add(worker);
        }
        int size = listWorkers.size();
        for (int m = 0; m < size; m++) {
            for (int n = m + 1; n < size; n++) {
                if (listWorkers.get(m).getDate().equals(listWorkers.get(n).getDate()) && listWorkers.get(m).getFirstname().equals(listWorkers.get(n).getFirstname())) {
                    listWorkers.get(m).setCount(listWorkers.get(m).getCount() + listWorkers.get(n).getCount());
                    listWorkers.remove(listWorkers.get(n));
                    size--;
                }
            }
        }
        temp.setList6(listWorkers);
    }

    public Templates getStats() throws SQLException {
        showProducts();
        showArea();
        showCountries();
        showZones();
        showPositions();
        showWorkers();
        return temp;
    }
}
