package Resources;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Resources.AreaFacadeREST.class);
        resources.add(Resources.ArrivalFacadeREST.class);
        resources.add(Resources.DestinationFacadeREST.class);
        resources.add(Resources.ExpenseFacadeREST.class);
        resources.add(Resources.ProductsFacadeREST.class);
        resources.add(Resources.ShippersFacadeREST.class);
        resources.add(Resources.SorterOperationsFacadeREST.class);
        resources.add(Resources.WorkerFacadeREST.class);
    }

}
