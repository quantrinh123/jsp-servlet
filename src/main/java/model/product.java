package model;

import java.sql.Date;

public class product  {
	private int ID;
private String name;
private double price;
private String dcri;
private String img;
private Date date;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public product() {
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDcri() {
	return dcri;
}
public void setDcri(String dcri) {
	this.dcri = dcri;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

public product(int iD, String name, double price, String dcri, String img, Date date) {
	super();
	ID = iD;
	this.name = name;
	this.price = price;
	this.dcri = dcri;
	this.img = img;
	this.date = date;
}

}