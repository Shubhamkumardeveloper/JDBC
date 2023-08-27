package edu.jsp.orderapp.model;

public class Order {
	private int orderId;
	private String orderFoodName;
	private int price;
	private int quantity;
	private int gstPerc;
	private int totalAmount;
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderFoodName() {
		return orderFoodName;
	}
	public void setOrderFoodName(String orderFoodName) {
		this.orderFoodName = orderFoodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGstPerc() {
		return gstPerc;
	}
	public void setGstPerc(int gstPerc) {
		this.gstPerc = gstPerc;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString() {
		return orderId +","+ orderFoodName + ","+price + ","+ quantity + ","+gstPerc + ","+ totalAmount+"\n";
	}
}
