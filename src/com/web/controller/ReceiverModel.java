package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.metier.entities.Receiver;

public class ReceiverModel {
	private List<Receiver> listeReceive=new ArrayList<Receiver>();

	public List<Receiver> getListeReceive() {
		return listeReceive;
	}

	public void setListeReceive(List<Receiver> listeReceive) {
		this.listeReceive = listeReceive;
	}
	
}
