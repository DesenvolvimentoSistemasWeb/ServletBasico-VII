package br.edu.estacio.domain;

import java.util.Collection;
import java.util.HashMap;

public class Pessoas {

	private HashMap<Long,Pessoa> pessoas = new HashMap<Long,Pessoa>();
	
	public void add(Long l,Pessoa pessoa){
		pessoas.put(l,pessoa);
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
