package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	public List<Corso> corsi;
	
	
	
	public Model() {
		super();
		
	}


  
  public List<Corso> getNomiCorsi(){
	  CorsoDAO dao= new CorsoDAO();
	  return dao.getTuttiICorsi();
	 
  }
  
  public Studente studenteCercato(int mat){
	  StudenteDAO dao= new StudenteDAO();
	  return dao.completaDatiStudenti(mat);
	  
  }
  
  
  public LinkedList<Studente> iscritti(Corso c){
	  CorsoDAO dao=new CorsoDAO();
	  dao.getStudentiIscrittiAlCorso(c);
	  LinkedList<Studente> stemp=new LinkedList<Studente>(c.getStudenti());
	  return stemp;
	  }
 
  public LinkedList<Corso> corsiFrequentati(Studente s){
	  StudenteDAO dao=new StudenteDAO();
	  dao.getCorsiStudente(s);
	  LinkedList<Corso> ctemp=new LinkedList<Corso>(s.getCorsi());
	  return ctemp;
  }
  
  public boolean isIscritto(Corso c,int matricola){
	  StudenteDAO dao=new StudenteDAO();
	   return dao.checkIscrittoA(c, matricola);
  }
  
  public boolean iscriviStudente(Corso c, Studente s){
	  CorsoDAO dao= new CorsoDAO();
	  return dao.inscriviStudenteACorso(s, c);
	  
  }


	
	
	

}
