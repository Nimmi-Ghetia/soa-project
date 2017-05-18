using Client.methods;
using Client.models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using System.Xml.Serialization;

namespace Client.pages
{
    public partial class pay : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            id.Text = Request.QueryString["book_id"];
        }

        protected void Submit_Click(object sender, EventArgs e)
        {
            /* Document document = new Document();

    Page page = new Page(PageSize.Letter, PageOrientation.Portrait);
               document.Pages.Add(page);

    page.Elements.Add(new Label("My PDF Document", 0, 0, 512, 40, Font.Helvetica));
    document.Draw(@"C:\MyDocument.pdf");
    */
            ClientScript.RegisterStartupScript(this.GetType(), "msg", "<script language=javascript>printData();</script>");
        }
    }
}