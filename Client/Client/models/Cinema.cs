using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Client.models
{
    public class Cinema
    {
        private int cin_id;
        private string name;
        private string city;
            public int getCin_id()
            {
                return cin_id;
            }
            public void setCin_id(int cin_id)
        {
            this.cin_id = cin_id;
        }

            public string getName()
            {
                return name;
            }

            public void setName(string name)
            {
                this.name = name;
            }

            public string getCity()
            {
                return city;
            }

            public void setCity(string city)
            {
                this.city = city;
            }


        


    }
}