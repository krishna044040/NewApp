package com.krs.realtimeproject;

public class Drug {
@Override
	public String toString() {
		return "Drug [id=" + id + ", dname=" + dname + ", price=" + price + ", dmfg=" + dmfg + ", dexp=" + dexp + "]";
	}
private  int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private  String dname;
private  int price;
private  String dmfg;
private  String dexp;
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getDmfg() {
	return dmfg;
}
public void setDmfg(String dmfg) {
	this.dmfg = dmfg;
}
public  String getDexp() {
	return dexp;
}
public void setDexp(String dexp) {
	this.dexp = dexp;
}
public Drug(String dname, int price, String dmfg, String dexp) {
	super();
	this.dname = dname;
	this.price = price;
	this.dmfg = dmfg;
	this.dexp = dexp;
}
public Drug() {

}




}
