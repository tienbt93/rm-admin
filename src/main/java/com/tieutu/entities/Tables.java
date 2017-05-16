package com.tieutu.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tables database table.
 * 
 */
@Entity
@Table(name="tables")
@NamedQuery(name="Tables.findAll", query="SELECT t FROM Tables t")
public class Tables implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	@Column(name="quatity_customer", nullable=false)
	private byte quatityCustomer;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="table")
	private Set<Order> orders;

	//bi-directional many-to-one association to Floor
	@ManyToOne
	@JoinColumn(name="floor_id", nullable=false)
	private Floor floor;

	public Tables() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getQuatityCustomer() {
		return this.quatityCustomer;
	}

	public void setQuatityCustomer(byte quatityCustomer) {
		this.quatityCustomer = quatityCustomer;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setTable(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setTable(null);

		return order;
	}

	public Floor getFloor() {
		return this.floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}