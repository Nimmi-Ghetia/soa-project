using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Client.models
{
    [Serializable]
    public class Book
    {
        private int book_id;
        private int mov_id;
        private int cin_id;
        private int no_of_seats;
        private DateTime date;
        private int total;

        public int getBook_id()
        {
            return book_id;
        }

        public void setBook_id(int book_id)
        {
            this.book_id = book_id;
        }

        public int getMov_id()
        {
            return mov_id;
        }

        public void setMov_id(int mov_id)
        {
            this.mov_id = mov_id;
        }

        public int getCin_id()
        {
            return cin_id;
        }

        public void setCin_id(int cin_id)
        {
            this.cin_id = cin_id;
        }

        public int getNo_of_seats()
        {
            return no_of_seats;
        }

        public void setNo_of_seats(int no_of_seats)
        {
            this.no_of_seats = no_of_seats;
        }

        public DateTime getDate()
        {
            return date;
        }

        public void setDate(DateTime date)
        {
            this.date = date;
        }

        public int getTotal()
        {
            return total;
        }

        public void setTotal(int total)
        {
            this.total = total;
        }
        
    }
}