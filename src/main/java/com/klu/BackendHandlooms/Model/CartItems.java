package com.klu.BackendHandlooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartItems {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

private long itemId;
public long getItemId() {
	return itemId;
}
public void setItemId(long itemId) {
	this.itemId = itemId;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
private double price;
private String title;
private int quantity;
public CartItems() {
}
// Constructor to initialize CartItems with all necessary fields
public CartItems(long itemId, double price, int quantity, String title) {
    this.itemId = itemId;
    this.price = price;
    this.quantity = quantity;
    this.title = title;
}
}
