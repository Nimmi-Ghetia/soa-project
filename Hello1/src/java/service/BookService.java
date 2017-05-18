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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import model.Book;
import model.Cinema;

/**
 *
 * @author ngghe
 */
public class BookService {
    String DB_URL = null;
        String DB_DRIVER = null;
            ServletContext sc=null ;
            javax.naming.Context env=null ;

      public BookService()
      {
          System.out.println("constructor called.........");
    try {
             env = (javax.naming.Context)new InitialContext().lookup("java:comp/env");
           DB_URL= (String)env.lookup("DB_URL");
            DB_DRIVER= (String)env.lookup("DB_DRIVER");
         } catch (NamingException ex) {
             Logger.getLogger(MovieService.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      }
      
      
      public Book getBooking(String id)
      {
          String s="";
    
        Book m=null;
        try {
            
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from book where book_id="+Integer.parseInt(id)+"" ;
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);
                    m=new Book() ;

                    while(rs.next())
                    {
                        m.setBook_id(rs.getInt(1));
                       // m.(rs.getString(3));
                       // m.setCat_id(rs.getInt(4));
                        m.setCin_id(rs.getInt(2));
                        //m.setPrice(rs.getInt(6));
                        //m.setRating(rs.getFloat(2));
                        //m.setRelease_date(rs.getDate(3));
                       // m1.add(m) ;
                       m.setMov_id(rs.getInt(3));
                       m.setNo_of_seats(rs.getInt(4));
                       m.setDate(rs.getDate(5));
                       m.setTotal(rs.getInt(6));
                       
                       //m.setCity(rs.getString(2));
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
		return m;
      }
      
      public String GetSize()
      {
          
          String s="<size>";
          int i=0;
        //Book m=null;
        try {
            
            Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
					String q="select * from book ";
                        Statement st=con.createStatement() ;
                        ResultSet rs=st.executeQuery(q);
                    //m=new Book() ;

                    while(rs.next())
                    {
                       
                        i++;
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
		return s+i+"</size>";
          
          
          
          
          
      }
      
      public String insertBooking(Book b)
      {
          String s="";
            int i=0;
		try {
                    java.text.DateFormat format = new java.text.SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
                    java.util.Date date = b.getDate();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
                    
			Class.forName(DB_DRIVER);
			String connectionUrl = DB_URL;  
					Connection con = DriverManager.getConnection(connectionUrl);
                        String q="insert into book (book_id,cin_id,mov_id,no_of_seats,date,total) values("+b.getBook_id()+","+b.getCin_id()+","+b.getMov_id()+","+b.getNo_of_seats()+",'"+timestamp+"',"+b.getTotal() +")";
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
