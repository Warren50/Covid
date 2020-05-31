package com.metier.Interface;

import com.metier.entities.Symtome;
import java.util.List;

public interface SymptomeInterface {

	public void create_symptome(Symtome symptome);
	public void update_symptome(Symtome symptome);
	public void delete_symptome(Symtome symptome);
	public Symtome find_symptone(int symptome_id);
	public List<Symtome> list_symptome();
}
