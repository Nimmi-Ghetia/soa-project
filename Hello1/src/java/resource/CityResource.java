/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.City;
import model.Movie;
import service.BookService;
import service.CityService;

/**
 * REST Web Service
 *
 * @author ngghe
 */
@Path("city")
public class CityResource {
        BookService bookService=new BookService();

        @Path("/book")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public String getSize() throws SQLException
	{
	
		return bookService.GetSize(); 
	}
        

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CityResource
     */
    CityService cityService=new CityService();
    public CityResource() {
      
    }
        @GET
	//@Produces({"text/html","application/xml"})
        @Produces(MediaType.APPLICATION_XML) 
	public List<City> getCities() throws SQLException
	{
	
		return cityService.GetCities(); 
	}

    /**
     * Retrieves representation of an instance of resource.CityResource
     * @return an instance of java.lang.String
     */
  
}
