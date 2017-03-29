package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	public List<Corso> corsi;
	
	
	
	public Model() {
		super();
		
	}


  
  public List<String> getNomiCorsi(){
	  CorsoDAO dao= new CorsoDAO();
	  corsi=new LinkedList<Corso>(dao.getTuttiICorsi());
	  LinkedList<String> ltemp=new LinkedList<String>();
	  for(Corso ctemp:corsi)
		  ltemp.add(ctemp.getNome());
	  return ltemp;
  }
  
  public Studente studenteCercato(int mat){
	  StudenteDAO dao= new StudenteDAO();
	  return dao.completaDatiStudenti(mat);
	  
  }
  
  
  public LinkedList<Corso> iscritti(Corso c){
	  CorsoDAO dao=new CorsoDAO();
	  dao.getStudentiIscrittiAlCorso(c);
	  
	 
	  
	  
  }
  
  //public Corso getCorso(String nome){
	 for()
	  return 
  }

	
	
	

}
