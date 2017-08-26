package Resources;

import Database.ConnectionForStats;
import Database.ConnectionToArea;
import EntityStats.Templates;
import Service.Area;
import com.google.gson.Gson;
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
@Path("service.area")
public class AreaFacadeREST extends AbstractFacade<Area> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    ConnectionToArea communication;

    public AreaFacadeREST() {
        super(Area.class);
    }

    @POST
    @Path("/post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addArea(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArea();
        communication.addArea(s);
    }

    @POST
    @Path("/postToReturn")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response postToReturn(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArea();
        String[][] areas = communication.postToReturn(s);
        JSONArray result = new JSONArray();
        for (int i = 0; i < areas.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Row", areas[i][0]);
            jo.put("Place", areas[i][1]);
            jo.put("CountProduct", areas[i][2]);
            jo.put("Level", areas[i][3]);
            result.put(jo);
        }
        System.out.println("ИТОГОВЫЙ МАССИВ SORTER-RETURN:\n\n" + result);
        return Response.status(200).entity(result.toString()).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Area entity) {
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
    public Response getArea() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToArea();
        String[][] area = communication.getArea();
        JSONArray result = new JSONArray();
        for (int i = 0; i < area.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("Row", area[i][0]);
            jo.put("Place", area[i][1]);
            result.put(jo);
        }
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("/getStats")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getStats() throws ClassNotFoundException, SQLException, JSONException {
        System.out.println("YEES: STATS");
        Templates temp = new ConnectionForStats("testwmsbase").getStats();
        String json = new Gson().toJson(temp);
        //Templates temp2 = new Gson().fromJson(json, Templates.class);
        return Response.status(200).entity(json).build();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Area> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Area> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
