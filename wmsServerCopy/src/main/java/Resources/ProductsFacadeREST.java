package Resources;

import Database.ConnectionToProducts;
import Database.HibernateUtil;
import EntityStats.Country;
import Service.Products;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.Session;
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
@Path("service.products")
public class ProductsFacadeREST extends AbstractFacade<Products> {

    @PersistenceContext(unitName = "wmsServerCopyPU")
    private EntityManager em;
    private ConnectionToProducts communication;

    public ProductsFacadeREST() {
        super(Products.class);
    }

    @POST
    @Path("/postAllInfo")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void postAllProducts(String s) throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToProducts();
        communication.replaceAllProducts(s);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Products entity) {
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
    public Response getProducts() throws ClassNotFoundException, SQLException, JSONException {
        communication = new ConnectionToProducts();
        String[][] products = communication.getProducts();
        System.out.println("123");
        JSONArray result = new JSONArray();
        for (int i = 0; i < products.length; i++) {
            JSONObject jo = new JSONObject();
            jo.put("idProduct", products[i][0]);
            jo.put("Name", products[i][1]);
            jo.put("Measure", products[i][2]);
            result.put(jo);

            System.out.println("123");
        }
        //array to json
        System.out.println("123");

        System.out.println(result);
        return Response.status(200).entity(result.toString()).build();
    }

    @GET
    @Path("/getAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAllProducts() throws ClassNotFoundException, SQLException, JSONException {
        
        //getCountriesHibernate();
        return Response.status(200).entity(new ConnectionToProducts().getAllProducts().toString()).build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Products> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    private void getCountriesHibernate() {
        /*List<Country> countries;
        
        org.hibernate.Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        countries = session.createQuery("FROM Country").list();
        for(Country obj: countries)
            System.out.println(obj.getName());*/
    }

}
