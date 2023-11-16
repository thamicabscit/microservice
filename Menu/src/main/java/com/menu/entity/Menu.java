package com.menu.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection="menu")
public class Menu {
	
	@Id
	@NotNull
	private int menu_id;
	@NotBlank
	private String dish_name;
	
	private String dish_image;
	@NotNull
	private int dish_price;
	private String description;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int menu_id, String dish_name, String dish_image, int dish_price, String description) {
		super();
		this.menu_id = menu_id;
		this.dish_name = dish_name;
		this.dish_image = dish_image;
		this.dish_price = dish_price;
		this.description = description;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public String getDish_image() {
		return dish_image;
	}
	public void setDish_image(String dish_image) {
		this.dish_image = dish_image;
	}
	public int getDish_price() {
		return dish_price;
	}
	public void setDish_price(int dish_price) {
		this.dish_price = dish_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", dish_name=" + dish_name + ", dish_image=" + dish_image + ", dish_price="
				+ dish_price + ", description=" + description + "]";
	}
	
	
	

}
