package Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToExpense extends Сommunication {

    public ConnectionToExpense() throws ClassNotFoundException, SQLException {
        super();
    }

    public void postExpense(java.lang.String s) throws JSONException, SQLException {
        JSONObject expense = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: INSERT EXPENSE");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("INSERT INTO expense (`dateOfExpense`, `numberOfInvoice`, `idShipper`, `idProduct`, `idOfDestination`, `countProduct`, `idWorker`) "
                + "VALUES ('" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "', '" + expense.getString("numberOfInvoice") + "', '" + expense.getString("idShipper") + "', '" + expense.getString("idProduct") + "', '" + expense.getString("idOfDestination") + "', '" + expense.getString("countProduct") + "', '" + expense.getString("idWorker") + "');");

        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("UPDATE sorter_operations SET statusForStockman='1' WHERE idOperation = '" + expense.getString("idOperation") + "'");
    }
}
