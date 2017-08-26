package Database;

import EntityStats.Product;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToProducts extends Сommunication {

    public ConnectionToProducts() throws ClassNotFoundException, SQLException {
        super();
    }

    public java.lang.String[][] getProducts() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT * FROM products");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masProducts = new String[size][3];
        int i = 0;
        while (result.next()) {
            masProducts[i][0] = result.getString("idProduct");
            masProducts[i][1] = result.getString("Name");
            masProducts[i][2] = result.getString("Measure");
            i++;
        }
        return masProducts;
    }

    public List getAllProducts() throws SQLException, JSONException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        
        statement = con.prepareStatement("SELECT * FROM products");
        result = statement.executeQuery();
        
        List<Product> products = new ArrayList();
        Product product;
        
        while (result.next()) {
            product = new Product();
            product.setIdproduct(result.getInt("idProduct"));
            product.setName(result.getString("name"));
            product.setType(result.getString("type"));
            product.setMeasure(result.getString("measure"));
            product.setCode(result.getString("code"));
            
            products.add(product);
        }
        return products;
    }

    public void replaceAllProducts(java.lang.String s) throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuerySQL: REPLACE PRODUCTS");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("DELETE FROM products");

        JSONArray products = new JSONArray(s);
        for (int i = 0; i < products.length(); i++) {
            JSONObject product = products.getJSONObject(i);
            stmt.executeUpdate("INSERT INTO products (`idProduct`, `Name`, `Type`, `Measure`, `Code`) "
                    + "VALUES ('" + product.getString("Id") + "', '" + product.getString("Na") + "', '" + product.getString("Ty") + "', '" + product.getString("Me") + "', '" + product.getString("Co") + "');");

        }
    }
}
