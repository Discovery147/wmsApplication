package Resources;

import Database.ConnectionToShippers;
import Service.Shippers;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Stateless
@Path("service.shippers")
public class ShippersFacadeREST extends AbstractFacade<Shippers> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    private ConnectionToShippers communication;

    public ShippersFacadeREST() {
        super(Shippers.class);
    }

    @POST
    @Path("/postAllInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postAllProducts(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers();
        communication.replaceAllShippers(s);
    }

    @POST
    @Path("/postShippersCountries")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postShippersCountries(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers("testwmsbase");
        communication.postShippersCountries(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Shippers entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllShippers() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers();
        String[][] shippers = communication.getAllShippers();
        System.out.println("123");
        JSONArray result = new JSONArray();
        for (int i = 0; i < shippers.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("id", shippers[i][0]);
            jo.put("organization", shippers[i][1]);
            result.put(jo);
            System.out.println("123");
        }
        //array to json
        System.out.println("YEEEEEEEES");

        System.out.println(result);
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("/getShippersAndCountries")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getShippersAndCountries() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers("testwmsbase");
        String[][] shippersAndCountries = communication.shippersAndCountries();
        JSONArray result = new JSONArray();
        for (int i = 0; i < shippersAndCountries.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("id", shippersAndCountries[i][0]);
            jo.put("name", shippersAndCountries[i][1]);
            result.put(jo);
        }

        System.out.println(result);
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("/getShippersAndCountriesTwo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getShippersAndCountriesTwo() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers("testwmsbase");
        String[][] shippersAndCountries = communication.shippersAndCountriesTwo();
        JSONArray result = new JSONArray();
        for (int i = 0; i < shippersAndCountries.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("id", shippersAndCountries[i][0]);
            jo.put("name", shippersAndCountries[i][1]);
            result.put(jo);
        }

        System.out.println(result);
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("/getAllInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllInfoShippers() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToShippers("testwmsbase");
        String[][] shippers = communication.getAllInfoShippers();
        JSONArray result = new JSONArray();
        for (int i = 0; i < shippers.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Id", shippers[i][0]);
            jo.put("Or", shippers[i][1]);
            jo.put("Ad", shippers[i][2]);
            result.put(jo);
        }

        System.out.println(result);
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Shippers> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Shippers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
