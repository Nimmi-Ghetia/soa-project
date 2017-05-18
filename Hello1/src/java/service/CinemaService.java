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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import model.Cinema;
import model.Movie;

/**
 *
 * @author ngghe
 */
public class CinemaService {
      String DB_URL = null;
        String DB_DRIVER = null;
            ServletContext sc=null ;
            javax.naming.Context env=null ;
            //Context DB_URL=null ; 
public CinemaService(){
    System.out.println("constructor called.........");
    try {
             env = (javax.naming.Context)new InitialContext().lookup("java:comp/env");
           DB_URL= (String)env.lookup("DB_URL");
            DB_DRIVER= (String)env.lookup("DB_DRIVER");
         } catch (NamingException ex) {
             Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
         }
          //System.out.println("value of url and driver is "+DB_URL+"  "+DB_DRIVER);
}
        public Cinema getCinema(String id) {
        //List<Movie m1=new ArrayList() ;		
String s="";
    
        Cinema 	m=null;
        try {
            
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from cinema where cin_id="+Integer.parseInt(id)+"" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);
                    m=new Cinema() ;

                    while(rs.next())
                    {
                        
                        m.setName(rs.getString(3));
                       // m.setCat_id(rs.getInt(4));
                        m.setCin_id(rs.getInt(1));
                        //m.setPrice(rs.getInt(6));
                        //m.setRating(rs.getFloat(2));
                        //m.setRelease_date(rs.getDate(3));
                       // m1.add(m) ;
                       m.setCity(rs.getString(2));
                        s+=rs.getString(3);
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

        public List<Cinema> getCinemabyCity(String city) {
        //List<Movie m1=new ArrayList() ;		
String s="";
    List<Cinema> cin=new ArrayList() ;
        
        try {
            
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from cinema where city='"+city+"'" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);
                        

                    while(rs.next())
                    {
                                 Cinema   m=new Cinema() ;
                        m.setName(rs.getString(3));
                       // m.setCat_id(rs.getInt(4));
                        m.setCin_id(rs.getInt(1));
                        //m.setPrice(rs.getInt(6));
                        //m.setRating(rs.getFloat(2));
                        //m.setRelease_date(rs.getDate(3));
                       // m1.add(m) ;
                       m.setCity(rs.getString(2));
                       cin.add(m);
                        s+=rs.getString(3);
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
		return cin; //To change body of generated methods, choose Tools | Templates.
    }

        public void delCinema(String name) {
         //String s="<fe> ";
        try
        {
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
			Connection con = DriverManager.getConnection(connectionUrl);
            String q="delete from cinema where name='"+name+"'";
                    //Int32.Parse(id) ;
           Statement st=con.createStatement() ;
           int i=st.executeUpdate(q) ;
           // s+=i ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
        }
	        
           //       return s+"</fe>" ;                      
    
    }

    public Cinema updCinema(Cinema m) {
         Cinema nc=null;    
            String s="";
            int i=0;
		try {
                   
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
                    
                           int id=m.getCin_id() ;
                        String q1="update cinema set name='"+m.getName()+"',city='"
                                +m.getCity()+"' where cin_id="+id;
                             
                        
                        Statement st=con.createStatement() ;
                            i=st.executeUpdate(q1);
                    nc=getCinema(id+"");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s+=e.getMessage();
		}catch (SQLException e)
		{
			e.printStackTrace();
			s+=e.getMessage();
		} 
                return nc;
            
     }

    public String insertCinema(Cinema m) {
         String s="";
            int i=0;
		try {
                    
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
                        String q="insert into cinema (cin_id,name,city) values("+m.getCin_id()+
                             ",'"+m.getName()+"','"+m.getCity()+"')" ;
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

    
}
