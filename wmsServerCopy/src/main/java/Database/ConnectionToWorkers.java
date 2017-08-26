package Database;

import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToWorkers extends Сommunication {

    public ConnectionToWorkers() throws ClassNotFoundException, SQLException {
        super();
    }

    public String[] getWorker(String login, String password) throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery: Auth\n ");
        statement = con.prepareStatement("SELECT * FROM worker");
        result = statement.executeQuery();
        String masUser[] = {"0", "0", "0", "0"};
        while (result.next()) {
            String loginBase = result.getString("Login");
            String passwordBase = result.getString("Password");

            if (loginBase.equals(login) && passwordBase.equals(password)) {
                masUser[0] = result.getString("idWorker");
                masUser[1] = result.getString("firstName");
                masUser[2] = result.getString("lastName");
                if (result.getString("Position").equals("Stockman")) {
                    masUser[3] = "4";
                }
                if (result.getString("Position").equals("Sorter")) {
                    masUser[3] = "3";
                }
                if (result.getString("Position").equals("Engineer")) {
                    masUser[3] = "2";
                }
                if (result.getString("Position").equals("Analyst")) {
                    masUser[3] = "1";
                }
                break;
            }
        }
        con.close();
        return masUser;
    }

    public void replaceAllWorkers(java.lang.String s) throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuerySQL: REPLACE WORKERS");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("DELETE FROM worker");

        JSONArray workers = new JSONArray(s);
        for (int i = 0; i < workers.length(); i++) {
            JSONObject worker = workers.getJSONObject(i);
            stmt.executeUpdate("INSERT INTO worker (`idOfDestination`, `Organization`, `Address`, `ContactPhone`) "
                    + "VALUES ('" + worker.getString("idWorker") + "', '" + worker.getString("firstName") + "', '" + worker.getString("lastName") + "', '" + worker.getString("Email") + "','" + worker.getString("MobilePhone") + "', '" + worker.getString("Position") + "', '" + worker.getString("Login") + "', '" + worker.getString("Password") + "');");

        }
    }

    public java.lang.String[][] getAllWorkers() throws JSONException, SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT * FROM worker");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] workers = new String[size][8];
        int i = 0;
        while (result.next()) {
            workers[i][0] = result.getString("idWorker");
            workers[i][1] = result.getString("firstName");
            workers[i][2] = result.getString("lastName");
            workers[i][3] = result.getString("Email");
            workers[i][4] = result.getString("MobilePhone");
            workers[i][5] = result.getString("Position");
            workers[i][6] = result.getString("Login");
            workers[i][7] = result.getString("Password");
            i++;
        }
        return workers;
    }
}
