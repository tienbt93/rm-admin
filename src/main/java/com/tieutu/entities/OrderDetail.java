package com.tieutu.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the order_detail database table.
 * 
 */
@Entity
@Table(name="order_detail")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cr_datetime", nullable=false)
	private Date crDatetime;

	private int quantiy;

	//bi-directional many-to-one association to Item
	@ManyToOne
	@JoinColumn(name="items_id", nullable=false)
	private Item item;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private Order order;

	public OrderDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCrDatetime() {
		return this.crDatetime;
	}

	public void setCrDatetime(Date crDatetime) {
		this.crDatetime = crDatetime;
	}

	public int getQuantiy() {
		return this.quantiy;
	}

	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}