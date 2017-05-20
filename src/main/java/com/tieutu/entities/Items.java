package com.tieutu.entities;
// Generated May 20, 2017 12:46:27 AM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Items generated by hbm2java
 */
@Entity
@Table(name = "items", catalog = "store_manager")
public class Items implements java.io.Serializable {

	private int id;
	private Category category;
	private String name;
	private float price;
	private String description;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Items() {
	}

	public Items(int id, Category category, String name, float price, String description) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Items(int id, Category category, String name, float price, String description,
			Set<OrderDetail> orderDetails) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.description = description;
		this.orderDetails = orderDetails;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "price", nullable = false, precision = 12, scale = 0)
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}