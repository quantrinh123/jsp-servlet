package model;

public class cart {
private int id;
private int idProduct;
private int idUser;
private int quantity;

public cart() {
}
public cart(int id, int idProduct, int idUser, int quantity) {
	super();
	this.id = id;
	this.idProduct = idProduct;
	this.idUser = idUser;
	this.quantity = quantity;
}
public void setId(int id) {
	this.id = id;
}
public int getId() {
	return id;
}

public int getIdProduct() {
	return idProduct;
}
public void setIdProduct(int idProduct) {
	this.idProduct = idProduct;
}
public int getIdUser() {
	return idUser;
}
public void setIdUser(int idUser) {
	this.idUser = idUser;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
