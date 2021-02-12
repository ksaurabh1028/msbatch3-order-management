package com.sl.ms.ordermanagement;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SL_ORDERS")
public class Order {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;
  Double total_amount;
  
  @OneToMany(cascade=CascadeType.ALL) 
  @JoinColumn(name="order_id")
  Set<Item> items;
/**
 * @param id
 * @param name
 * @param total_amount
 * @param items
 */
public Order(Long id, String name, Double total_amount, Set<Item> items) {
	super();
	this.id = id;
	this.name = name;
	this.total_amount = total_amount;
	this.items = items;
}

public Order() {}
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
 * @return the total_amount
 */
public Double getTotal_amount() {
	return total_amount;
}
/**
 * @param total_amount the total_amount to set
 */
public void setTotal_amount(Double total_amount) {
	this.total_amount = total_amount;
}
/**
 * @return the items
 */
public Set<Item> getItems() {
	return items;
}
/**
 * @param items the items to set
 */
public void setItems(Set<Item> items) {
	this.items = items;
}
}
