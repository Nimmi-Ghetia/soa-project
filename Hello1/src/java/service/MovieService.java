/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import model.Movie;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author ngghe
 */
public class MovieService {

     String DB_URL = null;
        String DB_DRIVER = null;
            ServletContext sc=null ;
            Context env=null ;
          
public MovieService(){
   
    try {
             env = (Context)new InitialContext().lookup("java:comp/env");
           DB_URL= (String)env.lookup("DB_URL");
            DB_DRIVER= (String)env.lookup("DB_DRIVER");
         } catch (NamingException ex) {
             Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
    String s="ajs";
	public List<Movie> getAllMovies() throws SQLException
	{
            System.out.println("value of url and driver is "+DB_URL+"  "+DB_DRIVER);
            List<Movie> m1=new ArrayList() ;		
		try {
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from movie" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);


                    while(rs.next())
                    {
                    Movie m=new Movie() ;    
                        m.setName(rs.getString(1));
                        m.setCat_id(rs.getInt(4));
                        m.setMov_id(rs.getInt(5));
                        m.setPrice(rs.getInt(6));
                        m.setRating(rs.getFloat(2));
                        m.setRelease_date(rs.getDate(3));
                        m.setCin_id(rs.getInt(7));
                        m1.add(m) ;
                        s+=rs.getString(1);
                    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		}
		return m1;
	}

        public String insertMovie(Movie m) 
        {
//List<Movie> m1=new ArrayList() ;	
            String s="";
            int i=0;
		try {
                    java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
                    java.util.Date date = m.getRelease_date();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
              //      DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    //Date startDate;
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
                        String q="insert into movie (mov_id,cat_id,price,rating,release_date,name,cin_id) values("+m.getMov_id()+","+
                               m.getCat_id()+","+m.getPrice()+","+m.getRating()+",'"+timestamp+"','"+m.getName()+"',"+m.getCin_id()+")" ;
                        s+=timestamp;
                        Statement st=con.createStatement() ;
                            i=st.executeUpdate(q);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		} 
                return s+i+"hello";
            
        }
        public Movie updMovie(Movie m) 
        {
//List<Movie> m1=new ArrayList() ;	
            Movie m1=new Movie() ;
            String s="";
            int i=0;
		try {
                    java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
                    java.util.Date date = m.getRelease_date();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
              //      DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
    //Date startDate;
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
                    
                                        
                        String q1="update movie set cat_id="+ m.getCat_id()+",price="+m.getPrice()+",rating="
                                +m.getRating()+",name='"+m.getName()+"' where mov_id="+m.getMov_id();
                             
                        s+=timestamp;
                        Statement st=con.createStatement() ;
                            i=st.executeUpdate(q1);

                            String q="select * from movie where mov_id="+m.getMov_id() ;
                        Statement st1=con.createStatement() ;
                        ResultSet rs=st1.executeQuery(q);


                    while(rs.next())
                    {
                        
                        m1.setName(rs.getString(1));
                        m1.setCat_id(rs.getInt(4));
                        m1.setMov_id(rs.getInt(5));
                        m1.setPrice(rs.getInt(6));
                        m1.setRating(rs.getFloat(2));
                        m1.setRelease_date(rs.getDate(3));
                        m1.setCin_id(rs.getInt(7));
                        //m1.add(m) ;
                        s+=rs.getString(1);
                    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		} 
                return m1;
            
        }
        
        public void delMovie(String name)
        {
            //String s="<fe> ";
        try
        {
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
			Connection con = DriverManager.getConnection(connectionUrl);
            String q="delete from movie where name='"+name+"'";
                    //Int32.Parse(id) ;
           Statement st=con.createStatement() ;
           int i=st.executeUpdate(q) ;
            s+=i ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
        }
	        
           //       return s+"</fe>" ;                      
            
        }

    public Movie getMovie(String name) {
        //List<Movie m1=new ArrayList() ;		
	Movie 	m=null;
        try {
	Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
							Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from movie where name='"+name+"'" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);
                    m=new Movie() ;

                    while(rs.next())
                    {
                        
                        m.setName(rs.getString(1));
                        m.setCat_id(rs.getInt(4));
                        m.setMov_id(rs.getInt(5));
                        m.setPrice(rs.getInt(6));
                        m.setRating(rs.getFloat(2));
                        m.setRelease_date(rs.getDate(3));
                        m.setCin_id(rs.getInt(7));
                       // m1.add(m) ;
                        s+=rs.getString(1);
                    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		}
		return m; //To change body of generated methods, choose Tools | Templates.
    }
    public List<Movie> getMoviebyCin(int cin_id) {
        List<Movie> m1=new ArrayList() ;		
	
        try {
	Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
							Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from movie where cin_id="+cin_id+"" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);

                    while(rs.next())
                    {
        Movie 	m =new Movie() ;
                        
                        m.setName(rs.getString(1));
                        m.setCat_id(rs.getInt(4));
                        m.setMov_id(rs.getInt(5));
                        m.setPrice(rs.getInt(6));
                        m.setRating(rs.getFloat(2));
                        m.setRelease_date(rs.getDate(3));
                        m.setCin_id(rs.getInt(7));
                        m1.add(m) ;
                        s+=rs.getString(1);
                    }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		}
		return m1; //To change body of generated methods, choose Tools | Templates.
    }
}

