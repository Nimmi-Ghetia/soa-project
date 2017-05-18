/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Book;
import model.Cinema;
import service.BookService;
import service.CinemaService;

/**
 * REST Web Service
 *
 * @author ngghe
 */
@Path("book")
public class BookResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookResource
     */
    public BookResource() {
    }
    BookService bookService=new BookService();
    /**
     * Retrieves representation of an instance of resource.BookResource
     * @return an instance of java.lang.String
     */
    @POST
        @Produces(MediaType.APPLICATION_XML)
        @Consumes(MediaType.APPLICATION_XML)
        public String addBooking(Book b)
        {
            
            return bookService.insertBooking(b); 
        }
   
        @Path("{id}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public Book getBookingbyId(@PathParam("id")String id) throws SQLException
	{
	
		return bookService.getBooking(id); 
	}
        
        
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public String getSize() throws SQLException
	{
	
		return bookService.GetSize(); 
	}
        
        
}
