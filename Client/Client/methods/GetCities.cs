using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Xml;
using System.Web.UI.WebControls;

namespace Client.methods
{
    public class GetCities
    {
        public List<string> getCity()
        {
            List<string> c = new List<string>();
            c.Add("--city--");
        string y = "";
            try
            {
                String uri = "http://107.170.65.250:8080/Hello1/webresources/city";
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
                                    case "id":
                                        
                                        break;
                                    
                                    case "city":
                                        c.Add(i+"");
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
    }
}