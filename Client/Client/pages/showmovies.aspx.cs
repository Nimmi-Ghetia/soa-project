using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;

namespace Client
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Button1_Click(object sender, EventArgs e)
        {

            
            GetMovies gm = new GetMovies();
            List<Movie> m = gm.GetAllMovies();
           // Label1.Text = m[1].getName();

            //var source = new BindingSource();
            GridView1.DataSource = m;
            GridView1.DataBind();
        }
    }
}