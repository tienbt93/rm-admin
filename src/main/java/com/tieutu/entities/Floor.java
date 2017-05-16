package com.tieutu.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the floor database table.
 * 
 */
@Entity
@Table(name="floor")
@NamedQuery(name="Floor.findAll", query="SELECT f FROM Floor f")
public class Floor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private Restaurant restaurant;

	//bi-directional many-to-one association to Tables
	@OneToMany(mappedBy="floor")
	private Set<Tables> tables;

	public Floor() {
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

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<Tables> getTables() {
		return this.tables;
	}

	public void setTables(Set<Tables> tables) {
		this.tables = tables;
	}

	public Tables addTable(Tables table) {
		getTables().add(table);
		table.setFloor(this);

		return table;
	}

	public Tables removeTable(Tables table) {
		getTables().remove(table);
		table.setFloor(null);

		return table;
	}

}