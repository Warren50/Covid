package com.web.controller;

public class ReceiverModel {
	private int id;
	private int card_id;
	private int id_user_receiver;
	private int id_valider;
	private int phone;
	private int code;
	public ReceiverModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReceiverModel(int id, int card_id, int id_user_receiver,
			int id_valider, int phone, int code) {
		super();
		this.id = id;
		this.card_id = card_id;
		this.id_user_receiver = id_user_receiver;
		this.id_valider = id_valider;
		this.phone = phone;
		this.code = code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getId_user_receiver() {
		return id_user_receiver;
	}
	public void setId_user_receiver(int id_user_receiver) {
		this.id_user_receiver = id_user_receiver;
	}
	public int getId_valider() {
		return id_valider;
	}
	public void setId_valider(int id_valider) {
		this.id_valider = id_valider;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	

}
