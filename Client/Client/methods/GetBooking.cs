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

namespace Client.methods
{
    public class GetBooking
    {
        public Book GetBook(int id)
        {
            Book m = null;
            string y = "";
            try
            {
                String uri = "http://107.170.65.250:8080/Hello1/webresources/book/" + id;
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
                         m= new Book();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {

                                string i = n.InnerText + "";
                                //  y += i;
                                switch (n.Name)
                                {
                                    case "book_id":
                                        m.setBook_id(Int32.Parse(i));
                                        //y += m.getName();
                                        break;
                                    case "cin_id":
                                        m.setCin_id(Int32.Parse(i));
                                        //y += m.getCat_id();
                                        break;
                                    case "mov_id":
                                        m.setMov_id(Int32.Parse(i));
                                        //y += m.getMov_id();
                                        break;
                                    case "no_of_seats":
                                        m.setNo_of_seats(Int32.Parse(i));

                                        //y += m.getPrice();
                                        break;
                                    case "total":
                                        m.setTotal(Int32.Parse(i));
                                        //y += m.getRating();
                                        break;
                                    case "date":
                                        m.setDate(DateTime.Parse(i));
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
                        //ml.Add(m);
                    }

                }
            }
            catch (Exception ex)
            {
                y += (ex.Message.ToString());
            }
            return m;
        }


        public int getsize()
        {
            string i="";
            string size = "";
            try
            {
                string uri = "http://107.170.65.250:8080/Hello1/webresources/city/book";
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
                // Node n=root
                 size = xmlDoc.DocumentElement.InnerText;
                foreach (XmlNode node in xmlDoc.DocumentElement.ChildNodes) // for each <testcase> node
                {
                    if (node.HasChildNodes)
                    {
                        //m = new Book();
                        foreach (XmlNode n in node.ChildNodes)
                        {

                            try
                            {

                                 i = n.InnerText + "";
                                

                            }
                            catch (Exception exq)
                            {
                                //y += (exq.Message.ToString());
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
                //y += (ex.Message.ToString());
            }
            return Int32.Parse(size);



        }
    }
}