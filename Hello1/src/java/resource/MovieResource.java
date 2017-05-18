/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Movie;
import service.MovieService;

/**
 * REST Web Service
 *
 * @author ngghe
 */
@Path("movies")
public class MovieResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MovieResource
     */
    MovieService movieService=new MovieService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
       // @Produces(MediaType.APPLICATION_JSON) 
	public List<Movie> getMovie() throws SQLException
	{
	
		return movieService.getAllMovies(); 
	}
        @Path("{name}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public Movie getMoviebyname(@PathParam("name")String name) throws SQLException
	{
	
		return movieService.getMovie(name); 
	}
        @Path("/cinema/{cin_id}")
        @GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Movie> getMoviebyCinema(@PathParam("cin_id")int cin_id) throws SQLException
	{
	
		return movieService.getMoviebyCin(cin_id); 
	}
  
        @POST
        @Produces(MediaType.APPLICATION_XML)
        @Consumes(MediaType.APPLICATION_XML)
        public String addMovie(Movie m)
        {
            
            return movieService.insertMovie(m); 
        }
        @PUT
        @Produces(MediaType.APPLICATION_XML)
        @Consumes(MediaType.APPLICATION_XML)
        public Movie updateMovie(Movie m)
        {
            return movieService.updMovie(m) ;
        }
        @DELETE
        @Path("/{name}")
       // @Produces(MediaType.APPLICATION_XML)
      //  @Consumes(MediaType.TEXT_PLAIN)
        public void deleteMovie(@PathParam("name")String name)
        {
            movieService.delMovie(name) ;
        }
    public MovieResource() {
    
    }

    /**
     * Retrieves representation of an instance of resource.MovieResource
     * @return an instance of java.lang.String
     */
/*    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MovieResource
     * @param content representation for the resource
     */
  /*  @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }*/
}
