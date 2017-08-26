package Resources;

import Database.ConnectionToSorter;
import Service.SorterOperations;
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
@Path("service.sorteroperations")
public class SorterOperationsFacadeREST extends AbstractFacade<SorterOperations> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    private ConnectionToSorter communication;

    public SorterOperationsFacadeREST() {
        super(SorterOperations.class);
    }

    @POST
    @Path("/post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postOperation(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToSorter();
        communication.postOperation(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, SorterOperations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/getProductsToExpense")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getProductsToExpense() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToSorter();
        String[][] products = communication.getProductsToExpense();
        JSONArray result = new JSONArray();
        for (int i = 0; i < products.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("idOperation", products[i][0]);
            jo.put("idProduct", products[i][1]);
            jo.put("countOfProduct", products[i][2]);
            jo.put("position", products[i][3]);
            result.put(jo);
        }
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SorterOperations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<SorterOperations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
