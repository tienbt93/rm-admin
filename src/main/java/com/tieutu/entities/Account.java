package com.tieutu.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name="account")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="birth_of_day", nullable=false)
	private Date birthOfDay;

	@Column(nullable=false, length=45)
	private String description;

	@Column(nullable=false, length=255)
	private String email;

	@Column(name="full_name", nullable=false, length=255)
	private String fullName;

	@Column(nullable=false)
	private byte gender;

	@Column(nullable=false, length=255)
	private String password;

	@Column(name="user_name", nullable=false, length=255)
	private String userName;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="restaurant_id", nullable=false)
	private Restaurant restaurant;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id", nullable=false)
	private Role role;

	public Account() {
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

	public Date getBirthOfDay() {
		return this.birthOfDay;
	}

	public void setBirthOfDay(Date birthOfDay) {
		this.birthOfDay = birthOfDay;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}