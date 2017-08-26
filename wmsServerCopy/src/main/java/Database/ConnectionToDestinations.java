package Database;

import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToDestinations extends Сommunication {

    public ConnectionToDestinations() throws ClassNotFoundException, SQLException {
        super();
    }

    public void replaceAllDestinations(java.lang.String s) throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuerySQL: REPLACE DESTINATIONS");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("DELETE FROM destination");

        JSONArray destinations = new JSONArray(s);
        for (int i = 0; i < destinations.length(); i++) {
            JSONObject destination = destinations.getJSONObject(i);
            stmt.executeUpdate("INSERT INTO destination (`idOfDestination`, `Organization`, `Address`, `ContactPhone`) "
                    + "VALUES ('" + destination.getString("Id") + "', '" + destination.getString("Or") + "', '" + destination.getString("Ad") + "', '" + destination.getString("Co") + "');");

        }
    }

    public java.lang.String[][] getDestinations() throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuery: getDestinations\n ");
        statement = con.prepareStatement("SELECT * FROM destination");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] destinations = new String[size][4];
        int i = 0;
        while (result.next()) {
            destinations[i][0] = result.getString("idOfDestination");
            destinations[i][1] = result.getString("Organization");
            destinations[i][2] = result.getString("Address");
            destinations[i][3] = result.getString("ContactPhone");
            i++;
        }
        return destinations;
    }
}
