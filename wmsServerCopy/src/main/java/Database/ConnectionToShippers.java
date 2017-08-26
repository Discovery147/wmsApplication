package Database;

import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToShippers extends Сommunication {

    public ConnectionToShippers() throws ClassNotFoundException, SQLException {
        super();
    }

    public ConnectionToShippers(String base) throws ClassNotFoundException, SQLException {
        super(base);
    }

    public String[][] getAllShippers() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT * FROM shippers");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masShippers = new String[size][2];
        int i = 0;
        while (result.next()) {
            masShippers[i][0] = result.getString("idShipper");
            masShippers[i][1] = result.getString("Organization");
            i++;
        }
        return masShippers;
    }

    public java.lang.String[][] getAllInfoShippers() throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");

        statement = con.prepareStatement("SELECT country.name, shippers.organization, shippers.address FROM shipperscountry JOIN country ON shipperscountry.idCountry = country.idCountry JOIN shippers ON shipperscountry.idShipper = shippers.idShipper");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masShippers = new String[size][3];
        int i = 0;
        System.out.println("AA");
        while (result.next()) {
            System.out.println("BB");
            masShippers[i][0] = result.getString("country.name");
            masShippers[i][1] = result.getString("shippers.organization");
            masShippers[i][2] = result.getString("shippers.address");
            i++;
        }
        return masShippers;
    }

    public void replaceAllShippers(java.lang.String s) throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuerySQL: REPLACE SHIPPERS");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("DELETE FROM shippers");

        JSONArray shippers = new JSONArray(s);
        for (int i = 0; i < shippers.length(); i++) {
            JSONObject shipper = shippers.getJSONObject(i);
            stmt.executeUpdate("INSERT INTO shippers (`idShipper`, `Organization`, `Address`, `Email`, `PhoneOfResponsible`) "
                    + "VALUES ('" + shipper.getString("Id") + "', '" + shipper.getString("Or") + "', '" + shipper.getString("Ad") + "', '" + shipper.getString("Em") + "', '" + shipper.getString("Ph") + "');");

        }
    }

    public String[][] shippersAndCountries() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT idShipper, organization FROM shippers");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masShippers = new String[size][2];
        int i = 0;
        while (result.next()) {
            masShippers[i][0] = result.getString("idShipper");
            masShippers[i][1] = result.getString("organization");
            i++;
        }
        return masShippers;
    }

    public String[][] shippersAndCountriesTwo() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT idCountry, name FROM country");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masShippers = new String[size][2];
        int i = 0;
        while (result.next()) {
            masShippers[i][0] = result.getString("idCountry");
            masShippers[i][1] = result.getString("name");
            i++;
        }
        return masShippers;
    }

    public void postShippersCountries(String s) throws SQLException {
        System.out.println("Выполняю запрос к DB doQuerySQL: ADD ShippersCountries");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("INSERT INTO shipperscountry (`idShipper`, `idCountry`) "
                + "VALUES ('" + s.split("\\.")[0] + "', '" + s.split("\\.")[1] + "');");
    }
}
