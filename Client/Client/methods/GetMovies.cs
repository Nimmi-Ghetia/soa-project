using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Net;
using System.Text;

using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using System.IO;

namespace Client
{
    public class GetMovies
    {
        List<Movie> ml = new List<Movie>() ;
        public List<Movie> GetAllMovies()
        {
            string y = "";
            try
            {
                String uri = "http://107.170.65.250:8080/Hello1/webresources/movies";
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
                        Movie m = new Movie();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {
                                
                                string i = n.InnerText + "";
                                //  y += i;
                                switch (n.Name)
                                {
                                    case "name":
                                        m.setName(i);
                                        //y += m.getName();
                                        break;
                                    case "cat_id":
                                        m.setCat_id(Int32.Parse(i));
                                        //y += m.getCat_id();
                                        break;
                                    case "mov_id":
                                        m.setMov_id(Int32.Parse(i));
                                        //y += m.getMov_id();
                                        break;
                                    case "price":
                                        m.setPrice(Int32.Parse(i));

                                        //y += m.getPrice();
                                        break;
                                    case "rating":
                                        m.setRating(float.Parse(i));
                                        //y += m.getRating();
                                        break;
                                    case "release_date":
                                        m.setRelease_date(DateTime.Parse(i));
                                        //y += m.getRelease_date();
                                        break;

                                }

                            }
                            catch (Exception exq)
                            {
                                y += (exq.Message.ToString());
                            }

                        }
                        y += m.ToString();
                        y += "\n\n";
                        ml.Add(m);
                    }

                }
            }
            catch (Exception ex)
            {
                y += (ex.Message.ToString());
            }
            return ml;
        }
        public List<Movie> GetMoviebyCinema(int id)
        {
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
                        Movie m = new Movie();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {

                                string i = n.InnerText + "";
                                //  y += i;
                                switch (n.Name)
                                {
                                    case "name":
                                        m.setName(i);
                                        //y += m.getName();
                                        break;
                                    case "cat_id":
                                        m.setCat_id(Int32.Parse(i));
                                        //y += m.getCat_id();
                                        break;
                                    case "mov_id":
                                        m.setMov_id(Int32.Parse(i));
                                        //y += m.getMov_id();
                                        break;
                                    case "price":
                                        m.setPrice(Int32.Parse(i));

                                        //y += m.getPrice();
                                        break;
                                    case "rating":
                                        m.setRating(float.Parse(i));
                                        //y += m.getRating();
                                        break;
                                    case "release_date":
                                        m.setRelease_date(DateTime.Parse(i));
                                        //y += m.getRelease_date();
                                        break;

                                }

                            }
                            catch (Exception exq)
                            {
                                y += (exq.Message.ToString());
                            }

                        }
                        y += m.ToString();
                        y += "\n\n";
                        ml.Add(m);
                    }

                }
            }
            catch (Exception ex)
            {
                y += (ex.Message.ToString());
            }
            return ml;
        }
    }
}