package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Сommunication implements Runnable {

    protected String URL = "jdbc:mysql://localhost:3306/wmsBase";
    protected final String USERNAME = "root";
    protected final String PASSWORD = "8774460";
    protected Connection con;
    protected PreparedStatement statement;
    protected ResultSet result;
    protected Statement stmt;

    protected Сommunication() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    protected Сommunication(String base) throws ClassNotFoundException, SQLException {
        URL = "jdbc:mysql://localhost:3306/" + base;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
