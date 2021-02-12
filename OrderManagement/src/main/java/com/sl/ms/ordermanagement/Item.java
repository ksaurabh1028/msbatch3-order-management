package com.sl.ms.ordermanagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SL_ITEMS")
public class Item {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private Integer quantity;
  private Double price;
  private Double amount;
  
/**
 * @param id
 * @param name
 * @param quantity
 * @param price
 * @param amount
 */
public Item(long id, String name, Integer quantity, Double price, Double amount) {
	super();
	this.id = id;
	this.name = name;
	this.quantity = quantity;
	this.price = price;
	this.amount = amount;
}

public Item() {}
/**
 * @return the id
 */
public long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(long id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the quantity
 */
public int getQuantity() {
	return quantity;
}
/**
 * @param quantity the quantity to set
 */
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
/**
 * @return the price
 */
public double getPrice() {
	return price;
}
/**
 * @param price the price to set
 */
public void setPrice(double price) {
	this.price = price;
}
/**
 * @return the amount
 */
public double getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(double amount) {
	this.amount = amount;
}
  
}
