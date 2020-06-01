package com.metier.Interface;

import java.util.List;

import com.metier.entities.Receiver;



public interface ReceiverInterface {
	public void create_Receiver(Receiver rec);
	public void update_Receiver(Receiver rec);
	public void delete_Receiver(Receiver rec);
	public Receiver find_Receiver(int rec_id);
	public List<Receiver> liste_Receiver();
	
}
