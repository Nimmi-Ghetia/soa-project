using Client.models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Xml.Serialization;

namespace Client.methods
{
    public class InsertBooking
    {
        public void addBooking(string content)
        {
            try
            {

                //string content;
                string Method = "POST";
                string uri = "http://107.170.65.250:8080/Hello1/webresources/book";
                HttpWebRequest req = WebRequest.Create(uri) as HttpWebRequest;
                req.KeepAlive = false;
                req.Method = Method.ToUpper();

                if (("POST,PUT").Split(',').Contains(Method.ToUpper()))
                {
                    using (StringWriter stringwriter = new System.IO.StringWriter())
                    {
                        
                       // content = (File.OpenText(@FilePath)).ReadToEnd();

                        byte[] buffer = Encoding.ASCII.GetBytes(content);
                        Console.WriteLine(buffer);
                        req.ContentLength = buffer.Length;
                        req.ContentType = "application/xml";
                        Stream PostData = req.GetRequestStream();
                        PostData.Write(buffer, 0, buffer.Length);
                        PostData.Close();
                    }
                }

                HttpWebResponse resp = req.GetResponse() as HttpWebResponse;

                Encoding enc = System.Text.Encoding.GetEncoding(1252);
                StreamReader loResponseStream =
                new StreamReader(resp.GetResponseStream(), enc);

                string Response = loResponseStream.ReadToEnd();

                loResponseStream.Close();
                resp.Close();
                Console.WriteLine(Response);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message.ToString());
            }

        }
    }
}