package com.metier.Interface;

import java.util.List;

import com.metier.entities.Symtome;

public interface SymptomeInterface {
public void create_Symptome(Symtome sem);
public void update_Symptome(Symtome sem);
public void delete_symptome(Symtome sem);
public Symtome find_Symptome(int symptome_id);
public List<Symtome> liste_symptome();

}
