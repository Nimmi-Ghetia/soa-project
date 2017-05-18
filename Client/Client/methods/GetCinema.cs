using Client.models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.UI.WebControls;
using System.Xml;

namespace Client
{
    public class GetCinema
    {
        //List<Movie> ml = new List<Movie>();
        public Cinema GetCinemabyid(int id)
        {
            Cinema c = new Cinema();

            string y = "";
            try
            {
                String uri = "http://107.170.65.250:8080/Hello1/webresources/movies/cinema/" + id;
                HttpWebRequest req = WebRequest.Create(uri) as HttpWebRequest;
                req.KeepAlive = false;
                req.Method = "GET";//Method.ToUpper();
                HttpWebResponse resp = req.GetResponse() as HttpWebResponse;
                Encoding enc = System.Text.Encoding.GetEncoding(1252);
                StreamReader loResponseStream =
                new StreamReader(resp.GetResponseStream(), enc);

                //   string Response = loResponseStream.ReadToEnd();
                XmlDocument xmlDoc = new XmlDocument();
                xmlDoc.Load(resp.GetResponseStream());
                // return (xmlDoc);

                loResponseStream.Close();
                resp.Close();
                TreeNode root = new TreeNode(xmlDoc.DocumentElement.Name);


                foreach (XmlNode node in xmlDoc.DocumentElement.ChildNodes) // for each <testcase> node
                {
                    if (node.HasChildNodes)
                    {
                        //Movie m = new Movie();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {

                                string i = n.InnerText + "";
                                //  y += i;
                                switch (n.Name)
                                {
                                    case "cin_id":
                                        c.setCin_id(Int32.Parse(i));
                                        break;
                                    case "name":
                                        
                                        c.setName(i);
                                        //y += m.getName();
                                        break;
                                    
                                    case "city":
                                        c.setCity(i);
                                        //y += m.getRelease_date();
                                        break;

                                }

                            }
                            catch (Exception exq)
                            {
                                y += (exq.Message.ToString());
                            }

                        }
                        //y += m.ToString();
          //y += "\n\n";
                        //ml.Add(m);
                    }

                }
            }
            catch (Exception ex)
            {
                y += (ex.Message.ToString());
            }
            return c;
        }
        public List<Cinema> GetCinemabycity(string city)
        {
            List<Cinema> cin = new List<Cinema>();
            
            string y = "";
            try
            {
                String uri = "http://107.170.65.250:8080/Hello1/webresources/cinema/city/" + city;
                HttpWebRequest req = WebRequest.Create(uri) as HttpWebRequest;
                req.KeepAlive = false;
                req.Method = "GET";//Method.ToUpper();
                HttpWebResponse resp = req.GetResponse() as HttpWebResponse;
                Encoding enc = System.Text.Encoding.GetEncoding(1252);
                StreamReader loResponseStream =
                new StreamReader(resp.GetResponseStream(), enc);

                //   string Response = loResponseStream.ReadToEnd();
                XmlDocument xmlDoc = new XmlDocument();
                xmlDoc.Load(resp.GetResponseStream());
                // return (xmlDoc);

                loResponseStream.Close();
                resp.Close();
                TreeNode root = new TreeNode(xmlDoc.DocumentElement.Name);


                foreach (XmlNode node in xmlDoc.DocumentElement.ChildNodes) // for each <testcase> node
                {
                    if (node.HasChildNodes)
                    {
                        //Movie m = new Movie();
                        Cinema c = new Cinema();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {
                               
                                string i = n.InnerText + "";
                                //  y += i;
                                switch (n.Name)
                                {
                                    case "cin_id":
                                        c.setCin_id(Int32.Parse(i));
                                        break;
                                    case "name":

                                        c.setName(i);
                                        //y += m.getName();
                                        break;

                                    case "city":
                                        c.setCity(i);
                                        //y += m.getRelease_date();
                                        break;

                                }
                                
                            }
                            catch (Exception exq)
                            {
                                y += (exq.Message.ToString());
                            }

                        }
                        //y += m.ToString();
                        //y += "\n\n";
                        //ml.Add(m);
                        cin.Add(c);
                    }

                }
            }
            catch (Exception ex)
            {
                y += (ex.Message.ToString());
            }
            return cin;
        }
    }
}