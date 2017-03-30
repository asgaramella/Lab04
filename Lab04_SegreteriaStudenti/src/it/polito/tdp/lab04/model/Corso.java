package it.polito.tdp.lab04.model;

import java.util.*;

public class Corso {
	
	private String codice;
	private int crediti;
	private String nome;
	private int pd;
	private List<Studente> studenti=new LinkedList<Studente>();
	
	public Corso(String codice, int crediti, String nome, int pd) {
		super();
		this.codice = codice;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPd() {
		return pd;
	}
	public void setPd(int pd) {
		this.pd = pd;
	}
	
	public void setStudenteIn(Studente s){
		studenti.add(s);
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return nome;
	}

	
	

}
