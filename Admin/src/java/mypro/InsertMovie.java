/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.RequestDispatcher;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
/**
 *
 * @author ngghe
 */
public class InsertMovie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                       String uri = 
    "http://107.170.65.250:8080/Hello1/webresources/movies";
URL url = new URL(uri);
HttpURLConnection connection = 
    (HttpURLConnection) url.openConnection();
connection.setRequestMethod("POST");
connection.setRequestProperty("Accept", "application/xml");
connection.setRequestProperty("Content-Type", "application/xml");

 connection.setDoOutput(true);
 Movie m=new Movie();
 m.setMov_id(Integer.parseInt(request.getParameter("mov_id")));
 m.setCat_id(Integer.parseInt(request.getParameter("cat_id")));
 m.setName(request.getParameter("name"));
 m.setPrice(Integer.parseInt(request.getParameter("price")));
 m.setRating(Float.parseFloat(request.getParameter("rating")));
 m.setCin_id(Integer.parseInt(request.getParameter("cin_id")));
 java.text.DateFormat form = new java.text.SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssXXX");
 
                    java.util.Date date = new Date();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

 m.setRelease_date(date);
/* JAXBContext jaxbContext = JAXBContext.newInstance(Movie.class);
Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

// output pretty printed
jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//jaxbMarshaller.marshal(customer, file);
jaxbMarshaller.marshal(m, System.out);
StringWriter sw = new StringWriter();
jaxbMarshaller.marshal(m, sw);
String xmlString = sw.toString();
System.out.println(xmlString);
 */String input = "<movie>\n" +
"        <cat_id>"+m.getCat_id()+"</cat_id>\n" +
         "        <cin_id>"+m.getCin_id()+"</cin_id>\n" +
"        <mov_id>"+m.getMov_id()+"</mov_id>\n" +
"        <name>"+m.getName()+"</name>\n" +
"        <price>"+m.getPrice()+"</price>\n" +
"        <rating>"+m.getRating()+"</rating>\n" +
"        <release_date>"+form.format(date)+"</release_date>\n" +
"    </movie>";
System.out.println(input);


		OutputStream os = connection.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (connection.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ connection.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(connection.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		connection.disconnect();
                request.setAttribute("msg","successfully inserted") ;
                RequestDispatcher rd=request.getRequestDispatcher("insert.jsp");
                rd.forward(request, response);
               // rd.forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertMovie</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertMovie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(InsertMovie.class.getName()).log(Level.SEVERE, null, ex);
        }// catch (SAXException ex) {
           // Logger.getLogger(InsertMovie.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
