package br.edu.estacio.domain;

import java.util.Collection;
import java.util.HashMap;

public class Pessoas {

	private HashMap<Integer,Pessoa> pessoas = new HashMap<Integer,Pessoa>();
	
	public void add(Integer codigo,Pessoa pessoa){
		pessoas.put(codigo, pessoa);
	}
	
	public Collection<Pessoa> getPessoas(){
		return pessoas.values();
	}
	
	public void removeByCodigo(Integer codigo){
		pessoas.remove(codigo);
	}
	
	public Pessoa findByCodigo(Integer codigo){
		return pessoas.get(codigo);
	}
	
}
