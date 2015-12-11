package com.gmm.foorest2.JAX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

 


@Path("/saludo")
public class HolaMundo {
    
    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_HTML)
    public String getSaludoHTML(@PathParam("param") String nombre) {
        return "<html> " + "<title>" + "Hola Mundo" + "</title>"  
             + "<body><h1>" + "Hola Mundo en HTML : " + nombre 
             + "</body></h1>" + "</html> ";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludoPlain() {
        return "Hola mundo!"  ;
    }
    
    
    
     
    
     
    public static void main(String[] args) {
    	try {

    		Client client = Client.create();

    		WebResource webResource = client
    		   .resource("http://localhost:8080/RESTfulExample/rest/json/metallica/get");

    		ClientResponse response = webResource.accept("application/json")
                       .get(ClientResponse.class);

    		if (response.getStatus() != 200) {
    		   throw new RuntimeException("Failed : HTTP error code : "
    			+ response.getStatus());
    		}

    		String output = response.getEntity(String.class);

    		System.out.println("Output from Server .... \n");
    		System.out.println(output);

    	  } catch (Exception e) {

    		e.printStackTrace();

    	  }

    	}

     
    
}
