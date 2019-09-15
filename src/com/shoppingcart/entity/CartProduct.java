package com.shoppingcart.entity;

public class CartProduct {
	
	
	private String user, product_name,product_desc;
	private int cartId, quantity;
	private double total_Quantity_Price, product_price, payable;
	
	

	public CartProduct(double payable) {
		super();
		this.payable = payable;
	}






	public CartProduct(int cartId, String user, String product_name, String product_desc, double product_price ,
		int quantity, double total_Quantity_Price ) {
		this.user = user;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.cartId = cartId;
		this.quantity = quantity;
		this.total_Quantity_Price = total_Quantity_Price;
		this.product_price = product_price;
	}






	public CartProduct( int cartId, String user, String product_name, String product_desc, double product_price, int quantity) {
		super();
		this.user = user;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_price = product_price;
		this.cartId = cartId;
		this.quantity = quantity;
	}


	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getProduct_name() {
		return product_name;
	}



	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}



	public String getProduct_desc() {
		return product_desc;
	}



	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getTotal_Quantity_Price() {
		return total_Quantity_Price;
	}



	public void setTotal_Quantity_Price(double total_Quantity_Price) {
		this.total_Quantity_Price = total_Quantity_Price;
	}



	public double getProduct_price() {
		return product_price;
	}



	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}






	public double getPayable() {
		return payable;
	}






	public void setPayable(double payable) {
		this.payable = payable;
	}


	
}
