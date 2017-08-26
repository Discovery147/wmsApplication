package Reports;

import Connection.ConnectionToRest;
import Entity.Templates;
import com.google.gson.Gson;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.*;
import org.json.*;

import org.json.JSONObject;

public class SimpleReport {

    HashMap<String, Object> hmap;
    Templates temp;

    public SimpleReport() throws ClassNotFoundException, SQLException, JSONException, JRException, IOException, InstantiationException, IllegalAccessException {
        super();
        getStats();
        JasperCompileManager.compileReportToFile("products.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport("products.jasper", hmap, new JREmptyDataSource());
        new JasperViewer(jasperPrint).setVisible(true);
    }

    private void getStats() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, JSONException, SQLException {
        ConnectionToRest connection = new ConnectionToRest();
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (connection.getStats().getInputStream()), StandardCharsets.UTF_8));
        String json = br.readLine();
        temp = new Gson().fromJson(json, Templates.class);
        setHashMap();
        connection.getConnection().disconnect();
        br.close();
    }

    private void setHashMap() throws SQLException, JSONException {
        hmap = new HashMap<>();
        JRDataSource beanCollectionPoducts = new JRBeanCollectionDataSource(temp.getList());
        JRDataSource beanCollectionArea = new JRBeanCollectionDataSource(temp.getList2());
        JRDataSource beanCollectionCountries = new JRBeanCollectionDataSource(temp.getList3());
        JRDataSource beanCollectionZones = new JRBeanCollectionDataSource(temp.getList4());
        JRDataSource beanCollectionPositions = new JRBeanCollectionDataSource(temp.getList5());
        JRDataSource beanCollectionWorkers = new JRBeanCollectionDataSource(temp.getList6());
        hmap.put("products", beanCollectionPoducts);
        hmap.put("countries", beanCollectionCountries);
        hmap.put("workers", beanCollectionWorkers);
        hmap.put("area", beanCollectionArea);
        hmap.put("zones", beanCollectionZones);
        hmap.put("positions", beanCollectionPositions);
    }

}
