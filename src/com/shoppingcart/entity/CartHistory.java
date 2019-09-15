package com.shoppingcart.entity;

public class CartHistory {

		private String username;
		private String itemName;
		private String itemDesc;
		private double itemPrice;
		private int quantity;
		private double totItemPrice;
		private double totPurchasePrice;
		private String dop;
		
		public CartHistory(String username, String itemName, String itemDesc, double itemPrice, int quantity,
				double totItemPrice, double totPurchasePrice, String dop) {
			this.username = username;
			this.itemName = itemName;
			this.itemDesc = itemDesc;
			this.itemPrice = itemPrice;
			this.quantity = quantity;
			this.totItemPrice = totItemPrice;
			this.totPurchasePrice = totPurchasePrice;
			this.dop = dop;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getItemName() {
			return itemName;
		}
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}
		public String getItemDesc() {
			return itemDesc;
		}
		public void setItemDesc(String itemDesc) {
			this.itemDesc = itemDesc;
		}
		public double getItemPrice() {
			return itemPrice;
		}
		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getTotItemPrice() {
			return totItemPrice;
		}
		public void setTotItemPrice(double totItemPrice) {
			this.totItemPrice = totItemPrice;
		}
		public double getTotPurchasePrice() {
			return totPurchasePrice;
		}
		public void setTotPurchasePrice(double totPurchasePrice) {
			this.totPurchasePrice = totPurchasePrice;
		}
		public String getDop() {
			return dop;
		}
		public void setDop(String dop) {
			this.dop = dop;
		}
		
}
