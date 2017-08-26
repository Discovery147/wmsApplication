/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToArrival extends Сommunication {

    public ConnectionToArrival() throws ClassNotFoundException, SQLException {
        super();
    }

    public java.lang.String[][] getProductsToSorter() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery: getArrivals\n ");
        statement = con.prepareStatement("SELECT idProduct, countProduct, placeArrival, numberOfInvoice FROM arrival WHERE status=1 AND statusOfSorter=0");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masProducts = new String[size][4];
        int i = 0;
        while (result.next()) {
            masProducts[i][0] = result.getString("idProduct");
            masProducts[i][1] = result.getString("countProduct");
            masProducts[i][2] = result.getString("placeArrival");
            masProducts[i][3] = result.getString("numberOfInvoice");
            i++;
        }

        return masProducts;
    }

    public void addArrival(java.lang.String s) throws JSONException, SQLException {
        JSONObject arrival = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: INSERT ARRIVAL");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("INSERT INTO arrival (`dateOfArrival`, `numberOfInvoice`, `idShipper`, `idProduct`, `countProduct`, `idWorker`, `placeArrival`, `status`) "
                + "VALUES ('" + arrival.getString("dateOfArrival") + "', '" + arrival.getString("wayBill") + "', '" + arrival.getString("idShipper") + "', '" + arrival.getString("idProduct") + "', '" + arrival.getString("countProduct") + "', '" + arrival.getString("idWorker") + "', '" + arrival.getString("areaOfArrival") + "', '0');");
    }

    public void cancelArrival(java.lang.String s) throws JSONException, SQLException {
        JSONObject arrival = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: CANCEL ARRIVAL");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("DELETE FROM arrival WHERE numberOfInvoice = " + arrival.getString("waybill") + "");
    }

    public void finishArrival(java.lang.String s) throws JSONException, SQLException {
        JSONObject arrival = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: FINISH ARRIVAL");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("UPDATE arrival SET status='1' WHERE numberOfInvoice = '" + arrival.getString("waybill") + "'");
    }
}
