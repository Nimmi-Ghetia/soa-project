using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Client
{
    public class Movie
    {

        public string name;
        private DateTime release_date;
        private float rating;
        private int cat_id;
        private int mov_id;
        private int price;
        public Movie()
        {

        }
        public Movie(int mov_id, int cat_id, int price, float rating, DateTime release_date, String name)
        {
            this.mov_id = mov_id;
            this.cat_id = cat_id;
            this.price = price;
            this.release_date = release_date;
            this.name = name;
            this.rating = rating;
        }
        override
        public String ToString()
        {
            return (mov_id + "  " + cat_id + "  " + name + "  " + price + "  "
+ rating + "  " +
release_date.ToShortDateString() + "\n");
        }
        public void setMov_id(int id)
        {
            this.mov_id = id;
        }
        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
        public DateTime getRelease_date()
        {
            return release_date;
        }
        public void setRelease_date(DateTime release_date)
        {
            this.release_date = release_date;
        }
        public float getRating()
        {
            return rating;
        }
        public void setRating(float rating)
        {
            this.rating = rating;
        }
        public int getCat_id()
        {
            return cat_id;
        }
        public void setCat_id(int cat_id)
        {
            this.cat_id = cat_id;
        }
        public int getMov_id()
        {
            return mov_id;
        }
        
        public int getPrice()
        {
            return price;
        }
        public void setPrice(int price)
        {
            this.price = price;
        }

    }
}