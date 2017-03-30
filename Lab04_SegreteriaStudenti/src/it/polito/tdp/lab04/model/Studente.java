package it.polito.tdp.lab04.model;

import java.util.*;

public class Studente {
	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	private LinkedList<Corso> corsi=new LinkedList<Corso>();
	
	public Studente(int matricola, String cognome, String nome) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCds() {
		return cds;
	}
	public void setCds(String cds) {
		this.cds = cds;
	}
	
	public void setCorsoIn(Corso c){
		corsi.add(c);
	}
	/**
	 * @return the corsi
	 */
	public LinkedList<Corso> getCorsi() {
		return corsi;
	}
	
	
	
	
	
	
	
}
