package Database;

import static Database.HibernateUtil.getSessionFactory;
import EntityStats.*;
import Service.Area;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONException;
import org.json.JSONObject;

public class ConnectionToArea extends Сommunication {

    public ConnectionToArea() throws ClassNotFoundException, SQLException {
        super();
    }

    private void setSorterStatusOfArrival(String invoice) throws SQLException {
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("UPDATE arrival SET statusOfSorter='1' WHERE numberOfInvoice = '" + invoice + "'");
    }

    public void addArea(java.lang.String s) throws JSONException, SQLException {
        JSONObject area = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuerySQL: INSERT AREA");
        stmt = (Statement) con.createStatement();
        stmt.executeUpdate("INSERT INTO area (`idProduct`, `Row`, `Place`, `Level`, `countProduct`) "
                + "VALUES ('" + area.getString("Id") + "', '" + area.getString("Row") + "', '" + area.getString("Place") + "', '" + area.getString("Level") + "', '" + area.getString("Count") + "');");
        setSorterStatusOfArrival(area.getString("Invoice"));
    }

    public java.lang.String[][] getArea() throws SQLException {
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT * FROM area");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masArea = new String[size][2];
        int i = 0;
        while (result.next()) {
            masArea[i][0] = result.getString("Row");
            masArea[i][1] = result.getString("Place");
            i++;
        }
        return masArea;
    }

//    public java.lang.String[][] postToReturnHibernate(java.lang.String s) throws JSONException, SQLException {                      //non-active
//        Session session = null;
//        try{
//        JSONObject object = new JSONObject(s);
//        List<Area> list = null;
//        try {
//            session = getSessionFactory().openSession();
//            list = session.createQuery("FROM area WHERE idProduct='" + object.getString("idProduct") + "'").list();
//            session.getTransaction().commit();
//        } catch (Exception obj){
//            session.close();
//            HibernateUtil.getSessionFactory().close();
//        }
//        String[][] masArea = new String[list.size()][4];
//        int i = 0, sum = 0;
//        int idTable = 0;
//        for (int j = 0; j < list.size(); j++) {
//            sum += list.get(j).getCount();
//            if (sum >= Integer.parseInt(object.getString("countProduct"))) {
//                idTable = list.get(j).getIdTable();
//                break;
//            }
//        }
//        if (idTable != 0) {
//            sum = 0;
//            int countEnd = 0;
//            for (int j = 0; j < list.size(); j++) {
//                if (idTable == list.get(j).getIdTable()) {
//                    countEnd = Integer.parseInt(object.getString("countProduct")) - sum;
//                    masArea[i][0] = String.valueOf(list.get(j).getRow());
//                    masArea[i][1] = String.valueOf(list.get(j).getPlace());
//                    masArea[i][2] = Integer.toString(countEnd);
//                    masArea[i][3] = String.valueOf(list.get(j).getLevel());
//                    sum += list.get(j).getCount();
//                    break;
//                }
//                sum += list.get(j).getCount();
//                masArea[i][0] = String.valueOf(list.get(j).getRow());
//                masArea[i][1] = String.valueOf(list.get(j).getPlace());
//                masArea[i][2] = String.valueOf(list.get(j).getCount());
//                masArea[i][3] = String.valueOf(list.get(j).getLevel());
//                i++;
//            }
//            session.delete(new Area(idTable, Integer.parseInt(object.getString("idProduct"))));
//            if (sum == Integer.parseInt(object.getString("countProduct"))) {
//                session.delete(new Area(idTable));
//            } else {
//                session.update(new Area(idTable,countEnd));
//            }
//            return masArea;
//        } else {
//            return new String[0][0];
//        }
//        }
//        finally{
//            session.getTransaction().commit();
//            session.close();
//            HibernateUtil.getSessionFactory().close();
//        }
//    }

    public java.lang.String[][] postToReturn(java.lang.String s) throws JSONException, SQLException {
        JSONObject object = new JSONObject(s);
        System.out.println("Выполняю запрос к DB doQuery:\n ");
        statement = con.prepareStatement("SELECT * FROM area WHERE idProduct='" + object.getString("idProduct") + "'");
        result = statement.executeQuery();
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        String[][] masArea = new String[size][4];
        int i = 0, sum = 0;
        int idTable = 0;
        while (result.next()) {
            sum += result.getInt("countProduct");
            if (sum >= Integer.parseInt(object.getString("countProduct"))) {
                idTable = result.getInt("idTable");
                break;
            }
        }
        if (idTable != 0) {
            sum = 0;
            int countEnd = 0;
            result.beforeFirst();
            while (result.next()) {
                if (idTable == result.getInt("idTable")) {
                    countEnd = Integer.parseInt(object.getString("countProduct")) - sum;
                    masArea[i][0] = result.getString("Row");
                    masArea[i][1] = result.getString("Place");
                    masArea[i][2] = Integer.toString(countEnd);
                    masArea[i][3] = result.getString("Level");
                    sum += result.getInt("countProduct");
                    break;
                }
                sum += result.getInt("countProduct");
                masArea[i][0] = result.getString("Row");
                masArea[i][1] = result.getString("Place");
                masArea[i][2] = result.getString("countProduct");
                masArea[i][3] = result.getString("Level");
                i++;
            }
            stmt = (Statement) con.createStatement();
            stmt.executeUpdate("DELETE FROM area WHERE idTable<'" + idTable + "' AND idProduct='" + Integer.parseInt(object.getString("idProduct")) + "'");
            if (sum == Integer.parseInt(object.getString("countProduct"))) {
                stmt.executeUpdate("DELETE FROM area WHERE idTable= '" + idTable + "'");
            } else {
                stmt.executeUpdate("UPDATE area SET countProduct=countProduct-'" + countEnd + "' WHERE idTable= '" + idTable + "'");
            }

            System.out.println("Выполняю запрос к DB doQuerySQL: INSERT Sorter-Return");
            stmt = (Statement) con.createStatement();
            String extense = "Выгрузка";
            stmt.executeUpdate("INSERT INTO sorter_operations (`idWorker`, `typeOfOperation`, `dateOfOperation`, `idProduct`, `countOfProduct`, `position`) "
                    + "VALUES ('" + object.getString("idWorker") + "', '" + extense + "', '" + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "', '" + object.getString("idProduct") + "', '" + object.getString("countProduct") + "', '" + object.getString("placeOfExtense") + "');");
            return masArea;
        } else {
            return new String[0][0];
        }
    }
}
