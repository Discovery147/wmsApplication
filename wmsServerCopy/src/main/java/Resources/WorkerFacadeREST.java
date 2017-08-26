package Resources;

import Database.ConnectionToWorkers;
import Service.Worker;
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
@Path("service.worker")
public class WorkerFacadeREST extends AbstractFacade<Worker> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    private ConnectionToWorkers communication;

    public WorkerFacadeREST() {
        super(Worker.class);
    }

    @POST
    @Path("/post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response auth(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToWorkers();
        JSONObject obj = new JSONObject(s);
        String[] result = communication.getWorker(obj.getString("login"), obj.getString("password"));
        JSONObject jsonObject = new JSONObject();
        String result2 = "";
        jsonObject.put("id", result[0]);
        jsonObject.put("firstname", result[1]);
        jsonObject.put("lastname", result[2]);
        jsonObject.put("position", result[3]);
        result2 += jsonObject + "";
        return Response.status(200).entity(result2).build();
    }

    @POST
    @Path("/postAllInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postAllProducts(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToWorkers();
        communication.replaceAllWorkers(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Worker entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("/getWorkers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllWorkers() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToWorkers();
        String[][] workers = communication.getAllWorkers();
        JSONArray result = new JSONArray();
        for (int i = 0; i < workers.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Id", workers[i][0]);
            jo.put("Fi", workers[i][1]);
            jo.put("La", workers[i][2]);
            jo.put("Em", workers[i][3]);
            jo.put("Mo", workers[i][4]);
            jo.put("Po", workers[i][5]);
            jo.put("Lo", workers[i][6]);
            jo.put("Pa", workers[i][7]);
            result.put(jo);
        }
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Worker> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
