package Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToSorter extends Сommunication {

    public ConnectionToSorter() throws ClassNotFoundException, SQLException {
        super();
    }

    public void postOperation(java.lang.String s) throws JSONException, SQLException {
        JSONObject operation = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: INSERT Sorter-Operation");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("INSERT INTO sorter_operations (`idWorker`, `typeOfOperation`, `dateOfOperation`, `idProduct`, `countOfProduct`) "
                + "VALUES ('" + operation.getString("idWorker") + "', '" + operation.getString("typeOfOperation") + "', '" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "', '" + operation.getString("idProduct") + "', '" + operation.getString("countOfProduct") + "');");
    }

    public java.lang.String[][] getProductsToExpense() throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuery: getProductsToExpense\n ");
        String type = "Выгрузка";
        statement = con.prepareStatement("SELECT * FROM sorter_operations WHERE statusForStockman=0 AND typeOfOperation='" + type + "'");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masProducts = new String[size][4];
        int i = 0;
        while (result.next()) {
            masProducts[i][0] = result.getString("idOperation");
            masProducts[i][1] = result.getString("idProduct");
            masProducts[i][2] = result.getString("countOfProduct");
            masProducts[i][3] = result.getString("position");
            i++;
        }
        return masProducts;
    }
}
