/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Cinema;
import model.Movie;
import service.CinemaService;
import service.MovieService;

/**
 * REST Web Service
 *
 * @author ngghe
 */
@Path("cinema")
public class CinemaResource {

    @Context
    private UriInfo context;

   
    /**
     * Creates a new instance of CinemaResource
     */
    
        
    /**
     * Retrieves representation of an instance of resource.CinemaResource
     * @return an instance of java.lang.String
     */
        CinemaService cinemaService=new CinemaService();
        @Path("{id}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public Cinema getCinemabyId(@PathParam("id")String id) throws SQLException
	{
	
		return cinemaService.getCinema(id); 
	}
        @Path("/city/{city}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Cinema> getCinemabycity(@PathParam("city")String city) throws SQLException
	{
	
		return cinemaService.getCinemabyCity(city); 
	}
        @POST
        @Produces(MediaType.APPLICATION_XML)
        @Consumes(MediaType.APPLICATION_XML)
        public String addCinema(Cinema m)
        {
            
            return cinemaService.insertCinema(m); 
        }
        @PUT
        @Produces(MediaType.APPLICATION_XML)
        @Consumes(MediaType.APPLICATION_XML)
        public Cinema updateCinema(Cinema m)
        {
            return cinemaService.updCinema(m) ;
        }
        @DELETE
        @Path("/{name}")
       // @Produces(MediaType.APPLICATION_XML)
      //  @Consumes(MediaType.TEXT_PLAIN)
        public void deleteCinema(@PathParam("name")String name)
        {
            cinemaService.delCinema(name) ;
        }

/*    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
*/
    /**
     * PUT method for updating or creating an instance of CinemaResource
     * @param content representation for the resource
     */
  /*  @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }*/
}
