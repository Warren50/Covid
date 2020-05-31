package com.metier.entities;

import java.util.List;

import com.metier.implementation.SymptomeImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Test de l'ajout d'un symptome*/
		
		Symtome symptome =  new Symtome("toux");
		symptome.setDescription("la toux est une maladie");
		SymptomeImpl symptomeimpl = new SymptomeImpl();
		//symptomeimpl.create_symptome(symptome);
		
		/*Test de la mise à jour du symptome*/
		symptome.setId(1);
		symptome.setNom("toux1");
		symptome.setDescription("La toux n est pas bien");
		//symptomeimpl.update_symptome(symptome);
		
		/*Test suppression*/
		
		//symptomeimpl.delete_symptome(symptome);
		
		/*test de la recherche*/
		
		/*Symtome sym = new Symtome();
		sym = symptomeimpl.find_symptone(2);
		System.out.println("le nom est:"+sym.getNom()+"et la description est:"+sym.getDescription());
		*/
		/*Test de la liste de tous les symptomes*/
		
		//recupération de tous les symptomes das une liste
		
		List<Symtome> listSymptome = symptomeimpl.list_symptome();
		
		// on arcourt chaque symptome de la liste et on affiche
		
		for(Symtome symptom: listSymptome){
			System.out.println("le nom est:"+" "+symptom.getNom()+" "+"et la description est:"+symptom.getDescription());
		}
	}

}
