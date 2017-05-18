/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypro;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.DoubleStream.builder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author ngghe
 */
public class FetchAll extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           List<Movie> m1=new ArrayList<Movie>() ;
            String uri = 
    "http://107.170.65.250:8080/Hello1/webresources/movies";
URL url = new URL(uri);
HttpURLConnection connection = 
    (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setRequestProperty("Accept", "application/xml");
 
//JAXBContext jc = JAXBContext.newInstance(List<Movie>);
Movie m=new Movie();
String x="";
InputStream xml = connection.getInputStream();
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(xml);
Element element = doc.getDocumentElement();
NodeList nodes = element.getChildNodes();
for (int i = 0; i < nodes.getLength(); i++) {
            x+="  <br/>      " + nodes.item(i).getTextContent()+"            <br/><br/>";
}
//List<Movie> m = 
  //  (List<Movie>) jc.createUnmarshaller().unmarshal(xml);
 
connection.disconnect();

        /*   Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/CustomerService/rest/customers");
           List<Movie> customers = resource.path("movies")
            .accept(MediaType.APPLICATION_XML)
                .get(new GenericType<List<Movie>>(){});*/
        //System.out.println(m.size());
request.setAttribute("x",x) ;
  RequestDispatcher rd=request.getRequestDispatcher("getall.jsp");
                         rd.forward(request, response);
                   
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FetchAll</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FetchAll at " + request.getContextPath() + "</h1>");
          out.println(x+"<br/><br/><br/>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            Logger.getLogger(FetchAll.class.getName()).log(Level.SEVERE, null, ex);
        }
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
