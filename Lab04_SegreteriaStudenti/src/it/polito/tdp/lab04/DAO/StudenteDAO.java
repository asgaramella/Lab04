package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente completaDatiStudenti(int mat){
		Studente result=null;
		String sql= "SELECT MATRICOLA,NOME,COGNOME "+
				"FROM STUDENTE "+
				"WHERE MATRICOLA=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1,mat);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Studente stud=new Studente(rs.getInt("matricola"),rs.getString("cognome"), rs.getString("nome"));
				result=stud;
			}
			conn.close();

	

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		
		}
		return result;
		
	}
	
	public void getCorsiStudente (Studente studente) {
		String sql ="SELECT c.codins,c.crediti,c.pd,c.nome "+
				"FROM studente as s,corso as c,iscrizione as i "+
				"WHERE i.codins=c.codins and i.matricola=s.matricola and s.matricola=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, Integer.toString(studente.getMatricola()));

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String codins=rs.getString("c.codins");
				String nome=rs.getString("c.nome");
				int crediti=rs.getInt("c.crediti");
				int pd=rs.getInt("c.pd");
				Corso temp=new Corso(codins,crediti,nome,pd);
				studente.setCorsoIn(temp);
			}
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	public boolean checkIscrittoA(Corso c,int m) {
		boolean iscritto=false;
		String  sql="SELECT * "+
				"FROM iscrizione "+
				"WHERE matricola=? and codins=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, Integer.toString(m));
			st.setString(2, c.getCodice());

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				iscritto=true;
			}else{
				iscritto=false;
			}
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return iscritto;
		
	}
	



}
