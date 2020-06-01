package com.metier.entities;

public class Agent {

	private int id;
	private int user_id;
	private int phone;
	private String description;
	
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(int phone) {
		super();
		this.phone = phone;
	}

	public Agent(int phone, String description) {
		super();
		this.phone = phone;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
