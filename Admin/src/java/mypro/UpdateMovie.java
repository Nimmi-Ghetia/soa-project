/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypro;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ngghe
 */
public class UpdateMovie extends HttpServlet {

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
            throws ServletException, IOException, ParserConfigurationException, SAXException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(Integer.parseInt(request.getParameter("flag"))==1)
            {
                System.out.println("inside submit");
                System.out.println(request.getParameter("name"));
                // List<Movie> m1=new ArrayList<Movie>() ;
                String uri = "http://107.170.65.250:8080/Hello1/webresources/movies/"+request.getParameter("name");
                URL url = new URL(uri);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Accept", "application/xml");

                //JAXBContext jc = JAXBContext.newInstance(List<Movie>);
                Movie m=new Movie();
                String x="";
                InputStream xml = connection.getInputStream();
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                 DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xml);
                if (doc.hasChildNodes()) {
                     printNote(request,doc.getChildNodes());
                }
                connection.disconnect();
        //System.out.println(request.getAttribute("price"));
        int y=Integer.parseInt((String)request.getAttribute("mov_id"));
        RequestDispatcher rd=request.getRequestDispatcher("Update.jsp?mov_id="+y);
                                 rd.forward(request, response);
            }
            else if(Integer.parseInt(request.getParameter("flag"))==2)
                    {
                        System.out.println("inside update");
                        
                        String uri = 
            "http://localhost:26617/Hello1/webresources/movies";
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Accept", "application/xml");
        connection.setRequestProperty("Content-Type", "application/xml");



         connection.setDoOutput(true);
         Movie m=new Movie();
         System.out.println(request.getParameter("mov_id"));
 m.setMov_id(Integer.parseInt((String)request.getParameter("mov_id")));
 m.setCat_id(Integer.parseInt(request.getParameter("cat_id")));
 m.setName(request.getParameter("name"));
 m.setPrice(Integer.parseInt(request.getParameter("price")));
 m.setRating(Float.parseFloat(request.getParameter("rating")));
 java.text.DateFormat form = new java.text.SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssXXX");
 
                    java.util.Date date = new Date();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());

 m.setRelease_date(date);
      /*   String input = "<movie>\n" +
        "        <cat_id>1</cat_id>\n" +
        "        <mov_id>6</mov_id>\n" +
        "        <name>charmi</name>\n" +
        "        <price>10</price>\n" +
        "        <rating>4.5</rating>\n" +
        "        <release_date>2017-04-04T00:00:00+05:30</release_date>\n" +
        "    </movie>";*/
      String input = "<movie>\n" +
"        <cat_id>"+m.getCat_id()+"</cat_id>\n" +
              "        <cin_id>"+m.getCin_id()+"</cin_id>\n" +
"        <mov_id>"+m.getMov_id()+"</mov_id>\n" +
"        <name>"+m.getName()+"</name>\n" +
"        <price>"+m.getPrice()+"</price>\n" +
"        <rating>"+m.getRating()+"</rating>\n" +
"        <release_date>"+form.format(date)+"</release_date>\n" +
"    </movie>";

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
                        
        request.setAttribute("msg", "updated sucessfully");
        RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
                                 rd.forward(request, response);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    }
        


            
                    request.setAttribute("msg","successfully updated") ;
                RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
                rd.forward(request, response);
                    /* TODO output your page here. You may use following sample code. */
              /*         
                */        
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet UpdateMovie</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Servlet UpdateMovie at " + request.getContextPath() + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
                } catch (SAXException ex) {
                    Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            try {
                processRequest(request, response);
            } catch (SAXException ex) {
                Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(UpdateMovie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private static void printNote(HttpServletRequest request,NodeList nodeList) {

/*Element element = doc.getDocumentElement();
System.out.println(element.getNodeName());
//Node nodes = element.getElementsByTagName("mov_id");
//String s[]=new String[7];
String s;
System.out.println(element.getElementsByTagName("mov_id").item(0).getTextContent());
System.out.println(element.getElementsByTagName("cin_id").item(0).getTextContent());
System.out.println(element.getElementsByTagName("name").item(0).getTextContent());
*///for (int i = 0; i < nodes.getLength(); i++) {
    //Element e1=(Element)nodes.item(i);
//    Node n=nodes.item(i);
    //Movie m=(Movie) e1;
    //System.out.println(n.item(i).getTextContent());
 //System.out.println(n.getNodeType());
   /* if(n.getNodeType()==Node.ELEMENT_NODE)
    {
        System.out.println("inside if");
        Element e= (Element)n ;
    System.out.println("First Name : " + e.getElementsByTagName("mov_id").item(0).getTextContent());
			System.out.println("Last Name : " + e.getElementsByTagName("cin_id").item(0).getTextContent());
			System.out.println("Nick Name : " + e.getElementsByTagName("name").item(0).getTextContent());
			System.out.println("Salary : " + e.getElementsByTagName("price").item(0).getTextContent());
    }*/
    /*s= nodes.item(i).getTextContent();
           for(int j=0 ; j<n.getLength(); j++)
           {
               
     System.out.println(n.item(j).getTextContent()); 
            switch(nodes.item(j).getNodeName())
            {
                case "cin_id":request.setAttribute("cin_id", s);
                break ;
                case "cat_id":request.setAttribute("cat_id", s);
                break ;
                case "name":request.setAttribute("name", s);
                break ;
                case "price":request.setAttribute("price", s);
                break ;
                case "rating":request.setAttribute("rating", s);
                break ;
                case "release_date":request.setAttribute("release_date", s);
                break ;
            }
           }*/
//}
//List<Movie> m = 
  //  (List<Movie>) jc.createUnmarshaller().unmarshal(xml);
	for (int count = 0; count < nodeList.getLength(); count++) {

    	Node tempNode = nodeList.item(count);

	// make sure it's element node.
	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

		// get node name and value
                String s=tempNode.getTextContent();
                //System.out.println(s);
                switch(tempNode.getNodeName())
                {
                                case "mov_id":request.setAttribute("mov_id", s);
                                break ;
                                case "cin_id":request.setAttribute("cin_id", s);
                                break ;
                                case "cat_id":request.setAttribute("cat_id", s);
                                break ;
                                case "name":request.setAttribute("name", s);
                                break ;
                                case "price":request.setAttribute("price", s);
                                break ;
                                case "rating":request.setAttribute("rating", s);
                                break ;
                                case "release_date":request.setAttribute("release_date", s);
                                break ;
                                default:
                                    System.out.println("jdhjs");
                                    break ;

                }
//request.setAttribute("x", tempNode.getTextContent());
                //System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
		//System.out.println("Node Value =" + tempNode.getTextContent());
	//	System.out.println(request.getAttribute("x"));

		if (tempNode.hasAttributes()) {

			// get attributes names and values
			NamedNodeMap nodeMap = tempNode.getAttributes();

			for (int i = 0; i < nodeMap.getLength(); i++) {

				Node node = nodeMap.item(i);
				System.out.println("attr name : " + node.getNodeName());
				System.out.println("attr value : " + node.getNodeValue());

			}

		}
                if (tempNode.hasChildNodes()) {

			// loop again if has child nodes
			printNote(request,tempNode.getChildNodes());

		}

		//System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");


}
        }}
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
