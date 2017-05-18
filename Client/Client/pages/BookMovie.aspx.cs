using Client.methods;
using Client.models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Client
{
    public partial class BookMovie : System.Web.UI.Page
    {

        GetMovies gm = new GetMovies();
        List<Movie> m;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (IsPostBack == false)
            {
                GetCities gc = new GetCities();
                //GetCinema gc = new GetCinema();     
                // gm = new GetAllMovies();
                DropDownList4.Items.Add("--city--");
                List<string> city = gc.getCity();
                DropDownList4.DataSource = city;
                DropDownList4.DataBind();
                info.Visible = false;
                Label4.Text = "0";
            }
            //Label4.Text = "0";

        }

        protected void RadioButtonList2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            m = gm.GetMoviebyCinema(Int32.Parse( DropDownList3.SelectedValue));
           // Label3.Text +="fddf";
            foreach (Movie m1 in m)
            {
                if (m1.getName() == DropDownList1.SelectedItem.Text)
                {
                    name.Text = m1.getName();
                    rating.Text = m1.getRating().ToString();
                    release.Text = m1.getRelease_date().ToString();
                }
            }
            info.Visible = true;
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            m = gm.GetMoviebyCinema(Int32.Parse(DropDownList3.SelectedValue));
            int amount = 0;
            foreach (Movie m1 in m)
            {
                if (m1.getName() == DropDownList1.SelectedValue)
                {
                    amount += m1.getPrice();
                }
            }
            if(RadioButtonList2.SelectedValue=="Silver")
            {
                amount += 10;
            }
            else if (RadioButtonList2.SelectedValue == "Gold")
            {
                amount += 20;
            }
            else if (RadioButtonList2.SelectedValue == "Platinum")
            {
                amount += 30;
            }
            int no = Int32.Parse(DropDownList2.SelectedValue);
            amount = amount * no;
            Label4.Text = amount+"";
        }

        protected void DropDownList3_SelectedIndexChanged(object sender, EventArgs e)
        {
            m = gm.GetMoviebyCinema(Int32.Parse( DropDownList3.SelectedValue));

            /*List<string> name = new List<string>();
            name.Add("--movies--");
            foreach (Movie m1 in m)
            {
                name.Add(m1.getName());
            }
            DropDownList1.DataSource = name;
            DropDownList1.DataBind();
            */
            info.Visible = false;
            
            ListItem item1 = new ListItem("--movie--", "-1");
            DropDownList1.Items.Add(item1);
            foreach (Movie m1 in m)
            {

                ListItem item = new ListItem(m1.getName(), m1.getMov_id().ToString());

                DropDownList1.Items.Add(item);
                //bel4.Text += cinema.getCin_id()+" "+cinema.getCity()+" "+cinema.getName();
            }

        }

        protected void DropDownList2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        protected void DropDownList4_SelectedIndexChanged(object sender, EventArgs e)
        {
            List<Cinema> cin = new List<Cinema>();
            GetCinema c = new GetCinema();
            cin = c.GetCinemabycity(DropDownList4.SelectedValue);
            DropDownList3.Items.Clear();
            ListItem item1 = new ListItem("--cinema--","-1");
            DropDownList3.Items.Add(item1);
            foreach (Cinema cinema in cin)
            {

                ListItem item = new ListItem(cinema.getName(), cinema.getCin_id().ToString());

                DropDownList3.Items.Add(item);
                //bel4.Text += cinema.getCin_id()+" "+cinema.getCity()+" "+cinema.getName();
            }
            DropDownList1.Items.Clear();
            info.Visible = false;

        }

        protected void Pay_Click(object sender, EventArgs e)
        {
            InsertBooking is1 = new InsertBooking();
            GetBooking gb = new GetBooking();
            int size = gb.getsize();
            Label5.Text = size.ToString();
            size++;
            string content="<book><book_id>"+size+"</book_id><cin_id>"+
                DropDownList3.SelectedValue+"</cin_id><date>"+
                DateTime.Now.ToString("yyyy-MM-ddTHH:mm:sszzz") + "</date><mov_id>"+DropDownList1.SelectedValue+"</mov_id><no_of_seats>"+DropDownList2.SelectedValue+"</no_of_seats><total>"+Label4.Text+"</total></book>";
          //  content = "sjzdkhdkjhkjjdh" + DropDownList3.SelectedValue+"lakdkjhdskjhkj";
            Label5.Text = content;
           
            
            is1.addBooking(content);
            //Label5.Text = content;
            Response.Redirect("pay.aspx?book_id="+size);
        }
    }
}