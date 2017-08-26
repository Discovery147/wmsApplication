package Resources;

import Database.ConnectionToDestinations;
import Service.Destination;
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
@Path("service.destination")
public class DestinationFacadeREST extends AbstractFacade<Destination> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    ConnectionToDestinations communication;

    public DestinationFacadeREST() {
        super(Destination.class);
    }

    @POST
    @Path("/postAllInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postAllProducts(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToDestinations();
        communication.replaceAllDestinations(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Destination entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/getDestinations")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllShippers() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToDestinations();
        String[][] destinations = communication.getDestinations();
        JSONArray result = new JSONArray();
        for (int i = 0; i < destinations.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("idOfDestination", destinations[i][0]);
            jo.put("Organization", destinations[i][1]);
            jo.put("Address", destinations[i][2]);
            jo.put("ContactPhone", destinations[i][3]);
            result.put(jo);
        }
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Destination> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Destination> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
