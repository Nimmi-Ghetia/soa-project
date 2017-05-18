/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypro;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ngghe
 */
@XmlRootElement
class Movie {
     	private String name ;
	private Date release_date ;
	private float rating ;
	private int cat_id ;
	private int mov_id ;
	private int price ;
        private int cin_id;

    public int getCin_id() {
        return cin_id;
    }

    public void setCin_id(int cin_id) {
        this.cin_id = cin_id;
    }
	public Movie(){
		
	}
	public Movie(int mov_id,int cat_id,int price,float rating,Date release_date,String name){
		this.mov_id=mov_id ;
		this.cat_id=cat_id ;
		this.price=price ;
		this.release_date=release_date;
		this.name=name ;
		this.rating=rating ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getMov_id() {
		return mov_id;
	}
	public void setMov_id(int mov_id) {
		this.mov_id = mov_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
   
}
