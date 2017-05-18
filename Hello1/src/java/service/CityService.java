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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import model.City;
import model.Movie;

/**
 *
 * @author ngghe
 */
public class CityService {
       String DB_URL = null;
        String DB_DRIVER = null;
            ServletContext sc=null ;
            Context env=null ;
          
public CityService(){
   
    try {
             env = (Context)new InitialContext().lookup("java:comp/env");
           DB_URL= (String)env.lookup("DB_URL");
            DB_DRIVER= (String)env.lookup("DB_DRIVER");
         } catch (NamingException ex) {
             Logger.getLogger(CityService.class.getName()).log(Level.SEVERE, null, ex);
         }
   }
String s="";
    public List<City> GetCities()
    {
        
           List<City> m1=new  ArrayList();		
		try {
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select distinct city from cinema" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);

                            int i=0;
                    while(rs.next())
                    {
                        City c=new City();
                    String c1=rs.getString("city");
                    c.setCity(c1);
                    i++;
                    c.setId(i);
                       System.out.println(c.getCity()+"  "+c.getId());
                       m1.add(c); 
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
}
