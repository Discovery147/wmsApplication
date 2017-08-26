package Resources;

import Database.ConnectionToArrival;
import Service.Arrival;
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
@Path("service.arrival")
public class ArrivalFacadeREST extends AbstractFacade<Arrival> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    ConnectionToArrival communication;

    public ArrivalFacadeREST() {
        super(Arrival.class);
    }

    @POST
    @Path("/post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addArrival(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArrival();
        System.out.println("ПРИНЯТО-ADD");
        communication.addArrival(s);
    }

    @POST
    @Path("/cancel")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void cancelArrival(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArrival();
        System.out.println("ПРИНЯТО-CANCEL");
        communication.cancelArrival(s);
    }

    @POST
    @Path("/finish")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void finishArrival(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArrival();
        System.out.println("ПРИНЯТО-CANCEL");
        communication.finishArrival(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Arrival entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/getProductsToSorter")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getProductsToSorter() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArrival();
        String[][] products = communication.getProductsToSorter();
        JSONArray result = new JSONArray();
        for (int i = 0; i < products.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("idProduct", products[i][0]);
            jo.put("countProduct", products[i][1]);
            jo.put("placeArrival", products[i][2]);
            jo.put("Invoice", products[i][3]);
            result.put(jo);
        }
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Arrival> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Arrival> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
