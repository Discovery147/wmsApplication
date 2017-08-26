package Connection;

import java.io.IOException;
import java.net.*;

public class ConnectionToRest {
    URL url;
    HttpURLConnection conn;
    
    
    public HttpURLConnection getConnection()
    {
        return conn;
    }
    
    private void getInfoGet() throws MalformedURLException, IOException
    {
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
	conn.setRequestProperty("Content-Type", "application/json");
    }
    private void getInfoPost() throws MalformedURLException, IOException
    {
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/json");
    }
    
    public HttpURLConnection getShippers() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/get");     
        getInfoGet();
        return conn;
    }
    
    public HttpURLConnection getStats() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.area/getStats");     
        getInfoGet();
        return conn;
    }

    public HttpURLConnection getProducts() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.products/get");
        getInfoGet();
        return conn;
    }
    
     public HttpURLConnection getArea() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.area/get");
        getInfoGet();
        return conn;
    }
    
    public HttpURLConnection postArrival() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.arrival/post");
        getInfoPost();
        return conn;
    }
    public HttpURLConnection cancelArrival() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.arrival/cancel");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection finishArrival() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.arrival/finish");
        getInfoPost();
        return conn;
    }    

    public HttpURLConnection getProductsToSorter() throws MalformedURLException, IOException
    {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.arrival/getProductsToSorter");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection getAllProducts() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.products/getAll");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection postArea() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.area/post");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection postSorterOperation() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.sorteroperations/post");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection postOperationToReturn() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.area/postToReturn");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection getProductsToExpense() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.sorteroperations/getProductsToExpense");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection getDestinations() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.destination/getDestinations");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection postExpense() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.expense/post");
        getInfoPost();
        return conn;
    }

    // Engineer:
    
    public HttpURLConnection getAllInfoShippers() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/getAllInfo");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection getAllInfoWorkers() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.worker/getWorkers");
        getInfoGet();
        return conn;
    }

       // Engineer:
    
    public HttpURLConnection postAllInfoProducts() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.products/postAllInfo");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection postAllInfoShippers() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/postAllInfo");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection postAllInfoDestination() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.destination/postAllInfo");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection postAllInfoWorkers() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.worker/postAllInfo");
        getInfoPost();
        return conn;
    }
    
    public HttpURLConnection postShippersCountries() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/postShippersCountries");
        getInfoPost();
        return conn;
    }

    public HttpURLConnection getShippersAndCountries() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/getShippersAndCountries");
        getInfoGet();
        return conn;
    }

    public HttpURLConnection getShippersAndCountriesTwo() throws MalformedURLException, IOException {
        url = new URL("http://localhost:8080/wmsServerCopy/webresources/service.shippers/getShippersAndCountriesTwo");
        getInfoGet();
        return conn;
    }
}
