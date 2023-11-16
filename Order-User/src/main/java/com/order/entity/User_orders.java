package com.order.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Document(collection="user_orders")
public class User_orders {
	
	
    @Id
    @NotNull
	private int order_id;
  
    @NotNull
	private int user_id;
  
    @NotNull
	private int dish_id;
    @NotBlank
	private String dish_name;
    @NotNull            //for string
	private int quantity;
    @NotNull              //for int,float
	private float total_price;
    @NotNull
	private boolean status;
    @NotNull
	private Date date;
    
	public User_orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_orders(int order_id, int user_id, int dish_id, String dish_name, int quantity, float total_price,
			boolean status, Date date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.quantity = quantity;
		this.total_price = total_price;
		this.status = status;
		this.date = date;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDish_id() {
		return dish_id;
	}
	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User_orders [order_id=" + order_id + ", user_id=" + user_id + ", dish_id=" + dish_id + ", dish_name="
				+ dish_name + ", quantity=" + quantity + ", total_price=" + total_price + ", status=" + status
				+ ", date=" + date + "]";
	}
	
	
	

}
