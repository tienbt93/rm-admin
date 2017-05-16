package com.tieutu.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the restaurant database table.
 * 
 */
@Entity
@Table(name="restaurant")
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String address;

	@Column(nullable=false, length=255)
	private String description;

	@Column(nullable=false, length=255)
	private String name;

	@Column(name="phone_number", nullable=false, length=25)
	private String phoneNumber;

	//bi-directional many-to-one association to Account
	@OneToMany(mappedBy="restaurant")
	private Set<Account> accounts;

	//bi-directional many-to-one association to Floor
	@OneToMany(mappedBy="restaurant")
	private Set<Floor> floors;

	public Restaurant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Account addAccount(Account account) {
		getAccounts().add(account);
		account.setRestaurant(this);

		return account;
	}

	public Account removeAccount(Account account) {
		getAccounts().remove(account);
		account.setRestaurant(null);

		return account;
	}

	public Set<Floor> getFloors() {
		return this.floors;
	}

	public void setFloors(Set<Floor> floors) {
		this.floors = floors;
	}

	public Floor addFloor(Floor floor) {
		getFloors().add(floor);
		floor.setRestaurant(this);

		return floor;
	}

	public Floor removeFloor(Floor floor) {
		getFloors().remove(floor);
		floor.setRestaurant(null);

		return floor;
	}

}