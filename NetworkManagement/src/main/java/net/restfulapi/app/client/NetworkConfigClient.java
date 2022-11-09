package net.restfulapi.app.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import net.restfulapi.app.rest.domain.Configurations;

/**
 * Jersey REST client generated for REST resource:ConfigurationResource
 * [/configurations]<br>
 * USAGE:
 * <pre>
 *        NetworkConfigClient client = new NetworkConfigClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author orlando
 */
public class NetworkConfigClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8084///network-management";

    public NetworkConfigClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("configurations");
    }

    public <T> T getConfigurations(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request().get(responseType);
        //return resource.get(responseType);
    }

    public Response createConfiguration(Object requestEntity) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public <T> T getConfigurationById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        //resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().get(responseType);
        //return resource.get(responseType);
    }

    public Response deleteConfiguration(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete(Response.class);
    }

    public Response updateConfiguration(Object requestEntity, String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML), Response.class);
    }

    public void close() {
        client.close();
    }
    
    public static void main(String[] args) {
        NetworkConfigClient client = new NetworkConfigClient();
        client.getConfigurations(Configurations.class);
    }
    // http://localhost:8084/network-management/configurations
    //HTTP POST http://localhost:8084/NetworkManagement/network-management/configurations
    //HTTP PUT http://localhost:8084/NetworkManagement/network-management/configurations/1
    //HTTP DELETE http://localhost:8084/NetworkManagement/network-management/configurations/1
    //HTTP GET http://localhost:8084/NetworkManagement/network-management/configurations/1
    
}
