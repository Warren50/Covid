package com.metier.entities;

import com.metier.implementation.ReceiverImpl;
import com.metier.implementation.SymptomeImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creation du symptome
		Symtome symptome=new Symtome("corona");
		symptome.setDescription("tue");
       ReceiverImpl t=new  ReceiverImpl();
      // t.create_Symptome(symptome);
      // System.out.println("sdgsdgsd");
       //modifier un symptome
       symptome.setId(2);
     
       symptome.setNom("Adamu");
       //t.update_Symptome(symptome);
      // System.out.println("sdgsdgsd");
       //delete symptome
      // t.delete_symptome(symptome);
    //   symptome.setDescription("tu vas mourir");
      // Symtome symp=t.find_Symptome(1);
     
      
        
      
       //create et receiver
       Receiver rec =new Receiver(4,2,3,4872,4597);
       t.create_Receiver(rec);
       for(Receiver r:t.liste_Receiver())
       {
    	   System.out.println(""+r.getCard_id()+" " + r.getCode()+" "+r.getId());
       }
       
   
	}
}
